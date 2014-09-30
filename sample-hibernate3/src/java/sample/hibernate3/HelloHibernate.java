package sample.hibernate3;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * オブジェクトをDBへ挿入し,選択し,更新し,削除する.
 */
public class HelloHibernate {
    /** ログ出力用. */
    private static Logger logger = Logger.getRootLogger();

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        saveMessages(sessionFactory);

        List updateTargetList = loadMessages(sessionFactory);
        updateMessages(sessionFactory, updateTargetList);
        
        selectNativeSQL(sessionFactory);

        List deleteTargetList = loadMessages(sessionFactory);
        deleteMessages(sessionFactory, deleteTargetList);
        deleteAllMessages(sessionFactory);
    }

    /**
     * SimpleMessageオブジェクトの永続化(DBに格納)
     * @param sessionFactory セッション取得用.
     */
    private static void saveMessages(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        for (int i = 0; i < 10; i++) {
            SimpleMessage simpleMessage = new SimpleMessage();
            simpleMessage.setMessage("hello" + i);

            // DBに格納
            session.save(simpleMessage);
        }

        transaction.commit();
        session.close();
    }

    /**
     * SimpleMessageオブジェクトの復元(DBから読み込む)
     * @param sessionFactory セッション取得用.
     * @return 復元オブジェクトのリスト
     */
    private static List loadMessages(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Hibernate2 での方法
        // 	List result = session.find("from SimpleMessage as msg where msg.id / 2 = ?",
        // 				   new Integer(10),
        // 				   Hibernate.INTEGER
        // 				   );
        // Hibernate3 での方法
        Query query = session.createQuery("from SimpleMessage as msg where msg.id = ?");
        query.setInteger(0, 10);

        List result = query.list();

        transaction.commit();
        session.close();

        return result;
    }

    /**
     * SimpleMessageオブジェクトの更新.
     * @param sessionFactory セッション取得用.
     * @param targets 更新対象.
     */
    private static void updateMessages(SessionFactory sessionFactory, List targets) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        for (Iterator itr = targets.iterator(); itr.hasNext();) {
            SimpleMessage targetSimpleMessage = (SimpleMessage) itr.next();

            // SimpleMessageオブジェクトの値の更新
            targetSimpleMessage.setMessage(targetSimpleMessage.getMessage() + "updated");

            // DB更新
            session.update(targetSimpleMessage);
        }

        transaction.commit();
        session.close();
    }

    /**
     * SimpleMessageオブジェクトの削除.
     * @param sessionFactory セッション取得用.
     * @param targets 削除対象.
     */
    private static void deleteMessages(SessionFactory sessionFactory, List targets) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        for (Iterator itr = targets.iterator(); itr.hasNext();) {
            SimpleMessage targetSimpleMessage = (SimpleMessage) itr.next();
            session.delete(targetSimpleMessage);
        }

        transaction.commit();
        session.close();
    }

    /**
     * 全SimpleMessageオブジェクトの削除.
     * @param sessionFactory セッション取得用.
     */
    private static void deleteAllMessages(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("delete from SimpleMessage");
        int result = query.executeUpdate();
        logger.info("all delete result = " + result);

        transaction.commit();
        session.close();
    }
    /**
     * NativeなSQLを投げるテスト
     * @param sessionFactory
     */
    private static void selectNativeSQL(SessionFactory sessionFactory){
        Session session = sessionFactory.openSession();
        Transaction tran = session.beginTransaction();
        SimpleMessage simpleMessage = (SimpleMessage)session.getNamedQuery("testSearch").uniqueResult();
        System.out.println(simpleMessage.getId());
        System.out.println(simpleMessage.getMessage());
        tran.commit();
        session.close();
    }
}
