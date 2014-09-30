package jp.co.np.p2netex.sample2.allcommon;

import jp.co.np.p2netex.sample2.allcommon.Sample2DaoReadable;
import jp.co.np.p2netex.sample2.allcommon.Sample2DaoSelector;
import jp.co.np.p2netex.sample2.allcommon.dbmeta.Sample2DBMeta;
import jp.co.np.p2netex.sample2.allcommon.dbmeta.Sample2DBMetaInstanceHandler;

/**
 * The implementation of DAO-selector.
 * <pre>
 * Long long ago this object have cache of DAO and behavior.
 * But the cache cause wrong performance when this is initialized.
 * So now this object don't have cache.
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public class Sample2CacheDaoSelector extends Sample2CacheAbstractSelector implements Sample2DaoSelector {

    // ===================================================================================
    //                                                                            Selector
    //                                                                            ========
    /**
     * Select DAO.
     * @param <DAO> The type of DAO.
     * @param daoType DAO type. (NotNull)
     * @return DAO. (NotNull)
     */
    public <DAO extends Sample2DaoReadable> DAO select(Class<DAO> daoType) {
        return (DAO)getComponent(daoType);
    }

    /**
     * Select DAO-readable by name.
     * @param tableFlexibleName Table flexible name. (NotNull)
     * @return DAO-readable. (NotNull)
     */
    public Sample2DaoReadable byName(String tableFlexibleName) {
        assertStringNotNullAndNotTrimmedEmpty("tableFlexibleName", tableFlexibleName);
        final Sample2DBMeta dbmeta = Sample2DBMetaInstanceHandler.findDBMeta(tableFlexibleName);
        return select(getDaoType(dbmeta));
    }

    protected Class<Sample2DaoReadable> getDaoType(Sample2DBMeta dbmeta) {
        final String daoTypeName = dbmeta.getDaoTypeName();
        if (daoTypeName == null) {
            String msg = "The dbmeta.getDaoTypeName() should not return null: dbmeta=" + dbmeta;
            throw new IllegalStateException(msg);
        }
        final Class<Sample2DaoReadable> daoType;
        try {
            daoType = (Class<Sample2DaoReadable>)Class.forName(daoTypeName);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("The class does not exist: " + daoTypeName, e);
        }
        return daoType;
    }
}
