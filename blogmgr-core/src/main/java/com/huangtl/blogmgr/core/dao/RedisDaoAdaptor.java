package com.huangtl.blogmgr.core.dao;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * redis dao support
 * 
 * @version
 * @date 2016年4月1日
 * @author PraiseLord
 * @param <K>
 * @param <V>
 */
public class RedisDaoAdaptor<K, V> {
	protected RedisTemplate<K, V> redisDao;
	
	/**
	 * 序列化给定的值
	 * @param value
	 * @return
	 */
	public byte[] serializer(String value){
		return getRedisSerializer().serialize(value);
	}
	
	/**
	 * 序列化给定的值
	 * @param value
	 * @return
	 */
	public String deserialize(byte[] value){
		return getRedisSerializer().deserialize(value);
	}
	
	/**
	 * 设置redisTemplate
	 * @param redisTemplate the redisTemplate to set
	 */
	public void setRedisTemplate(RedisTemplate<K, V> redisTemplate) {
		this.redisDao = redisTemplate;
	}

	/**
	 * 获取 RedisSerializer <br>
	 * ------------------------------<br>
	 */
	protected RedisSerializer<String> getRedisSerializer() {
		return redisDao.getStringSerializer();
	}
}
