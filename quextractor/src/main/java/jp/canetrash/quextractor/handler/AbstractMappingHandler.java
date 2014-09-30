package jp.canetrash.quextractor.handler;

import jp.canetrash.quextractor.context.Context;

public abstract class AbstractMappingHandler implements MappingHandler {
    private Context ctx;
    private String keyAttribute;
    private String columnName;
    private String defaultValue;
    private String constantValue;
    private String sqlType;

    public String getConstantValue() {
        return constantValue;
    }

    public String getSqlType() {
        return sqlType;
    }

    public void setSqlType(String type) {
        this.sqlType = type;
    }

    public void setConstantValue(String constantValue) {
        this.constantValue = constantValue;
    }


    /**
     * {@inheritDoc}
     */
    public void setContext(Context newCtx) {
        this.ctx = newCtx;
    }

    /**
     * {@inheritDoc}
     */
    public Context getContext() {
        return ctx;
    }

    /**
     * @return Returns the keyAttribute.
     */
    public String getKeyAttribute() {
        return keyAttribute;
    }

    /**
     * @param excelKeyAttribute The excelKeyAttribute to set.
     */
    public void setKeyAttribute(String keyAttribute) {
        this.keyAttribute = keyAttribute;
    }

    /**
     * {@inheritDoc}
     */
    public String getColumnName() {
        return this.columnName;
    }

    /**
     * {@inheritDoc}
     */
    public void setColumnName(String newColumnName) {
        this.columnName = newColumnName;
        
    }
	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
}
