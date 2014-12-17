package jp.canetrash.sample.spring_boot.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisAccessService {

	private static final String SAMPLE_KEY = "foo";

	@Autowired
	private StringRedisTemplate redisTemplate;

	public void push() {
		redisTemplate.opsForList().leftPush(SAMPLE_KEY, "bar");
	}

	public String pop() {
		return redisTemplate.opsForList().leftPop(SAMPLE_KEY);
	}

}
