package jp.co.np.p2netex.sample2.allcommon;

import jp.co.np.p2netex.sample2.allcommon.Sample2DBFluteConfig;

/**
 * @author DBFlute(AutoGenerator)
 */
public class Sample2QLog {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Log instance. */
    private static final org.apache.commons.logging.Log _log = org.apache.commons.logging.LogFactory.getLog(Sample2QLog.class);

    // ===================================================================================
    //                                                                             Logging
    //                                                                             =======
	public static void log(String sql) {// Very Internal
		if (isQueryLogLevelInfo()) {
	        _log.info(sql);
		} else {
	        _log.debug(sql);
		}
	}
	
	public static boolean isLogEnabled() {
		if (isQueryLogLevelInfo()) {
	        return _log.isInfoEnabled();
		} else {
	        return _log.isDebugEnabled();
		}
	}
	
	protected static boolean isQueryLogLevelInfo() {
	    return Sample2DBFluteConfig.getInstance().isQueryLogLevelInfo();
	}
}
