package jp.co.np.p2netex.sample1.allcommon;

import jp.co.np.p2netex.sample1.allcommon.Sample1DaoReadable;
import jp.co.np.p2netex.sample1.allcommon.Sample1DaoSelector;
import jp.co.np.p2netex.sample1.allcommon.dbmeta.Sample1DBMeta;
import jp.co.np.p2netex.sample1.allcommon.dbmeta.Sample1DBMetaInstanceHandler;

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
public class Sample1CacheDaoSelector extends Sample1CacheAbstractSelector implements Sample1DaoSelector {

    // ===================================================================================
    //                                                                            Selector
    //                                                                            ========
    /**
     * Select DAO.
     * @param <DAO> The type of DAO.
     * @param daoType DAO type. (NotNull)
     * @return DAO. (NotNull)
     */
    public <DAO extends Sample1DaoReadable> DAO select(Class<DAO> daoType) {
        return (DAO)getComponent(daoType);
    }

    /**
     * Select DAO-readable by name.
     * @param tableFlexibleName Table flexible name. (NotNull)
     * @return DAO-readable. (NotNull)
     */
    public Sample1DaoReadable byName(String tableFlexibleName) {
        assertStringNotNullAndNotTrimmedEmpty("tableFlexibleName", tableFlexibleName);
        final Sample1DBMeta dbmeta = Sample1DBMetaInstanceHandler.findDBMeta(tableFlexibleName);
        return select(getDaoType(dbmeta));
    }

    protected Class<Sample1DaoReadable> getDaoType(Sample1DBMeta dbmeta) {
        final String daoTypeName = dbmeta.getDaoTypeName();
        if (daoTypeName == null) {
            String msg = "The dbmeta.getDaoTypeName() should not return null: dbmeta=" + dbmeta;
            throw new IllegalStateException(msg);
        }
        final Class<Sample1DaoReadable> daoType;
        try {
            daoType = (Class<Sample1DaoReadable>)Class.forName(daoTypeName);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("The class does not exist: " + daoTypeName, e);
        }
        return daoType;
    }
}
