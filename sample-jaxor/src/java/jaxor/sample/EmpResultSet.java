
package jaxor.sample;

import net.sourceforge.jaxor.api.EntityResultSet;
import net.sourceforge.jaxor.api.EntityInterface;


public class EmpResultSet {

    private final EntityResultSet _rs;

    public EmpResultSet(EntityResultSet rs) {
        _rs = rs;
    }

    public boolean hasNext(){
        return _rs.hasNext();
    }

    public EmpEntity next() {
        return ( EmpEntity ) _rs.next();
    }

    /**
    * Don't forget to call close. This frees the database result set, statement, and connection.
    **/
    public void close(){
        _rs.close();
    }

    public EntityResultSet getEntityResultSet(){
        return _rs;
    }
}
