package jp.canetrash.sample.ibatis3;

import static org.apache.ibatis.jdbc.SelectBuilder.*;

import java.util.List;

import jp.canetrash.sample.ibatis3.domain.Emp;
import jp.canetrash.sample.ibatis3.mapper.EmpMapper;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.h2.jdbcx.JdbcDataSource;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        JdbcDataSource ds = new JdbcDataSource();
        ds.setUser("sa");
        ds.setURL("jdbc:h2:src/test/resources/test");
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("dev", transactionFactory, ds);
        Configuration config = new Configuration(environment);
       
        config.addMapper(EmpMapper.class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            EmpMapper empMapper = session.getMapper(EmpMapper.class);
            
            empMapper.dropTable();
            empMapper.createTable();
            Emp emp = new Emp();
            emp.setId(1);
            emp.setName("test");
            emp.setTitle("title");
            empMapper.insertEmp(emp);

            List<Emp> list = empMapper.selectAllEmp();
            System.out.println("lsit size:" + list.size());
            Emp res = list.get(0);
            System.out.println("id:" + res.getId());
            System.out.println("name:" +res.getName());
            System.out.println("title:" + res.getTitle());
            
            Emp entity = empMapper.selectOne(1);
            System.out.println("id:" + entity.getId());
            System.out.println("name:" +entity.getName());
            System.out.println("title:" + entity.getTitle());
  
            empMapper.deleteEmp(1);
            list = empMapper.selectAllEmp();
            System.out.println(list.size());
            
        } finally {
            session.close();
        }
        System.out.println(selectBuilder());
        
    }
    
    private static String selectBuilder() {
        BEGIN();
        SELECT("id, name, title");
        FROM("emp");
        return SQL();
    }
}
