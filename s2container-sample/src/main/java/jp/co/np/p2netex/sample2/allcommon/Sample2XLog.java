package jp.co.np.p2netex.sample2.allcommon;

import jp.co.np.p2netex.sample2.allcommon.Sample2DBFluteConfig;

/**
 * @author DBFlute(AutoGenerator)
 */
public class Sample2XLog {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Log instance. */
    private static final org.apache.commons.logging.Log _log = org.apache.commons.logging.LogFactory.getLog(Sample2XLog.class);

    // ===================================================================================
    //                                                                             Logging
    //                                                                             =======
	public static void log(String msg) {// Very Internal
		if (isExecuteStatusLogLevelInfo()) {
	        _log.info(msg);
		} else {
	        _log.debug(msg);
		}
	}
	
    public static boolean isLogEnabled() {// Very Internal
		if (isExecuteStatusLogLevelInfo()) {
	        return _log.isInfoEnabled();
		} else {
	        return _log.isDebugEnabled();
		}
	}
	
	protected static boolean isExecuteStatusLogLevelInfo() {
	    return Sample2DBFluteConfig.getInstance().isExecuteStatusLogLevelInfo();
	}
}
