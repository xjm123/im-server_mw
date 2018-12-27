package com.qiqiim.webserver.user.model;

import java.util.Date;

public class LiveRoomEntity {
    private String id;

    private String user_id;		//房间持有人

    private String room_name;	//房间名

    private String room_total;		//房间最大人数

    private Integer room_state;	//房间状态，0:正常，1：封禁，2：解散

    private Date create_time;

    private Date update_time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id == null ? null : user_id.trim();
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name == null ? null : room_name.trim();
    }

    public String getRoom_total() {
        return room_total;
    }

    public void setRoom_total(String room_total) {
        this.room_total = room_total == null ? null : room_total.trim();
    }

    public Integer getRoom_state() {
        return room_state;
    }

    public void setRoom_state(Integer room_state) {
        this.room_state = room_state;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}