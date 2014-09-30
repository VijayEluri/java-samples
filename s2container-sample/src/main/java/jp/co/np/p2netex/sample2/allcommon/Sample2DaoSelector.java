package jp.co.np.p2netex.sample2.allcommon;

/**
 * The interface of DAO-selector.
 * @author DBFlute(AutoGenerator)
 */
public interface Sample2DaoSelector {

    /**
     * Select DAO.
     * @param <DAO> The type of DAO.
     * @param daoType DAO type. (NotNull)
     * @return Dao. (NotNull)
     */
    public <DAO extends Sample2DaoReadable> DAO select(Class<DAO> daoType);

    /**
     * Select DAO-readable by name.
     * @param tableFlexibleName Table flexible name. (NotNull)
     * @return DAO-readable. (NotNull)
     */
    public Sample2DaoReadable byName(String tableFlexibleName);
}
