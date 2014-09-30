package jp.co.np.p2netex.sample1.bsentity;

import java.util.*;
    
import jp.co.np.p2netex.sample1.allcommon.Sample1Entity;
import jp.co.np.p2netex.sample1.allcommon.dbmeta.Sample1DBMeta;
import jp.co.np.p2netex.sample1.allcommon.dbmeta.Sample1DBMetaInstanceHandler;
import jp.co.np.p2netex.sample1.exentity.*;

/**
 * The entity of SAMPLE1_DEPT(TABLE).
 * <pre>
 * [primary-key]
 *     ID
 * 
 * [column]
 *     ID, NAME, VERSION_NO
 * 
 * [sequence]
 *     
 * 
 * [identity]
 *     
 * 
 * [version-no]
 *     VERSION_NO
 * 
 * [foreign-table]
 *     
 * 
 * [referrer-table]
 *     SAMPLE1_EMP
 * 
 * [foreign-property]
 *     
 * 
 * [referrer-property]
 *     sample1EmpList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public abstract class Sample1BsSample1Dept implements Sample1Entity, java.io.Serializable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    /** TABLE-Annotation for S2Dao. The value is SAMPLE1_DEPT. */
    public static final String TABLE = "SAMPLE1_DEPT";

    
    /** VERSION_NO-Annotation */
    public static final String VERSION_NO_PROPERTY = "versionNo";

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // -----------------------------------------------------
    //                                                Column
    //                                                ------
    /** The attribute of the column 'ID'. {PK : INTEGER : NotNull} */
    protected java.lang.Integer _id;

    /** The attribute of the column 'NAME'. {VARCHAR(20)} */
    protected String _name;

    /** The attribute of the column 'VERSION_NO'. {INTEGER} */
    protected java.lang.Integer _versionNo;

    // -----------------------------------------------------
    //                                              Internal
    //                                              --------
    /** The attribute of entity modified properties. (for S2Dao) */
    protected EntityModifiedProperties _modifiedProperties = newEntityModifiedProperties();
    
    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Sample1BsSample1Dept() {
    }

    // ===================================================================================
    //                                                                          Table Name
    //                                                                          ==========
    public String getTableDbName() {
        return "SAMPLE1_DEPT";
    }

    public String getTablePropertyName() {// as JavaBeansRule
        return "sample1Dept";
    }

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    public Sample1DBMeta getDBMeta() {
        return Sample1DBMetaInstanceHandler.findDBMeta(getTableDbName());
    }

    // ===================================================================================
    //                                                          Classification Classifying
    //                                                          ==========================
      
    // ===================================================================================
    //                                                        Classification Determination
    //                                                        ============================
      

    // ===================================================================================
    //                                                           Classification Name/Alias
    //                                                           =========================
      

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    // /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
    //   Referrer Property = [sample1EmpList]
    // * * * * * * * * */

    /** The entity list of referrer property 'sample1EmpList'. */
    protected List<Sample1Sample1Emp> _childrenSample1EmpList;

    /**
     * Get the entity list of referrer property 'sample1EmpList'. {without lazy-load} <br />
     * @return The entity list of referrer property 'sample1EmpList'. (NotNull: If it's not loaded yet, initializes the list instance of referrer as empty and returns it.)
     */
    public List<Sample1Sample1Emp> getSample1EmpList() {
        if (_childrenSample1EmpList == null) { _childrenSample1EmpList = new ArrayList<Sample1Sample1Emp>(); }
        return _childrenSample1EmpList;
    }

    /**
     * Set the entity list of referrer property 'sample1EmpList'.
     * @param sample1EmpList The entity list of referrer property 'sample1EmpList'. (Nullable)
     */
    public void setSample1EmpList(List<Sample1Sample1Emp> sample1EmpList) {
        _childrenSample1EmpList = sample1EmpList;
    }


    // ===================================================================================
    //                                                                       Determination
    //                                                                       =============
    public boolean hasPrimaryKeyValue() {
        if (_id == null) { return false; }
        return true;
    }

    // ===================================================================================
    //                                                                 Modified Properties
    //                                                                 ===================
    public Set<String> getModifiedPropertyNames() {
        return _modifiedProperties.getPropertyNames();
    }

    protected EntityModifiedProperties newEntityModifiedProperties() {
        return new EntityModifiedProperties();
    }

    public void clearModifiedPropertyNames() {
        _modifiedProperties.clear();
    }

    public boolean hasModification() {
        return !_modifiedProperties.isEmpty();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    /**
     * If the primary-key of the other is same as this one, returns true.
     * @param other Other entity.
     * @return Comparing result.
     */
    public boolean equals(Object other) {
        if (other == null || !(other instanceof Sample1BsSample1Dept)) { return false; }
        final Sample1BsSample1Dept otherEntity = (Sample1BsSample1Dept)other;
        if (!helpComparingValue(getId(), otherEntity.getId())) { return false; }
        return true;
    }

    protected boolean helpComparingValue(Object value1, Object value2) {
        if (value1 == null && value2 == null) { return true; }
        return value1 != null && value2 != null && value1.equals(value2);
    }

    /**
     * Calculates hash-code from primary-key.
     * @return Hash-code from primary-keys.
     */
    public int hashCode() {
        int result = 17;
        if (this.getId() != null) { result = result + getId().hashCode(); }
        return result;
    }

    /**
     * @return The view string of columns. (NotNull)
     */
    public String toString() {
        final String delimiter = ",";
        final StringBuilder sb = new StringBuilder();

        sb.append(delimiter).append(getId());
        sb.append(delimiter).append(getName());
        sb.append(delimiter).append(getVersionNo());

        sb.delete(0, delimiter.length());
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========

    /** The column annotation for S2Dao. {PK : INTEGER : NotNull} */
    public static final String id_COLUMN = "ID";

    /**
     * Get the value of the column 'ID'. <br />
     * {PK : INTEGER : NotNull}
     * @return The value of the column 'ID'. (Nullable)
     */
    public java.lang.Integer getId() {
        return _id;
    }

    /**
     * Set the value of the column 'ID'. <br />
     * {PK : INTEGER : NotNull}
     * @param id The value of the column 'ID'. (Nullable)
     */
    public void setId(java.lang.Integer id) {
        _modifiedProperties.addPropertyName("id");
        this._id = id;
    }

    /** The column annotation for S2Dao. {VARCHAR(20)} */
    public static final String name_COLUMN = "NAME";

    /**
     * Get the value of the column 'NAME'. <br />
     * {VARCHAR(20)}
     * @return The value of the column 'NAME'. (Nullable)
     */
    public String getName() {
        return _name;
    }

    /**
     * Set the value of the column 'NAME'. <br />
     * {VARCHAR(20)}
     * @param name The value of the column 'NAME'. (Nullable)
     */
    public void setName(String name) {
        _modifiedProperties.addPropertyName("name");
        this._name = name;
    }

    /** The column annotation for S2Dao. {INTEGER} */
    public static final String versionNo_COLUMN = "VERSION_NO";

    /**
     * Get the value of the column 'VERSION_NO'. <br />
     * {INTEGER}
     * @return The value of the column 'VERSION_NO'. (Nullable)
     */
    public java.lang.Integer getVersionNo() {
        return _versionNo;
    }

    /**
     * Set the value of the column 'VERSION_NO'. <br />
     * {INTEGER}
     * @param versionNo The value of the column 'VERSION_NO'. (Nullable)
     */
    public void setVersionNo(java.lang.Integer versionNo) {
        _modifiedProperties.addPropertyName("versionNo");
        this._versionNo = versionNo;
    }

}
