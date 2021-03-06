package jp.co.np.p2netex.sample2.allcommon.s2dao.internal.rshandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.seasar.extension.jdbc.PropertyType;
import org.seasar.extension.jdbc.ValueType;
import org.seasar.framework.beans.PropertyDesc;
import org.seasar.dao.BeanMetaData;
import org.seasar.dao.RelationPropertyType;
import org.seasar.dao.RelationRowCreator;
import org.seasar.dao.RowCreator;
import org.seasar.dao.impl.AbstractBeanMetaDataResultSetHandler;
import org.seasar.dao.impl.RelationKey;
import org.seasar.dao.impl.RelationRowCache;

/**
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public class Sample2InternalBeanListMetaDataResultSetHandler extends AbstractBeanMetaDataResultSetHandler {

	// ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    /**
	 * @param beanMetaData Bean meta data. (NotNull)
     * @param rowCreator Row creator. (NotNull)
     * @param relationRowCreator Relation row creator. (NotNul)
     */
    public Sample2InternalBeanListMetaDataResultSetHandler(BeanMetaData beanMetaData, RowCreator rowCreator, RelationRowCreator relationRowCreator) {
        super(beanMetaData, rowCreator, relationRowCreator);
    }
	
	// ===================================================================================
    //                                                                              Handle
    //                                                                              ======
    public Object handle(ResultSet rs) throws SQLException {
        // Set<String(columnName)>
        Set columnNames = null;

        // Map<String(columnName), PropertyType>
        Map propertyCache = null;// [DAO-118] (2007/08/26)

        // Map<String(relationNoSuffix), Map<String(columnName), PropertyType>>
        Map relationPropertyCache = null;// [DAO-118] (2007/08/25)

        final List list = new ArrayList();
        final int relSize = getBeanMetaData().getRelationPropertyTypeSize();
        final RelationRowCache relRowCache = new RelationRowCache(relSize);

        while (rs.next()) {
            // Lazy initialization because if the result is zero, the cache is unused.
			if (columnNames == null) {
			    columnNames = createColumnNames(rs.getMetaData());
			}
            if (propertyCache == null) {
                propertyCache = createPropertyCache(columnNames);
            }
            if (relationPropertyCache == null) {
                relationPropertyCache = createRelationPropertyCache(columnNames);
            }

            // Create row instance of base table by row property cache.
            final Object row = createRow(rs, propertyCache);

            for (int i = 0; i < relSize; ++i) {
                RelationPropertyType rpt = getBeanMetaData().getRelationPropertyType(i);
                if (rpt == null) {
                    continue;
                }
                Object relationRow = null;
                Map relKeyValues = new HashMap();
				// /- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
				// If it returns null at first record, may it be unnecessary after second records?
				// - - - - - - - - - -/
                RelationKey relKey = createRelationKey(rs, rpt, columnNames, relKeyValues);
                if (relKey != null) {
                    relationRow = relRowCache.getRelationRow(i, relKey);
                    if (relationRow == null) {
                        relationRow = createRelationRow(rs, rpt, columnNames, relKeyValues, relationPropertyCache);
                        relRowCache.addRelationRow(i, relKey, relationRow);
                    }
                }
                if (relationRow != null) {
                    PropertyDesc pd = rpt.getPropertyDesc();
                    pd.setValue(row, relationRow);
                    postCreateRow(relationRow);
                }
            }
            postCreateRow(row);
            list.add(row);
        }
        return list;
    }

    protected RelationKey createRelationKey(ResultSet rs, RelationPropertyType rpt, Set columnNames, Map relKeyValues) throws SQLException {
        List keyList = new ArrayList();
        BeanMetaData bmd = rpt.getBeanMetaData();
        for (int i = 0; i < rpt.getKeySize(); ++i) {
            /*
             * PropertyType pt = bmd
             * .getPropertyTypeByColumnName(rpt.getYourKey(i)); ValueType
             * valueType = pt.getValueType(); String columnName =
             * pt.getColumnName() + "_" + rpt.getRelationNo();
             */
            ValueType valueType = null;
            String columnName = rpt.getMyKey(i);
            if (columnNames.contains(columnName)) {
                PropertyType pt = getBeanMetaData().getPropertyTypeByColumnName(columnName);
                valueType = pt.getValueType();
            } else {
                PropertyType pt = bmd.getPropertyTypeByColumnName(rpt.getYourKey(i));
                columnName = pt.getColumnName() + "_" + rpt.getRelationNo();
                if (columnNames.contains(columnName)) {
                    valueType = pt.getValueType();
                } else {
                    return null;
                }
            }
            Object value = valueType.getValue(rs, columnName);
            if (value == null) {
                return null;
            }
            relKeyValues.put(columnName, value);
            keyList.add(value);
        }
        if (keyList.size() > 0) {
            Object[] keys = keyList.toArray();
            return new RelationKey(keys);
        } else {
            return null;
        }
    }
}
