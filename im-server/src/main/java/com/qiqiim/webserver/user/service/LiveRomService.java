package com.qiqiim.webserver.user.service;

import com.qiqiim.webserver.user.model.LiveRoomEntity;
import com.qiqiim.webserver.user.model.UserInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 用户信息表
 * 
 * @author qiqiim
 * @email 1044053532@qq.com
 * @date 2017-11-27 09:38:52
 */
public interface LiveRomService {
	
	LiveRoomEntity queryObject(String id);
	
	List<LiveRoomEntity> queryList(String user_id);
	
	int deleteByPrimaryKey(String id);

    int insert(LiveRoomEntity record);

    int insertSelective(LiveRoomEntity record);
    
    int updateByPrimaryKeySelective(LiveRoomEntity record);

    int updateByPrimaryKey(LiveRoomEntity record);
	
}
