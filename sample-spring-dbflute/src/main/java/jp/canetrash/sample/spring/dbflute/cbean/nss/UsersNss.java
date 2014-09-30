package jp.canetrash.sample.spring.dbflute.cbean.nss;

import jp.canetrash.sample.spring.dbflute.cbean.cq.UsersCQ;

/**
 * The nest select set-upper of users.
 * @author DBFlute(AutoGenerator)
 */
public class UsersNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected UsersCQ _query;
    public UsersNss(UsersCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============

}
