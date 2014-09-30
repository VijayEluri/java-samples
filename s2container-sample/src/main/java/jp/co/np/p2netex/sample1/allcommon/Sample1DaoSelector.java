package jp.co.np.p2netex.sample1.allcommon;

/**
 * The interface of DAO-selector.
 * @author DBFlute(AutoGenerator)
 */
public interface Sample1DaoSelector {

    /**
     * Select DAO.
     * @param <DAO> The type of DAO.
     * @param daoType DAO type. (NotNull)
     * @return Dao. (NotNull)
     */
    public <DAO extends Sample1DaoReadable> DAO select(Class<DAO> daoType);

    /**
     * Select DAO-readable by name.
     * @param tableFlexibleName Table flexible name. (NotNull)
     * @return DAO-readable. (NotNull)
     */
    public Sample1DaoReadable byName(String tableFlexibleName);
}
