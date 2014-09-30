package jp.canetrash.sample.riak;

import com.basho.riak.client.IRiakClient;
import com.basho.riak.client.IRiakObject;
import com.basho.riak.client.RiakFactory;
import com.basho.riak.client.bucket.Bucket;

/**
 * ProtocolBufferサンプル
 * 
 * @author tfunato
 * 
 */
public class SampleProtoclBufferMain {

	public static void main(String[] args) throws Exception {
		IRiakClient riakClient = RiakFactory.pbcClient("192.168.0.64", 8087);
		Bucket myBucket = riakClient.createBucket("rockArtist").execute();

		System.out.println("0");
		myBucket.delete("JimiHendrix").rw(3).execute();
		System.out.println("1");

		Guitarist guitarist = new Guitarist();
		guitarist.setName("James Marshall Hendrix");
		guitarist.setBirthYear(1942);
		guitarist.setGuitarName("Fender Stratocaster");
		//StoreObject<Guitarist> storeData = myBucket.store("JimiHendrix", guitarist);
		myBucket.store("abc", "hogehoge");
		System.out.println("2");
		IRiakObject myData = myBucket.fetch("abc").execute();
		System.out.println(myData.getBucket());
		myData = myBucket.store("key1", "value2").returnBody(true).execute();
		
	}
}
