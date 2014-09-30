package jp.co.np.p2netex.sample1.allcommon;

import jp.co.np.p2netex.sample1.allcommon.Sample1DBFluteConfig;

/**
 * @author DBFlute(AutoGenerator)
 */
public class Sample1XLog {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Log instance. */
    private static final org.apache.commons.logging.Log _log = org.apache.commons.logging.LogFactory.getLog(Sample1XLog.class);

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
	    return Sample1DBFluteConfig.getInstance().isExecuteStatusLogLevelInfo();
	}
}
