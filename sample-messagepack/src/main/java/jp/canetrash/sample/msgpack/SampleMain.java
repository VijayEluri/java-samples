package jp.canetrash.sample.msgpack;

import java.io.IOException;
import java.util.Arrays;

import org.msgpack.MessagePack;

/**
 * MessagePackのサンプル
 * 
 * @author tfunato
 * 
 */
public class SampleMain {

	public static void main(String[] args) throws IOException {
		MessageEntry msg = new MessageEntry();
		msg.str = "This is MessagePack!";
		msg.number = 9999;
		
		MessagePack msgPack = new MessagePack();
		// Seriarize
		byte[] raw = msgPack.write(msg);
		System.out.println(Arrays.toString(raw));
		
		// Deseriarize
		MessageEntry deSeriarize = msgPack.read(raw, MessageEntry.class);
		System.out.println(deSeriarize.str);
		System.out.println(deSeriarize.number);
		
	}
}
