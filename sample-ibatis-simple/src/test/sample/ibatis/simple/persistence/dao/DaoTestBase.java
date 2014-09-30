// Copyright(c) 2005 Isetan Co.,Ltd. and ATL Systems, Incorporated.
//
//
package sample.ibatis.simple.persistence.dao;

import sample.ibatis.simple.persistence.DaoConfig;

import com.ibatis.dao.client.DaoManager;

import junit.framework.TestCase;

public class DaoTestBase extends TestCase {
    protected DaoManager daoManager;

    public void setUp() throws Exception {
        daoManager = DaoConfig.getDaomanager();
        super.setUp();
    }

}
