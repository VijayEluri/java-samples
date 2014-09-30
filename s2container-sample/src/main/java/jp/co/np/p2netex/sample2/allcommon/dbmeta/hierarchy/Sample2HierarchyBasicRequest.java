package jp.co.np.p2netex.sample2.allcommon.dbmeta.hierarchy;


import jp.co.np.p2netex.sample2.allcommon.Sample2Entity;
import jp.co.np.p2netex.sample2.allcommon.dbmeta.Sample2DBMeta;
import jp.co.np.p2netex.sample2.allcommon.dbmeta.info.Sample2ColumnInfo;

/**
 * The basic request of hierarchy.
 * 
 * @author DBFlute(AutoGenerator)
 * @param <LOCAL_ENTITY> The type of local entity.
 * @param <LOCAL_RELATION_TRACE> The type of local relation trace.
 */
@SuppressWarnings("unchecked")
public class Sample2HierarchyBasicRequest<LOCAL_ENTITY extends Sample2Entity, LOCAL_RELATION_TRACE extends Sample2DBMeta.RelationTrace> extends Sample2HierarchyRequest<LOCAL_ENTITY> {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected Sample2ColumnInfo _currentSourceColumnInfo;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    /**
     * Constructor.
     * 
     * @param localEntityType The type of local entity. (NotNull)
     */
    public Sample2HierarchyBasicRequest(Class<LOCAL_ENTITY> localEntityType) {
        super(localEntityType);
    }

    // ===================================================================================
    //                                                                         Easy-to-Use
    //                                                                         ===========
    // -----------------------------------------------------
    //                                                public
    //                                                ------
    /**
     * Set up source.
     * 
     * @param sourceColumnInfo The column info of source. (NotNull)
     * @return Destination relation trace. (NotNull)
     */
    public DestinationRelationTrace<LOCAL_RELATION_TRACE> src(Sample2ColumnInfo sourceColumnInfo) {
        this._currentSourceColumnInfo = sourceColumnInfo;
        final Sample2HierarchyBasicRequest<LOCAL_ENTITY, LOCAL_RELATION_TRACE> outer = this;
        return new DestinationRelationTrace<LOCAL_RELATION_TRACE>() {
            public LOCAL_RELATION_TRACE dst() {
                return outer.dst();
            }
        };
    }

    /**
     * Set up destination.
     * 
     * @return Local relation trace. (NotNull)
     */
    public LOCAL_RELATION_TRACE dst() {
        final Sample2DBMeta.RelationTraceFixHandler handler = new Sample2DBMeta.RelationTraceFixHandler() {
            public void handleFixedTrace(Sample2DBMeta.RelationTrace relationTrace) {
                mapping(_currentSourceColumnInfo, relationTrace);
            }
        };
        final Object target = destinationDBMeta;
        java.lang.reflect.Method method = null;
        try {
            method = target.getClass().getMethod("createRelationTrace", new Class[]{Sample2DBMeta.RelationTraceFixHandler.class});
        } catch (NoSuchMethodException e) {
            String msg = "Not found method: method=createRelationTrace(Sample2DBMeta.RelationTraceFixHandler)";
            throw new IllegalStateException(msg, e);
        }
        try {
            return (LOCAL_RELATION_TRACE)method.invoke(target, new Object[]{handler});
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        } catch (java.lang.reflect.InvocationTargetException e) {
            throw new IllegalStateException(e.getCause());
        }
    }

    public static interface DestinationRelationTrace<LOCAL_RELATION_TRACE> {
        public LOCAL_RELATION_TRACE dst();
    }
}
