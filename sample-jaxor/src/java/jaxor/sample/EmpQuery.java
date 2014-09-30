
package jaxor.sample;

import net.sourceforge.jaxor.api.*;

public class EmpQuery{

    private final QueryResult _rs;

    public EmpQuery(QueryResult rs) {
        _rs = rs;
    }

    public EmpList list(){
        return new EmpList(_rs.list());
    }

    public EmpResultSet resultSet(){
        return new EmpResultSet(_rs.resultSet());
    }

    public EmpEntity entity(){
        return (EmpEntity)_rs.entity();
    }

    public EmpEntity entityProxy(){
        return (EmpEntity)_rs.entityProxy();
    }

    public QueryResult getQueryResult(){
        return _rs;
    }

    public net.sourceforge.jaxor.QueryParams getParams(){
        return _rs.getParams();
    }

    public String getSQL(){
        return _rs.getSQL();
    }

}
