package com.qiqiim.webserver.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.qiqiim.webserver.user.dao.LiveRoomDao;
import com.qiqiim.webserver.user.model.LiveRoomEntity;
import com.qiqiim.webserver.user.model.UserInfoEntity;
import com.qiqiim.webserver.user.service.LiveRomService;
@Service("liveRomServiceImpl")
public class LiveRomServiceImpl implements LiveRomService {
	private static Logger logger = Logger.getLogger(LiveRomServiceImpl.class);
	
	@Resource(name = "liveRoomDao")
	private LiveRoomDao liveRoomDao;
	
	
	@Override
	public LiveRoomEntity queryObject(String id) {
		return liveRoomDao.selectByPrimaryKey(id);
	}

	@Override
	public List<LiveRoomEntity> queryList(String user_id) {
		return liveRoomDao.selectByStateList(user_id);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int insert(LiveRoomEntity record) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int insertSelective(LiveRoomEntity record) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(LiveRoomEntity record) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int updateByPrimaryKey(LiveRoomEntity record) {
		// TODO 自动生成的方法存根
		return 0;
	}

}
