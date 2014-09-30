package jp.co.np.p2netex.sample2.allcommon.cbean.coption;


/**
 * The option of from-to.
 * <pre>
 * ex) fromDate:{2007/04/10 08:24:53} toDate:{2007/04/16 14:36:29}
 *
 *   - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
 *   new Sample2FromToOption().compareAsDate(); 
 *     --&gt; column &gt;= '2007/04/10 00:00:00' and column &lt; '2007/04/17 00:00:00'
 *   - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
 *
 *   new Sample2FromToOption(); 
 *     --&gt; column &gt;= '2007/04/10 08:24:53' and column &lt;= '2007/04/16 14:36:29'
 *
 *   new Sample2FromToOption().greaterThan(); 
 *     --&gt; column &gt; '2007/04/10 08:24:53' and column &lt;= '2007/04/16 14:36:29'
 *
 *   new Sample2FromToOption().lessThan(); 
 *     --&gt; column &gt;= '2007/04/10 08:24:53' and column &lt; '2007/04/16 14:36:29'
 *
 *   new Sample2FromToOption().greaterThan().lessThan(); 
 *     --&gt; column &gt; '2007/04/10 08:24:53' and column &lt; '2007/04/16 14:36:29'
 * 
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class Sample2FromToOption implements Sample2ConditionOption {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected boolean _fromDateGreaterThan;

    protected boolean _toDateLessThan;

    protected boolean _compareAsDate;

    // ===================================================================================
    //                                                            Interface Implementation
    //                                                            ========================
    public String getRearOption() {
        String msg = "Thie option does not use getRearOption()!";
        throw new UnsupportedOperationException(msg);
    }

    // ===================================================================================
    //                                                                                Main
    //                                                                                ====
    public Sample2FromToOption greaterThan() {
        _fromDateGreaterThan = true; return this;
    }

    public Sample2FromToOption lessThan() {
        _toDateLessThan = true; return this;
    }

    /**
     * Compare as date.
     * <pre>
     * ex) fromDate:{2007/04/10 08:24:53} toDate:{2007/04/16 14:36:29}
     *
     *   new Sample2FromToOption().compareAsDate();
     *     --&gt; column &gt;= '2007/04/10 00:00:00' and column &lt; '2007/04/17 00:00:00'
     * 
     * This method ignore greaterThan() and lessThan().
     * </pre>
     * @return this. (NotNull)
     */
    public Sample2FromToOption compareAsDate() {
        _compareAsDate = true; return this;
    }

    // ===================================================================================
    //                                                                       Internal Main
    //                                                                       =============
    public java.util.Date filterFromDate(java.util.Date fromDate) {
        if (fromDate == null) {
            return null;
        }
        if (_compareAsDate) {
            final java.util.Calendar cal = java.util.Calendar.getInstance();
            cal.setTimeInMillis(fromDate.getTime());
            clearCalendarHourMinuteSecondMilli(cal);
            final java.util.Date cloneDate = (java.util.Date) fromDate.clone();
            cloneDate.setTime(cal.getTimeInMillis());
            return cloneDate;
        }
        return fromDate;
    }

    public java.util.Date filterToDate(java.util.Date toDate) {
        if (toDate == null) {
            return null;
        }
        if (_compareAsDate) {
            final java.util.Calendar cal = java.util.Calendar.getInstance();
            cal.setTimeInMillis(toDate.getTime());
            clearCalendarHourMinuteSecondMilli(cal);
            addCalendarNextDay(cal);// Key Point!
            final java.util.Date cloneDate = (java.util.Date) toDate.clone();
            cloneDate.setTime(cal.getTimeInMillis());
            return cloneDate;
        }
        return toDate;
    }

    public jp.co.np.p2netex.sample2.allcommon.cbean.ckey.Sample2ConditionKey getFromDateConditionKey() {
        if (_compareAsDate) {
            return jp.co.np.p2netex.sample2.allcommon.cbean.ckey.Sample2ConditionKey.CK_GREATER_EQUAL;
        }
        if (_fromDateGreaterThan) {
            return jp.co.np.p2netex.sample2.allcommon.cbean.ckey.Sample2ConditionKey.CK_GREATER_THAN;// Default!
        } else {
            return jp.co.np.p2netex.sample2.allcommon.cbean.ckey.Sample2ConditionKey.CK_GREATER_EQUAL;// Default!
        }
    }

    public jp.co.np.p2netex.sample2.allcommon.cbean.ckey.Sample2ConditionKey getToDateConditionKey() {
        if (_compareAsDate) {
            return jp.co.np.p2netex.sample2.allcommon.cbean.ckey.Sample2ConditionKey.CK_LESS_THAN;
        }
        if (_toDateLessThan) {
            return jp.co.np.p2netex.sample2.allcommon.cbean.ckey.Sample2ConditionKey.CK_LESS_THAN;// Default!
        } else {
            return jp.co.np.p2netex.sample2.allcommon.cbean.ckey.Sample2ConditionKey.CK_LESS_EQUAL;// Default!
        }
    }

    // ===================================================================================
    //                                                                     Calendar Helper
    //                                                                     ===============
    protected void addCalendarNextDay(java.util.Calendar cal) {
        cal.add(java.util.Calendar.DAY_OF_MONTH, 1);
    }

    protected void clearCalendarHourMinuteSecondMilli(java.util.Calendar cal) {
        cal.clear(java.util.Calendar.MILLISECOND);
        cal.clear(java.util.Calendar.SECOND);
        cal.clear(java.util.Calendar.MINUTE);
        cal.set(java.util.Calendar.HOUR_OF_DAY, cal.getActualMinimum(java.util.Calendar.HOUR_OF_DAY));
    }
}
