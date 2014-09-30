

package jaxor.sample;

import java.util.Iterator;

public class EmpIterator {
    private final Iterator _iterator;
    public EmpIterator(Iterator iter){
        _iterator = iter;
    }

    public boolean hasNext(){
        return _iterator.hasNext();
    }
    public EmpEntity next(){
        return (EmpEntity)_iterator.next();
    }
}
