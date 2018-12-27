package com.qiqiim.console.redis;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


/**
 * 统一redis数据库操作
 * @author leihua
 * 2017-06-27
 */

@Service("redisDBService")
public class RedisDBService {

	
	@Resource(name="redisTemplate")  
    private RedisTemplate redisTemplate;
	
	/**
	 * 设置某个键的有效时间：单位\秒
	 * @param key
	 * @param time
	 */
	public void expire(String key,long timeout){
		redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
	}
	
	/**
	 * 字符类型：删除某个键
	 * @param key
	 */
	public void DEL(String key){
		redisTemplate.delete(key);
	}
	
	/**
	 * 删除特定前缀的key
	 * @param key
	 */
	public void deleteByPrex(String prex){
		Set<String> keys = redisTemplate.keys(prex);
        if (keys != null &&  keys.size()>0) {
            redisTemplate.delete(keys);
        }
	}
	
	//********************  字符操作 begin *********************
	
	/**
	 * 字符类型：插入操作
	 * @param key
	 * @param value
	 */
	public void SET(String key,String value){
		redisTemplate.opsForValue().set(key, value);
	}

	/**
	 * 字符类型：插入操作 并设置过期时间
	 * @param key
	 * @param value
	 * @param timeout
	 */
	public void SET(String key,String value,long timeout){
		redisTemplate.opsForValue().set(key, value);
		expire(key,timeout);
	}
	
	/**
	 * 字符类型：自动加一，主要用于统计在线人数
	 * @param key
	 */
	public void INCR(String key){
		redisTemplate.opsForValue().increment(key, 1); 
	}
	
	/**
	 * 自动减一
	 * @param key
	 */
	public void INCRBY(String key){
		redisTemplate.opsForValue().increment(key, -1);
	}
	
	/**
	 * 字符类型：获取操作
	 * @param key
	 * @return
	 */
	public String GET(String key){
		return (String)redisTemplate.opsForValue().get(key);
	}
	
	//********************  字符操作 end *********************
	

	
	//***************** Hash 操作 begin ********************
	
	/**
	 * 散列操作：插入数据 -> 单项插入
	 * @param key
	 * @param mapKey
	 * @param mapValue
	 */
	public void HSET(String key,String field,Object mapValue){
		redisTemplate.opsForHash().put(key, field, mapValue);
	}
	
	public synchronized  void HSET(String key,String field,String mapValue,long timeout){
		redisTemplate.opsForHash().put(key, field, mapValue);
		expire(key,timeout);
	}	
	
	/**
	 * 散列操作：插入数据 -> 多项插入
	 * @param key
	 * @param map
	 */
	public void HSET(String key,Map map){
		redisTemplate.opsForHash().putAll(key, map);
	}
	
	/**
	 * 单位\秒
	 * @param key
	 * @param map
	 * @param timeout
	 */
	public synchronized void HSET(String key,Map map,long timeout){
		redisTemplate.opsForHash().putAll(key, map);
		expire(key,timeout);
	}
	/**
	 * 散列操作：获取数据 -> 单项获取
	 * @param key
	 * @param mapKey
	 * @return
	 */
	public Object HGET(String key,String field){
		return redisTemplate.opsForHash().get(key, field);
	}
	
	/**
	 * 散列操作：获取数据 -> 单项获取
	 * @param key
	 * @param mapKey
	 * @return
	 */
	public synchronized Map HGETS(String key){
		Map resMap = redisTemplate.opsForHash().entries(key);
		if(resMap==null || resMap.size()<=0){ //有为空的情况
			return  new LinkedHashMap ();
		}
		return  resMap;
	}
	
	/**
	 *  散列操作：获取数据 -> 多项获取
	 * @param key
	 * @param listKey
	 * @return
	 */
	public Map HGETALL(String key){
		Map resMap = redisTemplate.opsForHash().entries(key);
		if(resMap==null || resMap.size()<=0){ //有为空的情况
			return new LinkedHashMap();
		}
		
		return  resMap;
	}
	
	/**
	 * 散列操作：删除单项数据
	 * @param key
	 * @param mapKey
	 */
//	public void HDEL(String key,String field){
//		redisTemplate.opsForHash().delete( key,field);
//	}
	
	/**
	 * 获取数据库中所有的键
	 * @return
	 */
	public List<String> KEYS(){
		Set set =redisTemplate.keys("*");
		if (set==null || set.size()<=0){
			return null;
		} 
		Iterator ite = set.iterator();
		
		List<String> resList = new ArrayList();
		while (ite.hasNext())
		{
			String temp = (String) ite.next();
			resList.add(temp);
		}
		
		return resList;
	}
	
	public List<String> KEYS(String prefix){
		Set set =redisTemplate.keys(prefix+"*");
		if (set==null || set.size()<=0){
			return null;
		} 
		Iterator ite = set.iterator();
		
		List<String> resList = new ArrayList();
		while (ite.hasNext())
		{
			String temp = (String) ite.next();
			resList.add(temp);
		}
		
		return resList;
	}	
	
	/**
	 * 获取数据库中所有的键
	 * @param count 最多返回条数
	 * @return
	 */
	public List<String> KEYS(int count){
		Set set =redisTemplate.keys("*");
		if (set==null || set.size()<=0){
			return null;
		} 
		Iterator ite = set.iterator();
		
		if (count<=1){
			count=1;
		}
		
		int i=0;
		List<String> resList = new ArrayList();
		while (ite.hasNext()){	
			if (i>=count){
				break;
			}
			String temp = (String) ite.next();
			resList.add(temp);
			i++;
		}
		
		return resList;
	}	
	
	//***************** Hash 操作 end ********************
}
