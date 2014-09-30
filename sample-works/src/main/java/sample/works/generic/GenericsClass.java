package sample.works.generic;

import java.util.List;

public class GenericsClass {
    
    private List<? extends Number> list;
    
    public void setList(List<? extends Number> list) {
       this.list = list; 
    }
    
    public List<? extends Number> getList() {
        return list;
    }

}
