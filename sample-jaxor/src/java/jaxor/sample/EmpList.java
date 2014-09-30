
package jaxor.sample;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class EmpList extends net.sourceforge.jaxor.util.EntityListAdapterBase{

    public EmpList(){
        super(new ArrayList());
    }

    public EmpList(List list){
        super(list);
    }

    public void add(EmpEntity el){
        getList().add(el);
    }

    public void remove(EmpEntity el){
        getList().remove(el);
    }

    public void removeAll(EmpList param){
        getList().removeAll(param.getList());
    }

    public EmpIterator iterator(){
        return new EmpIterator(getList().iterator());
    }

    public EmpEntity get(int i){
        return (EmpEntity)getList().get(i);
    }

    public void deleteAll(){
        for (Iterator iterator = getList().iterator(); iterator.hasNext();) {
            EmpEntity abstractEntity = (EmpEntity) iterator.next();
            abstractEntity.registerDelete();
        }
    }

    public EmpEntity[] toArray(){
        return (EmpEntity[])getList().toArray(new EmpEntity[size()]);
    }
}