/*
 * Copyright (c) 2005 ATL Systems incorporated.
 * All rights reserved.
 */
package ibatis;

import ibatis.dao.UserDao;
import ibatis.dao.sqlmap.DaoConfig;

/**
 * 
 * @author funato
 * @createted 2005/04/18
 */
public class SimpleSampleIBatisMain2 {

    public static void main(String[] args) {
        UserDao dao = (UserDao)DaoConfig.getDaomanager().getDao(UserDao.class);
        dao.transactionTest();
    }
}
