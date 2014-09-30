package jp.co.np.p2netex.sample2.allcommon.s2dao;

import java.util.Arrays;
import java.util.List;
import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInvocation;
import org.seasar.framework.beans.MethodNotFoundRuntimeException;
import org.seasar.dao.DaoMetaData;
import org.seasar.dao.DaoMetaDataFactory;
import org.seasar.dao.SqlCommand;
import org.seasar.dao.NotSingleRowUpdatedRuntimeException;

import jp.co.np.p2netex.sample2.allcommon.Sample2XLog;
import jp.co.np.p2netex.sample2.allcommon.Sample2Entity;
import jp.co.np.p2netex.sample2.allcommon.Sample2InternalMapContext;
import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2ConditionBean;
import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2ConditionBeanContext;
import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2FetchNarrowingBeanContext;
import jp.co.np.p2netex.sample2.allcommon.cbean.Sample2FetchNarrowingBean;
import jp.co.np.p2netex.sample2.allcommon.cbean.outsidesql.Sample2OutsideSqlContext;
import jp.co.np.p2netex.sample2.allcommon.cbean.outsidesql.Sample2OutsideSqlDao;
import jp.co.np.p2netex.sample2.allcommon.cbean.outsidesql.Sample2OutsideSqlOption;
import jp.co.np.p2netex.sample2.allcommon.exception.Sample2EntityAlreadyUpdatedException;
import jp.co.np.p2netex.sample2.allcommon.util.Sample2TraceViewUtil;

/**
 * The interceptor of S2Dao for DBFlute.
 * @author DBFlute(AutoGenerator)
 */
public class Sample2S2DaoInterceptor extends org.seasar.framework.aop.interceptors.AbstractInterceptor {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    /** Log instance. */
    private static final org.apache.commons.logging.Log _log = org.apache.commons.logging.LogFactory.getLog(Sample2S2DaoInterceptor.class);

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** The factory of DAO meta data. */
    protected DaoMetaDataFactory _daoMetaDataFactory;
    
    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    /**
     * Constructor.
     * @param daoMetaDataFactory The factory of DAO meta data. (NotNull)
     */
    public Sample2S2DaoInterceptor(DaoMetaDataFactory daoMetaDataFactory) {
        _daoMetaDataFactory = daoMetaDataFactory;
    }

    // ===================================================================================
    //                                                                  Execute Status Log
    //                                                                  ==================
    protected void log(String msg) {
        Sample2XLog.log(msg);
    }
    
    protected boolean isLogEnabled() {
        return Sample2XLog.isLogEnabled();
    }
    
    // ===================================================================================
    //                                                                              Invoke
    //                                                                              ======
    /**
     * Invoke the method.
     * @param invocation The method invocation. (NotNull)
     * @return The result of the method. (Nullable)
     * @throws Throwable
     */
    public Object invoke(MethodInvocation invocation) throws Throwable {
        clearThreadLocal();
        try {
            return dispatchInvoking(invocation);
        } finally {
            clearThreadLocal();
        }
    }

    /**
     * Dispatch invoking the method.
     * @param invocation The method invocation. (NotNull)
     * @return The result of the method. (Nullable)
     * @throws Throwable
     */
    protected Object dispatchInvoking(MethodInvocation invocation) throws Throwable {
        final Method method = invocation.getMethod();
        if (!org.seasar.framework.util.MethodUtil.isAbstract(method)) {
            return invocation.proceed();
        }
        
        // - - - - - - - - - - - - -
        // Initialize DAO meta data
        // - - - - - - - - - - - - -
        if (method.getName().equals("initializeDaoMetaData")) {
            initializeSqlCommand(invocation);
            return null;// The end! (Initilization Only)
        }

        // - - - - - - - - - - - -
        // Preprocess outside-SQL
        // - - - - - - - - - - - -
        preprocessOutsideSql(invocation);

        // - - - - - - - - - - - - -
        // Preprocess condition-bean
        // - - - - - - - - - - - - -
        final Sample2ConditionBean cb = preprocessConditionBean(invocation);

        // - - - - - - - - - -
        // Set up SQL-command
        // - - - - - - - - - -
        final SqlCommand cmd;
        try {
            long beforeCmd = 0;
            if (isLogEnabled()) {
                beforeCmd = System.currentTimeMillis();
            }
            cmd = findSqlCommand(invocation);
            if (isLogEnabled()) {
                final long afterCmd = System.currentTimeMillis();
                if (beforeCmd != afterCmd) {
                    logSqlCommand(invocation, cmd, beforeCmd, afterCmd);
                }
            }
        } finally {
            if (isLogEnabled()) {
                logInvocation(invocation);
            }
        }

        long before = 0;
        if (isLogEnabled()) {
            before = System.currentTimeMillis();
        }

        // - - - - - - - - - -
        // Execute SQL-command
        // - - - - - - - - - -
        Object ret = null;
        try {
            ret = cmd.execute(invocation.getArguments());
        } catch (Exception e) {
            if (isLogEnabled()) {
                final Class<?> targetType = getTargetClass(invocation);
                final StringBuilder sb = new StringBuilder();
                sb.append(targetType.getSimpleName() + " was interrupted by " + e.getClass().getSimpleName()).append(getLineSeparator());
                sb.append("[Interrupted Target]").append(getLineSeparator());
                sb.append("  dao    = " + targetType.getSimpleName()).append(getLineSeparator());
                sb.append("  method = " + invocation.getMethod()).append(getLineSeparator());
                sb.append("  args   = " + Sample2TraceViewUtil.convertObjectArrayToStringView(invocation.getArguments()));
                log(sb.toString());
            }
            if (e.getClass().equals(NotSingleRowUpdatedRuntimeException.class)) {
                throw new Sample2EntityAlreadyUpdatedException((NotSingleRowUpdatedRuntimeException)e);
            }
            throw e;
        } finally {
            postprocessConditionBean(invocation, cb);
        }
        final Class<?> retType = method.getReturnType();
        assertRetType(retType, ret);

        if (isLogEnabled()) {
            final long after = System.currentTimeMillis();
            logReturn(invocation, retType, ret, before, after);
        }

        // - - - - - - - - - -
        // Convert and Return!
        // - - - - - - - - - -
        if (retType.isPrimitive()) {
            return org.seasar.framework.util.NumberConversionUtil.convertPrimitiveWrapper(retType, ret);
        } else if (Number.class.isAssignableFrom(retType)) {
            return org.seasar.framework.util.NumberConversionUtil.convertNumber(retType, ret);
        } else {
            return ret;
        }
    }

    // ===================================================================================
    //                                                                          SqlCommand
    //                                                                          ==========
    protected void initializeSqlCommand(MethodInvocation invocation) {
        final Class<?> targetType = getTargetClass(invocation);
        final DaoMetaData dmd = _daoMetaDataFactory.getDaoMetaData(targetType);
        if (Sample2OutsideSqlDao.class.isAssignableFrom(targetType)) {
            return;// Do nothing!
        } else {
            final Object[] arguments = invocation.getArguments();
            if (arguments != null && arguments.length > 0 && arguments[0] instanceof String) {
                final String methodName = (String)arguments[0];
                try {
                    dmd.getSqlCommand(methodName);
                } catch (MethodNotFoundRuntimeException ignored) {
                    // Do nothing!
                    if (isLogEnabled()) {
                        log("Not Found the method: " + methodName + " msg=" + ignored.getMessage());
                    }
                }
                return;
            } else {
                String msg = "The method should have one string argument as method name: " + invocation;
                throw new IllegalStateException(msg);
            }
        }
    }
    
    protected SqlCommand findSqlCommand(MethodInvocation invocation) {
        final SqlCommand cmd;
        final Class<?> targetType = getTargetClass(invocation);
        final DaoMetaData dmd = _daoMetaDataFactory.getDaoMetaData(targetType);
        if (Sample2OutsideSqlDao.class.isAssignableFrom(targetType)) {
            cmd = dmd.getSqlCommand(generateSpecifiedOutsideSqlUniqueKey(invocation));
        } else {
            cmd = dmd.getSqlCommand(invocation.getMethod().getName());
        }
        return cmd;
    }

    protected String generateSpecifiedOutsideSqlUniqueKey(MethodInvocation invocation) {
        final Object[] args = invocation.getArguments();
        final String path = (String)args[0];
        final Object pmb = args[1];
        final Sample2OutsideSqlOption option = (Sample2OutsideSqlOption)args[2];
        Object resultTypeSpecification = null;
        if (args.length > 3) {
            resultTypeSpecification = args[3];
        }
        return Sample2OutsideSqlContext.generateSpecifiedOutsideSqlUniqueKey(invocation.getMethod().getName(), path, pmb, option, resultTypeSpecification);
    }

    // ===================================================================================
    //                                                                      Log Invocation
    //                                                                      ==============
    protected void logInvocation(MethodInvocation invocation) {
        final StackTraceElement[] stackTrace = new Exception().getStackTrace();
        final InvokeNameExtractingResult behaviorResult = extractBehaviorInvokeName(stackTrace);

        final String invokeClassName;
        final String invokeMethodName;
        if (behaviorResult.getSimpleClassName() != null) {
            invokeClassName = behaviorResult.getSimpleClassName();
            invokeMethodName = behaviorResult.getMethodName();
        } else {
            final Method method = invocation.getMethod();
            invokeClassName = extractInvocationExpression(method);
            invokeMethodName = method.getName();
        }
        final String invocationExpressionWithoutKakko = invokeClassName  + "." + invokeMethodName;
        final String equalBorder = buildFitBorder("", "=", invocationExpressionWithoutKakko, false);
        final String invocationExpression = invocationExpressionWithoutKakko + "()";

        log("/=====================================================" + equalBorder + "==");
        log("                                                      " + invocationExpression);
        log("                                                      " + equalBorder + "=/");

        logPath(invocation, stackTrace, behaviorResult);

        // Specified OutsideSql
        if (isSpecifiedOutsideSql(invocation)) {
		    final Sample2OutsideSqlContext outsideSqlContext = getOutsideSqlContext();
            if (!outsideSqlContext.isProcedure()) {// [DBFlute-0.7.5]
                Object[] args = invocation.getArguments();
                if (outsideSqlContext != null) {
				    log("path: " + outsideSqlContext.getOutsideSqlPath());
                } else {
                    log("path: " + getOutsideSqlPath(args));
			    }
                log("option: " + getOutsideSqlOption(args));
            }
        }
    }

    protected void logPath(MethodInvocation invocation, StackTraceElement[] stackTrace, InvokeNameExtractingResult behaviorResult) {
        final int bhvNextIndex = behaviorResult.getNextStartIndex();
        final InvokeNameExtractingResult clientResult = extractClientInvokeName(stackTrace, bhvNextIndex);
        final int clientFirstIndex = clientResult.getFoundFirstIndex();
        final InvokeNameExtractingResult byPassResult = extractByPassInvokeName(stackTrace, bhvNextIndex, clientFirstIndex - bhvNextIndex);

        final String clientInvokeName = clientResult.getInvokeName();
        final String byPassInvokeName = byPassResult.getInvokeName();
        final String behaviorInvokeName = behaviorResult.getInvokeName();
        if (clientInvokeName.trim().length() == 0 && byPassInvokeName.trim().length() == 0) {
            return;
        }
        log(clientInvokeName + byPassInvokeName + behaviorInvokeName + "...");
    }

    protected String buildFitBorder(String prefix, String element, String lengthTargetString, boolean space) {
        final int length = space ? lengthTargetString.length() / 2 : lengthTargetString.length();
        final StringBuffer sb = new StringBuffer();
        sb.append(prefix);
        for (int i = 0; i < length; i++) {
            sb.append(element);
            if (space) {
                sb.append(" ");
            }
        }
        if (space) {
            sb.append(element);
        }
        return sb.toString();
    }

    protected InvokeNameExtractingResult extractClientInvokeName(StackTraceElement[] stackTrace, final int startIndex) {
        final List<String> suffixList = Arrays.asList(new String[]{"Page", "Action"});
        final InvokeNameExtractingCallback callback = new InvokeNameExtractingCallback() {
            public boolean isTargetElement(String className, String methodName) {
                return isClassNameEndsWith(className, suffixList);
            }
            public String filterSimpleClassName(String simpleClassName) {
                return simpleClassName;
            }
            public boolean isUseAdditionalInfo() {
                return true;
            }
            public int getStartIndex() {
                return startIndex;
            }
            public int getLoopSize() {
                return 25;
            }
        };
        return extractInvokeName(callback, stackTrace);
    }

    protected InvokeNameExtractingResult extractByPassInvokeName(StackTraceElement[] stackTrace, final int startIndex, final int loopSize) {
        final List<String> suffixList = Arrays.asList(new String[]{"Service", "ServiceImpl", "Facade", "FacadeImpl"});
        final InvokeNameExtractingCallback callback = new InvokeNameExtractingCallback() {
            public boolean isTargetElement(String className, String methodName) {
                return isClassNameEndsWith(className, suffixList);
            }
            public String filterSimpleClassName(String simpleClassName) {
                return simpleClassName;
            }
            public boolean isUseAdditionalInfo() {
                return true;
            }
            public int getStartIndex() {
                return startIndex;
            }
            public int getLoopSize() {
                return loopSize >= 0 ? loopSize : 25;
            }
        };
        return extractInvokeName(callback, stackTrace);
    }

    protected InvokeNameExtractingResult extractBehaviorInvokeName(StackTraceElement[] stackTrace) {
        final List<String> suffixList = Arrays.asList(new String[]{"Bhv", "BehaviorReadable", "BehaviorWritable", "PagingInvoker"});
        final List<String> keywordList = Arrays.asList(new String[]{"Bhv$", "BehaviorReadable$", "BehaviorWritable$"});
        final InvokeNameExtractingCallback callback = new InvokeNameExtractingCallback() {
            public boolean isTargetElement(String className, String methodName) {
                if (isClassNameEndsWith(className, suffixList)) {
                    return true;
                }
                if (isClassNameContains(className, keywordList)) {
                    return true;
                }
                return false;
            }
            public String filterSimpleClassName(String simpleClassName) {
                return removeBasePrefixFromSimpleClassName(simpleClassName);
            }
            public boolean isUseAdditionalInfo() {
                return false;
            }
            public int getStartIndex() {
                return 0;
            }
            public int getLoopSize() {
                return 25;
            }
        };
        return extractInvokeName(callback, stackTrace);
    }

    protected boolean isClassNameEndsWith(String className, List<String> suffixList) {
        for (String suffix : suffixList) {
            if (className.endsWith(suffix)) {
                return true;
            }
        }
        return false;
    }
    
    
    protected boolean isClassNameContains(String className, List<String> keywordList) {
        for (String keyword : keywordList) {
            if (className.contains(keyword)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param callback the call-back for invoke-name-extracting. (NotNull)
     * @param stackTrace Stack log. (NotNull)
     * @return Invoke name. (NotNull: If not found, returns empty string.)
     */
    protected InvokeNameExtractingResult extractInvokeName(InvokeNameExtractingCallback callback, StackTraceElement[] stackTrace) {
        String targetSimpleClassName = null;
        String targetMethodName = null;
        int lineNumber = 0;
        int foundIndex = -1;// The minus one means 'Not Found'.
        int foundFirstIndex = -1;// The minus one means 'Not Found'.
        boolean onTarget = false;
        for (int i=callback.getStartIndex(); i < stackTrace.length; i++) {
            final StackTraceElement element = stackTrace[i];
            if (i > callback.getStartIndex() + callback.getLoopSize()) {
                break;
            }
            final String className = element.getClassName();
            if (className.startsWith("sun.") || className.startsWith("java.")) {
                if (onTarget) {
                    break;
                }
                continue;
            }
            final String methodName = element.getMethodName();
            if (callback.isTargetElement(className, methodName)) {
                if (methodName.equals("invoke")) {
                    continue;
                }
                targetSimpleClassName = className.substring(className.lastIndexOf(".") + 1);
                targetMethodName = methodName;
                if (callback.isUseAdditionalInfo()) {
                    lineNumber = element.getLineNumber();
                }
                foundIndex = i;
                if (foundFirstIndex == -1) {
                    foundFirstIndex = i;
                }
                onTarget = true;
                continue;
            }
            if (onTarget) {
                break;
            }
        }
        final InvokeNameExtractingResult result = new InvokeNameExtractingResult();
        if (targetSimpleClassName == null) {
            result.setInvokeName("");// Not Found! It sets empty string as default.
            return result;
        }
        final String filteredClassName = callback.filterSimpleClassName(targetSimpleClassName);
        result.setSimpleClassName(callback.filterSimpleClassName(targetSimpleClassName));
        result.setMethodName(targetMethodName);
        if (lineNumber > 0) {
            result.setInvokeName(filteredClassName + "." + targetMethodName + "():" + lineNumber + " --> ");
        } else {
            result.setInvokeName(filteredClassName + "." + targetMethodName + "() --> ");
        }
        result.setFoundIndex(foundIndex);
        result.setFoundFirstIndex(foundFirstIndex);
        return result;
    }

    protected static interface InvokeNameExtractingCallback {
        public boolean isTargetElement(String className, String methodName);
        public String filterSimpleClassName(String simpleClassName);
        public boolean isUseAdditionalInfo();
        public int getStartIndex();
        public int getLoopSize();
    }

    protected static class InvokeNameExtractingResult {
        protected String _simpleClassName;
        protected String _methodName;
        protected String _invokeName;
        protected int _foundIndex;
        protected int _foundFirstIndex;

        public int getNextStartIndex() {
            return _foundIndex + 1;
        }

        public String getSimpleClassName() {
            return _simpleClassName;
        }
        public void setSimpleClassName(String simpleClassName) {
            _simpleClassName = simpleClassName;
        }
        public String getMethodName() {
            return _methodName;
        }
        public void setMethodName(String methodName) {
            _methodName = methodName;
        }
        public String getInvokeName() {
            return _invokeName;
        }
        public void setInvokeName(String invokeName) {
            _invokeName = invokeName;
        }
        public int getFoundIndex() {
            return _foundIndex;
        }
        public void setFoundIndex(int foundIndex) {
            _foundIndex = foundIndex;
        }
        public int getFoundFirstIndex() {
            return _foundFirstIndex;
        }
        public void setFoundFirstIndex(int foundFirstIndex) {
            _foundFirstIndex = foundFirstIndex;
        }
    }

    /**
     * @param method The invoked method. (NotNull)
     * @return The expression of invocation. (NotNull)
     */
    protected String extractInvocationExpression(Method method) {
        final Class<?> declaringClass = method.getDeclaringClass();
        return removeBasePrefixFromSimpleClassName(declaringClass.getSimpleName());
    }
    
    /**
     * @param simpleClassName The simple class name. (NotNull)
     * @return The simple class name removed the base prefix. (NotNull)
     */
    protected String removeBasePrefixFromSimpleClassName(String simpleClassName) {
        if (!simpleClassName.startsWith("Sample2Bs")) {
            return simpleClassName;
        }
        final int prefixLength = "Sample2Bs".length();
        if (!Character.isUpperCase(simpleClassName.substring(prefixLength).charAt(0))) {
            return simpleClassName;
        }
        if (simpleClassName.length() <= prefixLength) {
            return simpleClassName;
        }
        return "Sample2" + simpleClassName.substring(prefixLength);
    }

    // ===================================================================================
    //                                                                      Log SqlCommand
    //                                                                      ==============
    protected void logSqlCommand(MethodInvocation invocation, SqlCommand cmd, long beforeCmd, long afterCmd) {
        log("SqlCommand Initialization Cost: [" + Sample2TraceViewUtil.convertToPerformanceView(afterCmd - beforeCmd) + "]");
    }

    protected void assertRetType(Class<?> retType, Object ret) {
        if (java.util.List.class.isAssignableFrom(retType)) {
            if (ret != null && !(ret instanceof java.util.List)) {
                String msg = "The retType is difference from actual return: ";
                msg = msg + "retType=" + retType + " ret.getClass()=" + ret.getClass() + " ref=" + ret;
                throw new IllegalStateException(msg);
            }
        } else if (Sample2Entity.class.isAssignableFrom(retType)) {
            if (ret != null && !(ret instanceof Sample2Entity)) {
                String msg = "The retType is difference from actual return: ";
                msg = msg + "retType=" + retType + " ret.getClass()=" + ret.getClass() + " ref=" + ret;
                throw new IllegalStateException(msg);
            }
        }
    }

    // ===================================================================================
    //                                                                          Log Return
    //                                                                          ==========
    protected void logReturn(org.aopalliance.intercept.MethodInvocation invocation, Class<?> retType, Object ret, long before, long after) throws Throwable {
        try {
            final String daoResultPrefix = "===========/ [" + Sample2TraceViewUtil.convertToPerformanceView(after - before) + " - ";
            if (java.util.List.class.isAssignableFrom(retType)) {
                if (ret == null) {
                    log(daoResultPrefix + "Selected list: null]");
                } else {
                    final java.util.List<?> ls = (java.util.List<?>) ret;
                    if (ls.isEmpty()) {
                        log(daoResultPrefix + "Selected list: 0]");
                    } else if (ls.size() == 1 && ls.get(0) instanceof Number) {
                        log(daoResultPrefix + "Selected count: " + ls.get(0) + "]");
                    } else {
                        log(daoResultPrefix + "Selected list: " + ls.size() + " first=" + ls.get(0) + "]");
                    }
                }
            } else if (Sample2Entity.class.isAssignableFrom(retType)) {
                if (ret == null) {
                    log(daoResultPrefix + "Selected entity: null" + "]");
                } else {
                    final Sample2Entity entity = (Sample2Entity) ret;
                    log(daoResultPrefix + "Selected entity: " + entity + "]");
                }
            } else if (Sample2Entity.class.isAssignableFrom(retType)) {
                if (ret == null) {
                    log(daoResultPrefix + "Selected entity: null" + "]");
                } else {
                    final Sample2Entity entity = (Sample2Entity) ret;
                    log(daoResultPrefix + "Selected entity: " + entity + "]");
                }
            } else if (int[].class.isAssignableFrom(retType)) {
                if (ret == null) {
                    log(daoResultPrefix + "Selected entity: null" + "]");
                } else {
                    final int[] resultArray = (int[]) ret;
                    if (resultArray.length == 0) {
                        log(daoResultPrefix + "All updated count: 0]");
                    } else {
                        final StringBuilder sb = new StringBuilder();
                        boolean resultExpressionScope = true;
                        int resultCount = 0;
                        int loopCount = 0;
                        for (int element : resultArray) {
                            resultCount = resultCount + element;
                            if (resultExpressionScope) {
                                if (loopCount <= 10) {
                                    if (sb.length() == 0) {
                                        sb.append(element);
                                    } else {
                                        sb.append(",").append(element);
                                    }
                                } else {
                                    sb.append(",").append("...");
                                    resultExpressionScope = false;
                                }
                            }
                            ++loopCount;
                        }
                        sb.insert(0, "{").append("}");
                        log(daoResultPrefix + "All updated count: " + resultCount + " result=" + sb + "]");
                    }
                }
            } else {
                if (isSelectCountIgnoreFetchScopeMethod(invocation)) {
                    log(daoResultPrefix + "Selected count: " + ret + "]");
                } else {
                    log(daoResultPrefix + "Result: " + ret + "]");
                }
            }
            log(" ");
        } catch (Exception e) {
            String msg = "Result object debug threw the exception: methodName=";
            msg = msg + invocation.getMethod().getName() + " retType=" + retType;
            msg = msg + " ret=" + ret;
            _log.warn(msg, e);
            throw e;
        }
    }

    // ===================================================================================
    //                                                                    Pre Post Process
    //                                                                    ================
    // -----------------------------------------------------
    //                                            OutsideSql
    //                                            ----------
    protected void preprocessOutsideSql(MethodInvocation invocation) {
        final Class<jp.co.np.p2netex.sample2.allcommon.annotation.OutsideSql> outsideSqlType = jp.co.np.p2netex.sample2.allcommon.annotation.OutsideSql.class;
        final jp.co.np.p2netex.sample2.allcommon.annotation.OutsideSql outsideSql = invocation.getMethod().getAnnotation(outsideSqlType);

        // Traditional OutsideSql
        if (outsideSql != null && (outsideSql.dynamicBinding() || outsideSql.offsetByCursor() || outsideSql.offsetByCursor() || outsideSql.limitByCursor())) {
            final Sample2OutsideSqlContext outsideSqlContext = new Sample2OutsideSqlContext();
            outsideSqlContext.setDynamicBinding(outsideSql.dynamicBinding());
            outsideSqlContext.setOffsetByCursorForcedly(outsideSql.offsetByCursor());
            outsideSqlContext.setLimitByCursorForcedly(outsideSql.limitByCursor());
            Sample2OutsideSqlContext.setOutsideSqlContextOnThread(outsideSqlContext);

            // Set up fetchNarrowingBean.
            final Object[] args = invocation.getArguments();
            if (args == null || args.length == 0) {
                return;
            }
            if (Sample2FetchNarrowingBeanContext.isTheTypeFetchNarrowingBean(args[0].getClass())) {
                Sample2FetchNarrowingBeanContext.setFetchNarrowingBeanOnThread((Sample2FetchNarrowingBean)args[0]);
            }
            return;
        }

        // Specified OutsideSql
        if (isSpecifiedOutsideSql(invocation)) {
            if (isOutsideSqlDaoMethodSelect(invocation)) {
                setupOutsideSqlContextSelect(invocation);
            } else {
                setupOutsideSqlContextExecute(invocation);
            }
            return;
        }
    }
    
    protected boolean isSpecifiedOutsideSql(MethodInvocation invocation) {
        return Sample2OutsideSqlDao.class.isAssignableFrom(getTargetClass(invocation));
    }

    // - - - - - - - - - - - -
    //                  Select
    //                   - - -
    protected boolean isOutsideSqlDaoMethodSelect(MethodInvocation invocation) {
        return invocation.getMethod().getName().startsWith("select");
    }

    protected void setupOutsideSqlContextSelect(MethodInvocation invocation) {
        final Object[] args = invocation.getArguments();
        if (args.length != 4) {
            String msg = "Internal Error! OutsideSqlDao.selectXxx() should have 4 arguements: args.length=" + args.length;
            throw new IllegalStateException(msg);
        }
        final String path = getOutsideSqlPath(args);
        final Object pmb = getOutsideSqlParameterBean(args);
        final Sample2OutsideSqlOption option = getOutsideSqlOption(args);
        final Object resultTypeSpecification = args[3];
        final Sample2OutsideSqlContext outsideSqlContext = new Sample2OutsideSqlContext();
        outsideSqlContext.setDynamicBinding(option.isDynamicBinding());
        outsideSqlContext.setOffsetByCursorForcedly(option.isAutoPaging());
        outsideSqlContext.setLimitByCursorForcedly(option.isAutoPaging());
        outsideSqlContext.setOutsideSqlPath(path);
        outsideSqlContext.setParameterBean(pmb);
        outsideSqlContext.setResultTypeSpecification(resultTypeSpecification);
        outsideSqlContext.setMethodName(invocation.getMethod().getName());
        outsideSqlContext.setStatementConfig(option.getStatementConfig());
        outsideSqlContext.setTableDbName(option.getTableDbName());
		outsideSqlContext.setupBehaviorQueryPathIfNeeds();
        Sample2OutsideSqlContext.setOutsideSqlContextOnThread(outsideSqlContext);

        // Set up fetchNarrowingBean.
        setupOutsideSqlFetchNarrowingBean(pmb, option);
    }

    // - - - - - - - - - - - -
    //                 Execute
    //                 - - - -
    protected void setupOutsideSqlContextExecute(MethodInvocation invocation) {
        final Object[] args = invocation.getArguments();
        if (args.length != 3) {
            String msg = "Internal Error! OutsideSqlDao.execute() should have 3 arguements: args.length=" + args.length;
            throw new IllegalStateException(msg);
        }
        final String path = getOutsideSqlPath(args);
        final Object pmb = getOutsideSqlParameterBean(args);
        final Sample2OutsideSqlOption option = getOutsideSqlOption(args);
        final Sample2OutsideSqlContext outsideSqlContext = new Sample2OutsideSqlContext();
        outsideSqlContext.setDynamicBinding(option.isDynamicBinding());
        outsideSqlContext.setOffsetByCursorForcedly(option.isAutoPaging());
        outsideSqlContext.setLimitByCursorForcedly(option.isAutoPaging());
        outsideSqlContext.setOutsideSqlPath(path);
        outsideSqlContext.setParameterBean(pmb);
        outsideSqlContext.setMethodName(invocation.getMethod().getName());
        outsideSqlContext.setStatementConfig(option.getStatementConfig());
        outsideSqlContext.setTableDbName(option.getTableDbName());
		outsideSqlContext.setupBehaviorQueryPathIfNeeds();
        Sample2OutsideSqlContext.setOutsideSqlContextOnThread(outsideSqlContext);

        // Set up fetchNarrowingBean.
        setupOutsideSqlFetchNarrowingBean(pmb, option);
    }

    // - - - - - - - - - - - -
    //                  Common
    //                   - - -
    protected String getOutsideSqlPath(Object[] args) {
        return (String)args[0];
    }
    protected Object getOutsideSqlParameterBean(Object[] args) {
        return args[1];
    }
    protected Sample2OutsideSqlOption getOutsideSqlOption(Object[] args) {
        return (Sample2OutsideSqlOption)args[2];
    }

    protected void setupOutsideSqlFetchNarrowingBean(Object pmb, Sample2OutsideSqlOption option) {
        if (pmb == null || !Sample2FetchNarrowingBeanContext.isTheTypeFetchNarrowingBean(pmb.getClass())) {
            return;
        }
        final Sample2FetchNarrowingBean fetchNarrowingBean = (Sample2FetchNarrowingBean)pmb;
        if (option.isManualPaging()) {
            fetchNarrowingBean.ignoreFetchNarrowing();
        }
        Sample2FetchNarrowingBeanContext.setFetchNarrowingBeanOnThread(fetchNarrowingBean);
    }

    // -----------------------------------------------------
    //                                         ConditionBean
    //                                         -------------
    /**
     * Pre-process conditionBean.
     * <p>
     * If this method is condition bean select target, make dynamic SQL.
     * Else nothing.
     * @param invocation Method invocation. (NotNull)
     * @return ConditionBean. (Nullable)
     */
    protected Sample2ConditionBean preprocessConditionBean(MethodInvocation invocation) {
        final Sample2OutsideSqlContext outsideSqlContext = getOutsideSqlContext();
        if (outsideSqlContext != null) {
            return null; // Because it has already finished setting up fetchNarrowingBean for outsideSql here.
        }
        
        final Sample2ConditionBean cb;
        {
            final Object[] args = invocation.getArguments();
            if (args == null || args.length == 0) {
                return null;
            }
            final Object arg0 = args[0];
            if (arg0 == null) {
                return null;
            }
            if (!Sample2ConditionBeanContext.isTheTypeConditionBean(arg0.getClass())) {// The argument is not condition-bean...
                if (Sample2FetchNarrowingBeanContext.isTheTypeFetchNarrowingBean(arg0.getClass()) && !isSelectCountIgnoreFetchScopeMethod(invocation)) {
                    // Fetch-narrowing-bean and Not select count!
                    Sample2FetchNarrowingBeanContext.setFetchNarrowingBeanOnThread((Sample2FetchNarrowingBean)arg0);
                }
                return null;
            }
            cb = (Sample2ConditionBean)arg0;
        }

        if (isSelectCountIgnoreFetchScopeMethod(invocation)) {
            cb.xsetupSelectCountIgnoreFetchScope();
        } else {
            Sample2FetchNarrowingBeanContext.setFetchNarrowingBeanOnThread(cb);
        }

        Sample2ConditionBeanContext.setConditionBeanOnThread(cb);
        return cb;
    }

    /**
     * Post-process condition-bean.
     * @param invocation Method invocation. (NotNull)
     * @param cb Condition-bean. (Nullable)
     */
    protected void postprocessConditionBean(MethodInvocation invocation, Sample2ConditionBean cb) {
        if (cb == null) {
            return;
        }
        if (isSelectCountIgnoreFetchScopeMethod(invocation)) {
            cb.xafterCareSelectCountIgnoreFetchScope();
        }
    }

    // -----------------------------------------------------
    //                                    Clear Thread Local
    //                                    ------------------
    protected void clearThreadLocal() {
        if (Sample2OutsideSqlContext.isExistOutsideSqlContextOnThread()) {
            Sample2OutsideSqlContext.clearOutsideSqlContextOnThread();
        }
        if (Sample2FetchNarrowingBeanContext.isExistFetchNarrowingBeanOnThread()) {
            // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
            // Because there is possible that fetch narrowing has been ignored for manualPaging of outsideSql.
            // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
            Sample2FetchNarrowingBeanContext.getFetchNarrowingBeanOnThread().restoreIgnoredFetchNarrowing();

            Sample2FetchNarrowingBeanContext.clearFetchNarrowingBeanOnThread();
        }
        if (Sample2ConditionBeanContext.isExistConditionBeanOnThread()) {
            Sample2ConditionBeanContext.clearConditionBeanOnThread();
        }
        if (Sample2InternalMapContext.isExistInternalMapContextOnThread()) {
            Sample2InternalMapContext.clearInternalMapContextOnThread();
        }
    }

    // ===================================================================================
    //                                                                      Context Helper
    //                                                                      ==============
    protected Sample2OutsideSqlContext getOutsideSqlContext() {
        if (!Sample2OutsideSqlContext.isExistOutsideSqlContextOnThread()) {
            return null;
        }
        return Sample2OutsideSqlContext.getOutsideSqlContextOnThread();
    }
    
    protected boolean isSpecifiedOutsideSql() {
        final Sample2OutsideSqlContext outsideSqlContext = getOutsideSqlContext();
        return outsideSqlContext != null && outsideSqlContext.isSpecifiedOutsideSql();
    }

    // ===================================================================================
    //                                                                       Determination
    //                                                                       =============
    /**
     * Is select count ignore-fetch-scope method?
     * @param invocation Method invocation. (NotNull)
     * @return Determination.
     */
    protected boolean isSelectCountIgnoreFetchScopeMethod(MethodInvocation invocation) {
        final String name = invocation.getMethod().getName();
        return name.startsWith("readCount") || name.startsWith("selectCount");
    }

    // ===================================================================================
    //                                                                      General Helper
    //                                                                      ==============
    /**
     * Get the value of line separator.
     * @return The value of line separator. (NotNull)
     */
    protected String getLineSeparator() {
        return System.getProperty("line.separator");
    }
}