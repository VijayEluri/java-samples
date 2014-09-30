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
 * �I�u�W�F�N�g��DB�֑}����,�I����,�X�V��,�폜����.
 */
public class HelloHibernate {
    /** ���O�o�͗p. */
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
     * SimpleMessage�I�u�W�F�N�g�̉i����(DB�Ɋi�[)
     * @param sessionFactory �Z�b�V�����擾�p.
     */
    private static void saveMessages(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        for (int i = 0; i < 10; i++) {
            SimpleMessage simpleMessage = new SimpleMessage();
            simpleMessage.setMessage("hello" + i);

            // DB�Ɋi�[
            session.save(simpleMessage);
        }

        transaction.commit();
        session.close();
    }

    /**
     * SimpleMessage�I�u�W�F�N�g�̕���(DB����ǂݍ���)
     * @param sessionFactory �Z�b�V�����擾�p.
     * @return �����I�u�W�F�N�g�̃��X�g
     */
    private static List loadMessages(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Hibernate2 �ł̕��@
        // 	List result = session.find("from SimpleMessage as msg where msg.id / 2 = ?",
        // 				   new Integer(10),
        // 				   Hibernate.INTEGER
        // 				   );
        // Hibernate3 �ł̕��@
        Query query = session.createQuery("from SimpleMessage as msg where msg.id = ?");
        query.setInteger(0, 10);

        List result = query.list();

        transaction.commit();
        session.close();

        return result;
    }

    /**
     * SimpleMessage�I�u�W�F�N�g�̍X�V.
     * @param sessionFactory �Z�b�V�����擾�p.
     * @param targets �X�V�Ώ�.
     */
    private static void updateMessages(SessionFactory sessionFactory, List targets) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        for (Iterator itr = targets.iterator(); itr.hasNext();) {
            SimpleMessage targetSimpleMessage = (SimpleMessage) itr.next();

            // SimpleMessage�I�u�W�F�N�g�̒l�̍X�V
            targetSimpleMessage.setMessage(targetSimpleMessage.getMessage() + "updated");

            // DB�X�V
            session.update(targetSimpleMessage);
        }

        transaction.commit();
        session.close();
    }

    /**
     * SimpleMessage�I�u�W�F�N�g�̍폜.
     * @param sessionFactory �Z�b�V�����擾�p.
     * @param targets �폜�Ώ�.
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
     * �SSimpleMessage�I�u�W�F�N�g�̍폜.
     * @param sessionFactory �Z�b�V�����擾�p.
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
     * Native��SQL�𓊂���e�X�g
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
