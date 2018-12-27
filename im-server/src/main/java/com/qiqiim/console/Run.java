package com.qiqiim.console;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qiqiim.console.redis.RedisUtil;

public class Run {

	public static void main(String[] args) {
		System.out.println("**********  框架的定时器程序启动    **********");
		init();
	}

	public static void init() {
		/*
		 * 后台程序使用 log4j.properties 不能使用lo4j.xml 如果 log4j.properties
		 * 放在src下面，可以自动识别，否则用PropertyConfigurator.configure()路径也不能使用通配符，
		 * PropertyConfigurator.configure(
		 * "D:/workspace/eclipse20160303/eolei-ssm-frame/src/resources/log4j.properties"
		 * );
		 */
		
		PropertyConfigurator.configure(Run.class.getClass().getResource("/").getPath()+"log4j.properties");


		// 一个配置文件的加载方式
		// ApplicationContext ctx=new
		// ClassPathXmlApplicationContext("classpath:*/spring/spring-mybatis.xml");

		// 加载多个配置文件
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {
				"classpath*:spring-*.xml"});
		
		RedisUtil redisUtil = (RedisUtil)context.getBean("redisUtil");
	/*	System.out.println(superToken);
		String json = redisDBService.GET(SysConst.LIVE_POOL+SysConst.MONTNETS);
		List<LiveInfoDTO> liveInfoList =  com.alibaba.fastjson.JSONObject.parseArray(json, LiveInfoDTO.class);		
		for (LiveInfoDTO llf :liveInfoList){
			System.out.println(llf.toString());
		}*/
//redisDBService.deleteByPrex("MAP1");
//		Map<String ,Object> closing_live_pool = new  HashMap<String ,Object>();
//		closing_live_pool.put("ID", "123");
//		closing_live_pool.put("ID1", "1231");
//		closing_live_pool.put("ID2", "12312");
//    	redisDBService.HSET("MAP1", closing_live_pool);
//    	closing_live_pool = redisDBService.HGETALL("MAP1");
//    	 for (Map.Entry<String ,Object> entry : closing_live_pool.entrySet()) { 
//      	   System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue()); 
//      	 }
    	
    /*	 System.out.println("****************");
    	closing_live_pool.remove("ID1");
    	redisDBService.HSET("MAP1", closing_live_pool);
    	closing_live_pool = redisDBService.HGETALL("MAP1");
   	 	for (Map.Entry<String ,Object> entry : closing_live_pool.entrySet()) { 
     	   System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue()); 
     	 }
   	 System.out.println("****************");
   	 	redisDBService.deleteByPrex("MAP1");
//    	 redisDBService.HDEL("MAP1", "ID");
*/		
		
		
	}

}
