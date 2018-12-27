package com.qiqiim.console.timer.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.qiqiim.console.timer.IJRunTimer;
import com.qiqiim.server.ImServerHandler;

@Service("jRunTimerImpl")
public class JRunTimerImpl implements IJRunTimer {
	private final static Logger log = LoggerFactory.getLogger(JRunTimerImpl.class);
	
	@Scheduled(cron="0 0 0/24 * * ? ")   //每24小时执行一次 
	@Override
	public void timer() {
        try {
			Runtime runtime = Runtime.getRuntime();
			log.info("============= 定时检测 JavaVM 情况 ================");
			log.info(" maxMemory : "+runtime.maxMemory()/1024/1024+" MB ");
			log.info(" totalMemory : "+runtime.totalMemory()/1024/1024+" MB ");
			log.info(" freeMemory : "+runtime.freeMemory()/1024/1024+" MB ");
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}