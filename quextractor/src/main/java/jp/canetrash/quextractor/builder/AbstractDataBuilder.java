package jp.canetrash.quextractor.builder;

import javax.sql.DataSource;

import jp.canetrash.quextractor.context.Context;
import jp.canetrash.quextractor.handler.MappingHandler;


public abstract class AbstractDataBuilder implements DataBuilder {
    
    private Context ctx;
    private DataSource dataSource;
    private MappingHandler[] mappingHandlers;

    public Context getContext() {
        return ctx;
    }

    public void setContext(Context newCtx) {
       this.ctx = newCtx; 
    }

    public DataSource getDataSource() {
        return this.dataSource;
    }

    public void setDataSource(DataSource newDataSource) {
        this.dataSource = newDataSource;
    }
    
    /**
     * @return Returns the mappingHandlers.
     */
    public MappingHandler[] getMappingHandlers() {
        return mappingHandlers;
    }
    
    /**
     * @param mappingHandlers The mappingHandlers to set.
     */
    public void setMappingHandlers(MappingHandler[] mappingHandlers) {
        this.mappingHandlers = mappingHandlers;
    }
}
