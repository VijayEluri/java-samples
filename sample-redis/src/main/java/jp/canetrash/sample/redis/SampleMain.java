package jp.canetrash.sample.redis;

import redis.clients.jedis.Jedis;

public class SampleMain {
	
	public static void main(String[] args) {
		
		Jedis jedis = new Jedis("192.168.0.204", 6379);
		jedis.set("foo", "bar");
		String value = jedis.get("foo");
		System.out.println(value);
	}

}
