package jp.co.np.p2netex.sample2.allcommon.cbean.coption;


/**
 * The option of date-from-to.
 * <pre>
 * ex) fromDate:{2007/04/10 08:24:53} toDate:{2007/04/16 14:36:29}
 *
 *   - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
 *   new Sample2DateFromToOption(); 
 *     --&gt; column &gt;= '2007/04/10 00:00:00' and column &lt; '2007/04/17 00:00:00'
 *   - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
 * 
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class Sample2DateFromToOption extends Sample2FromToOption {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Sample2DateFromToOption() {
        compareAsDate();
    }
}
