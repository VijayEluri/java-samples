package jp.canetrash.sample.aws_sns;

import org.junit.Test;

import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;

/**
 * Unit test for simple App.
 */
public class AppTest {

	@Test
	public void testSimple() throws Exception {
		
		//create a new SNS client and set endpoint
		AmazonSNSClient snsClient = new AmazonSNSClient(new ClasspathPropertiesFileCredentialsProvider());		                           
		snsClient.setRegion(Region.getRegion(Regions.AP_NORTHEAST_1));

		String topicArn = "arn:aws:sns:ap-northeast-1:1234567890:SNS-TEST";
		//publish to an SNS topic
		String msg = "日本語のテストてすてす";
		PublishRequest publishRequest = new PublishRequest(topicArn, msg);
		PublishResult publishResult = snsClient.publish(publishRequest);
		//print MessageId of message published to SNS topic
		System.out.println("MessageId - " + publishResult.getMessageId());
	}
}
