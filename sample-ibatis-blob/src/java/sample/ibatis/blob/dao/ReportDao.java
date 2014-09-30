/*
 * Copyright (c) 2005 ATL Systems incorporated.
 * All rights reserved.
 */
package sample.ibatis.blob.dao;

import sample.ibatis.blob.domain.Report;

/**
 * 
 * @author funato
 * @createted 2005/08/08
 */
public interface ReportDao {
    public Report findByPk(String id);
    public Report findByPk2(String id);
    public void insert(Report report);
    public void insert2(Report report);
    public void update(Report report);
    public void update2(Report report);
    public void delete(String id);
    public void delete2(String id);
    
}
