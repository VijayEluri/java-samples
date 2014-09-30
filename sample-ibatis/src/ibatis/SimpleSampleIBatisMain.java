package ibatis;

import ibatis.domain.User;
import ibatis.service.UserService;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;

public class SimpleSampleIBatisMain {

    public static void main(String[] args) throws Exception {
        UserService service = UserService.getInstance();
        /*
        User user = service.getUserByPk("00001");
        System.out.println(user);
        System.out.println(ToStringBuilder.reflectionToString(user));
        */
        /*
        List list = service.getUserList();
        for(Iterator itr=list.iterator();itr.hasNext();){
            user = (User)itr.next();
            System.out.println(ToStringBuilder.reflectionToString(user));
        }
                */
        Map map = new HashMap();
        map.put("inValue1", "hogehoge");
        map.put("inValue2","uheheh");
        service.callProcedure(map);
        System.out.println(map);

        
    }
}
