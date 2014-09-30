package jp.canetrash.sample.jsr107;

import java.util.Date;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;

public class SampleMain {

	public static void main(String[] args) {
		String cacheName = "sampleCache";
		CacheManager cacheManager = Caching.getCacheManager();
		Cache<Integer, Date> cache = cacheManager.getCache(cacheName);
		if (cache == null) {
			cache = cacheManager.<Integer, Date> createCacheBuilder(cacheName)
					.build();
		}
		Date value1 = new Date();
		Integer key = 1;
		cache.put(key, value1);
		Date value2 = cache.get(key);
		System.out.println(value2);
	}
}
