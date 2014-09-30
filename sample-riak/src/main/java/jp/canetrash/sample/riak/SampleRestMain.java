package jp.canetrash.sample.riak;

import java.io.FileInputStream;

import org.apache.commons.io.IOUtils;

import com.basho.riak.client.IRiakClient;
import com.basho.riak.client.IRiakObject;
import com.basho.riak.client.RiakFactory;
import com.basho.riak.client.bucket.Bucket;
import com.basho.riak.client.operations.FetchObject;
import com.basho.riak.client.operations.StoreObject;

/**
 * Riakのサンプル
 * 
 * @author tfunato
 * @see https://github.com/basho/riak-java-client
 */
public class SampleRestMain {

	public static void main(String[] args) throws Exception {

		// create a client (see Configuration below in this README for more details)
		IRiakClient riakClient = RiakFactory.httpClient("http://192.168.0.64:8098/riak"); //or RiakFactory.httpClient();

		// create a new bucket
		Bucket myBucket = riakClient.createBucket("rock").execute();

		// add data to the bucket
		myBucket.store("key1", "value1").execute();
		Guitarist guitarist = new Guitarist();
		guitarist.setName("James Marshall Hendrix");
		guitarist.setBirthYear(1942);
		guitarist.setGuitarName("Fender Stratocaster");

		myBucket.store("JimHen", guitarist).execute();

		StoreObject<IRiakObject> biStore = myBucket.store("gaga", IOUtils.toByteArray(new FileInputStream("gaga.jpg")));
		biStore.execute();
		//fetch it back
		IRiakObject myData = myBucket.fetch("key1").execute();
		System.out.println(myData.getBucket());
		
		FetchObject<Guitarist> fetch = myBucket.fetch("JimHen", Guitarist.class);
		Guitarist execute = fetch.execute();
		System.out.println(execute);
		System.out.println(execute.getGuitarName());

		// you can specify extra parameters to the store operation using the
		// fluent builder style API
		myData = myBucket.store("key1", "value2").returnBody(true).execute();

		// delete
		myBucket.delete("key1").rw(3).execute();
	}
}
