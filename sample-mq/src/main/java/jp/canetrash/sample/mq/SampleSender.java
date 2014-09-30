package jp.canetrash.sample.mq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class SampleSender {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// Connectionを作成するFactoryを作成
			QueueConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
			QueueConnection connection = factory.createQueueConnection();

			// セッションの作成
			QueueSession session = connection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
			Queue queue = session.createQueue("TestQueue");
			QueueSender sender = session.createSender(queue);

			connection.start();

			Message msg = session.createTextMessage("This is Message!!");

			// メッセージの送信
			sender.send(msg);

			sender.close();
			session.close();
			connection.close();

		} catch (JMSException e) {
			e.printStackTrace();
		}

	}

}
