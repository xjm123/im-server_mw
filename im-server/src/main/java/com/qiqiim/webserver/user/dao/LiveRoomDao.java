package com.qiqiim.webserver.user.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.qiqiim.webserver.user.model.LiveRoomEntity;

@Repository("liveRoomDao")
public interface LiveRoomDao {
    int deleteByPrimaryKey(String id);

    int insert(LiveRoomEntity record);

    int insertSelective(LiveRoomEntity record);

    LiveRoomEntity selectByPrimaryKey(String id);
//    更具用户查询正常的回话间
    List<LiveRoomEntity> selectByStateList(String user_id);

    int updateByPrimaryKeySelective(LiveRoomEntity record);

    int updateByPrimaryKey(LiveRoomEntity record);
}