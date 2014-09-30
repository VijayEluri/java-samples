package ibatis;

import ibatis.domain.User;

import ibatis.service.UserService;

import org.apache.commons.lang.builder.StandardToStringStyle;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.Iterator;
import java.util.List;


public class SimpleSampleSpringIBatisMain {
    public static void main(String[] args) throws Exception {
        UserService service = UserService.getInitSpringInstance();
        User user = service.getUserByPk("00001");
        StandardToStringStyle style = new StandardToStringStyle();
        style.setFieldSeparator("\n");
        style.setContentStart("[\n");
        style.setContentEnd("\n]");
        System.out.println(ToStringBuilder.reflectionToString(user, style));

        List list = service.getUserList();

        for (Iterator itr = list.iterator(); itr.hasNext();) {
            user = (User)itr.next();
            System.out.println(ToStringBuilder.reflectionToString(user, style));
        }
    }
}
