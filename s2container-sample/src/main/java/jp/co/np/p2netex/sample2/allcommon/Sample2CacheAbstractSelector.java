package jp.co.np.p2netex.sample2.allcommon;

import org.seasar.framework.container.S2Container;

/**
 * The abstract class of cache-selector.
 * @author DBFlute(AutoGenerator)
 */
@SuppressWarnings("unchecked")
public abstract class Sample2CacheAbstractSelector {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** The container of Seasar. */
    protected S2Container _container;

    // ===================================================================================
    //                                                                           Component
    //                                                                           =========
	public <COMPONENT> COMPONENT getComponent(Class<COMPONENT> componentType) {
		assertObjectNotNull("componentType", componentType);
		assertObjectNotNull("_container", _container);
		return (COMPONENT)_container.getComponent(componentType);
	}
	
    // ===================================================================================
    //                                                                             Destroy
    //                                                                             =======
    public void destroy() {
        _container = null;
    }

    // ===================================================================================
    //                                                                              Helper
    //                                                                              ======
    protected String initUncap(String str) {
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }
	
    // ===================================================================================
    //                                                                              Assert
    //                                                                              ======
    // -----------------------------------------------------
    //                                         Assert Object
    //                                         -------------
    /**
     * Assert that the object is not null.
     * @param variableName Variable name. (NotNull)
     * @param value Value. (NotNull)
     * @exception IllegalArgumentException
     */
    protected void assertObjectNotNull(String variableName, Object value) {
        if (variableName == null) {
            String msg = "The value should not be null: variableName=" + variableName + " value=" + value;
            throw new IllegalArgumentException(msg);
        }
        if (value == null) {
            String msg = "The value should not be null: variableName=" + variableName;
            throw new IllegalArgumentException(msg);
        }
    }

    // -----------------------------------------------------
    //                                         Assert String
    //                                         -------------
    /**
     * Assert that the entity is not null and not trimmed empty.
     * @param variableName Variable name. (NotNull)
     * @param value Value. (NotNull)
     */
    protected void assertStringNotNullAndNotTrimmedEmpty(String variableName, String value) {
        assertObjectNotNull("variableName", variableName);
        assertObjectNotNull("value", value);
        if (value.trim().length() ==0) {
            String msg = "The value should not be empty: variableName=" + variableName + " value=" + value;
            throw new IllegalArgumentException(msg);
        }
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public void setContainer(S2Container container) {
        this._container = container;
    }
}
