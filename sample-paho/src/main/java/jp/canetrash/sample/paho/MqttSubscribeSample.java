package jp.canetrash.sample.paho;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MqttSubscribeSample {

	public static void main(String[] args) {

		String topic = "MQTT Examples";
		int qos = 2;
		String broker = "tcp://192.168.127.139:1883";
		String clientId = "SubscribeSample";
		MemoryPersistence persistence = new MemoryPersistence();

		try {
			MqttClient sampleClient = new MqttClient(broker, clientId,
					persistence);
			sampleClient.setCallback(new MqttCallback() {

				@Override
				public void messageArrived(String topic, MqttMessage msg)
						throws Exception {
					System.out.println("topic:" + topic);
					System.out.println("msg:" + new String(msg.getPayload()));
				}

				@Override
				public void deliveryComplete(IMqttDeliveryToken token) {
					System.out.println("delivary complete");
				}

				@Override
				public void connectionLost(Throwable cause) {
					cause.printStackTrace();
				}
			});
			sampleClient.connect();
			sampleClient.subscribe(topic, qos);

		} catch (MqttException me) {
			System.out.println("reason " + me.getReasonCode());
			System.out.println("msg " + me.getMessage());
			System.out.println("loc " + me.getLocalizedMessage());
			System.out.println("cause " + me.getCause());
			System.out.println("excep " + me);
			me.printStackTrace();
		}
	}

}
