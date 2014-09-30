/*
 * Copyright (c) 2005 ATL Systems incorporated.
 * All rights reserved.
 */
package sample.ibatis.blob.dao.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import sample.ibatis.blob.dao.ReportDao;
import sample.ibatis.blob.domain.Report;


/**
 *
 * @author funato
 * @createted 2005/08/08
 */
public class IbatisReportDao extends SqlMapClientDaoSupport implements ReportDao {
    /**
     * @see sample.ibatis.blob.dao.ReportDao#findByPk(java.lang.String)
     */
    public Report findByPk(String id) {
        return (Report) getSqlMapClientTemplate().queryForObject("Report.getReportById", id);
    }
    public Report findByPk2(String id) {
        return (Report) getSqlMapClientTemplate().queryForObject("Report.getReportById2", id);
    }

    /**
     * @see sample.ibatis.blob.dao.ReportDao#insert(sample.ibatis.blob.domain.Report)
     */
    public void insert(Report report) {
        getSqlMapClientTemplate().insert("Report.insertReport", report);
    }
    public void insert2(Report report) {
        getSqlMapClientTemplate().insert("Report.insertReport2", report);
    }

    /**
     * @see sample.ibatis.blob.dao.ReportDao#update(sample.ibatis.blob.domain.Report)
     */
    public void update(Report report) {
        getSqlMapClientTemplate().update("Report.updateReport", report);
    }
    public void update2(Report report) {
        getSqlMapClientTemplate().update("Report.updateReport2", report);
    }

    /**
     * @see sample.ibatis.blob.dao.ReportDao#delete(java.lang.String)
     */
    public void delete(String id) {
        getSqlMapClientTemplate().delete("Report.deleteReport", id);
    }
    public void delete2(String id) {
        getSqlMapClientTemplate().delete("Report.deleteReport2", id);
    }
}
