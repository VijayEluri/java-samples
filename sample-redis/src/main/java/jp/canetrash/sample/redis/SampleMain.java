package jp.canetrash.sample.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class SampleMain {
	
	public static void main(String[] args) {
		
		JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost", 6379, 10);
		Jedis jedis = pool.getResource();

		jedis.set("foo", "bar");
		String foobar = jedis.get("foo");
		jedis.expire("foo", 10);
		
		System.out.println(foobar);
		
		//jedis.del("foo");

		pool.returnResource(jedis);
		pool.destroy();
	}

}
