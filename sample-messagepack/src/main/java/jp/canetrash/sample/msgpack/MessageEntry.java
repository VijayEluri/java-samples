package jp.canetrash.sample.msgpack;

import org.msgpack.annotation.Message;

@Message
public class MessageEntry {

	public String str;
	public Integer number;
}
