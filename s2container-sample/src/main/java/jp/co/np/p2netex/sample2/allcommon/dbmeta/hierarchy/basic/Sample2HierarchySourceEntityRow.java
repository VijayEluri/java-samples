package jp.co.np.p2netex.sample2.allcommon.dbmeta.hierarchy.basic;


/**
 * @author DBFlute(AutoGenerator)
 */
public class Sample2HierarchySourceEntityRow implements jp.co.np.p2netex.sample2.allcommon.dbmeta.hierarchy.Sample2HierarchySourceRow {

    protected Object sourceBean;

    public Sample2HierarchySourceEntityRow(Object sourceBean) {
        this.sourceBean = sourceBean;
    }

    public Object extractColumnValue(jp.co.np.p2netex.sample2.allcommon.dbmeta.hierarchy.Sample2HierarchySourceColumn columnInfo) {
        if (!(columnInfo instanceof Sample2HierarchySourceEntityColumn)) {
            String msg = "The column info should be Sample2HierarchySourceEntityColumn! but: " + columnInfo;
            throw new IllegalStateException(msg);
        }
        final Sample2HierarchySourceEntityColumn sourceEntityColumn = (Sample2HierarchySourceEntityColumn) columnInfo;
        return invoke(sourceEntityColumn.findGetter(), sourceBean, new Object[] {});
    }

    private Object invoke(java.lang.reflect.Method method, Object target, Object[] args) {
        try {
            return method.invoke(target, args);
        } catch (java.lang.reflect.InvocationTargetException ex) {
            Throwable t = ex.getCause();
            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            }
            if (t instanceof Error) {
                throw (Error) t;
            }
            String msg = "target=" + target + " method=" + method + "-" + java.util.Arrays.asList(args);
            throw new RuntimeException(msg, ex);
        } catch (IllegalAccessException ex) {
            String msg = "target=" + target + " method=" + method + "-" + java.util.Arrays.asList(args);
            throw new RuntimeException(msg, ex);
        }
    }
}