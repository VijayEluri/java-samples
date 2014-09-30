package jp.co.np.p2netex.sample1.allcommon.s2dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.DatabaseMetaData;

import org.seasar.dao.BeanAnnotationReader;
import org.seasar.dao.ColumnNaming;
import org.seasar.dao.DaoNamingConvention;
import org.seasar.dao.Dbms;
import org.seasar.dao.PropertyTypeFactory;
import org.seasar.dao.ValueTypeFactory;
import org.seasar.dao.impl.FastPropertyTypeFactory;
import org.seasar.dao.impl.FastPropertyTypeFactoryBuilder;
import org.seasar.extension.jdbc.PropertyType;
import org.seasar.framework.beans.BeanDesc;
import org.seasar.framework.beans.PropertyDesc;

import jp.co.np.p2netex.sample1.allcommon.Sample1Entity;
import jp.co.np.p2netex.sample1.allcommon.dbmeta.Sample1DBMeta;

/**
 * The factory builder of property type for S2Dao. {Since S2Dao-1.0.47} <br />
 * 
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public class Sample1S2DaoPropertyTypeFactoryBuilderExtension extends FastPropertyTypeFactoryBuilder {

    @Override
    public PropertyTypeFactory build(Class beanClass, BeanAnnotationReader beanAnnotationReader) {
        return new FastPropertyTypeFactoryExtension(beanClass, beanAnnotationReader, valueTypeFactory, columnNaming);
    }

    @Override
    public PropertyTypeFactory build(Class beanClass, BeanAnnotationReader beanAnnotationReader, Dbms dbms, DatabaseMetaData databaseMetaData) {
        return new FastPropertyTypeFactoryExtension(beanClass, beanAnnotationReader, valueTypeFactory, columnNaming, daoNamingConvention, dbms);
    }

    protected static class FastPropertyTypeFactoryExtension extends FastPropertyTypeFactory {

        protected Sample1DBMeta _dbmeta;

        public FastPropertyTypeFactoryExtension(Class beanClass, BeanAnnotationReader beanAnnotationReader,
                ValueTypeFactory valueTypeFactory, ColumnNaming columnNaming) {
            super(beanClass, beanAnnotationReader, valueTypeFactory, columnNaming);
            if (isEntity()) {
                _dbmeta = findDBMeta();
            }
        }

        public FastPropertyTypeFactoryExtension(Class beanClass, BeanAnnotationReader beanAnnotationReader,
                ValueTypeFactory valueTypeFactory, ColumnNaming columnNaming, DaoNamingConvention daoNamingConvention,
                Dbms dbms) {
            super(beanClass, beanAnnotationReader, valueTypeFactory, columnNaming, daoNamingConvention, dbms);
            if (isEntity()) {
                _dbmeta = findDBMeta();
            }
        }

        protected boolean isEntity() {
            return Sample1Entity.class.isAssignableFrom(beanClass);
        }

        protected Sample1DBMeta findDBMeta() {
            try {
                final Sample1Entity entity = (Sample1Entity) beanClass.newInstance();
                return entity.getDBMeta();
            } catch (Exception e) {
                String msg = "beanClass.newInstance() threw the exception: beanClass=" + beanClass;
                throw new RuntimeException(msg, e);
            }
        }

        @Override
        protected boolean isPrimaryKey(PropertyDesc propertyDesc) {
            if (isEntity() && _dbmeta.hasPrimaryKey() && _dbmeta.hasColumn(propertyDesc.getPropertyName())) {
                if (_dbmeta.findColumnInfo(propertyDesc.getPropertyName()).isPrimary()) {
                    return true;
                }
            }
            return super.isPrimaryKey(propertyDesc);
        }

        @Override
        public PropertyType[] createBeanPropertyTypes(String tableName) {
            final List<PropertyType> list = new ArrayList<PropertyType>();
            final BeanDesc beanDesc = getBeanDesc();
            for (int i = 0; i < beanDesc.getPropertyDescSize(); ++i) {
                final PropertyDesc pd = beanDesc.getPropertyDesc(i);
                
                // Read-only property is unnecessary! {Extension of S2Dao}
                if (!pd.hasWriteMethod()) {
                    continue;
                }
                
                if (isRelation(pd)) {
                    continue;
                }
                final PropertyType pt = createPropertyType(pd);
                pt.setPrimaryKey(isPrimaryKey(pd));
                pt.setPersistent(isPersistent(pt));
                list.add(pt);
            }
            return list.toArray(new PropertyType[list.size()]);
        }
		
        @Override
        protected boolean isPersistent(PropertyType propertyType) {
            // - - - - - - - - - - - - - - - - - - - - - - - - - - - -
            // The columns that has column annotation are persistent.
            // - - - - - - - - - - - - - - - - - - - - - - - - - - - -
            if (beanAnnotationReader.getColumnAnnotation(propertyType.getPropertyDesc()) == null) {
                return false;
            }
			
            return super.isPersistent(propertyType);
        }
    }
}
