/**
 ***************************************************************************************
 *  @Author     1044053532@qq.com   
 *  @License    http://www.apache.org/licenses/LICENSE-2.0
 ***************************************************************************************
 */
package com.qiqiim.constant;

import io.netty.util.AttributeKey;

import com.googlecode.protobuf.format.JsonFormat;

public class Constants {

	public static interface GroupId{
		public static final String ROOM_ID = "ROOM_ID_ON-LINE";	//redis存储的房间ID头部字符串,在线房间
	}
	
	public static interface WebSite{
		public static final int SUCCESS = 0;
		public static final int ERROR = -1;
	}
	
	public static interface ViewTemplateConfig{
		public static String template = "pctemplate/";
		public static String mobiletemplate = "mobiletemplate/";
	}
	
	public static interface NotifyConfig{
		public static final int NOTIFY_SUCCESS = 1;
	    public static final int NOTIFY_FAILURE = 0;
	    public static final int NOTIFY_NO_SESSION = 2;
	}
   
    
    
    public static interface ImserverConfig{
    	//连接空闲时间
      	public static final int READ_IDLE_TIME = 60;//秒
      	//发送心跳包循环时间
      	public static final int WRITE_IDLE_TIME = 40;//秒
        //心跳响应 超时时间
      	public static final int PING_TIME_OUT = 70; //秒   需大于空闲时间
      	
        // 最大协议包长度
        public static final int MAX_FRAME_LENGTH = 1024 * 10; // 10k
        //
        public static final int MAX_AGGREGATED_CONTENT_LENGTH = 65536;
        
        public static final String REBOT_SESSIONID="0";//机器人SessionID
        
        public static final int WEBSOCKET = 1;//websocket标识
        
        public static final int SOCKET =0;//socket标识
        
        public static final int DWR = 2;//dwr标识
        
     
    }
    
//    public static interface DWRConfig{
//    	   public static final String DWR_SCRIPT_FUNCTIONNAME="showMessage";//dwr显示消息的script方法名
//    	   public static final String SS_KEY = "scriptSession_Id";
//    	   public static final String BROWSER = "browser";
//    	   public static final String BROWSER_VERSION = "browserVersion";
//    	   public static final JsonFormat JSONFORMAT =new JsonFormat();
//    }
    
    public static interface SessionConfig{
    	 public static final String SESSION_KEY= "account" ;
    	 public static final AttributeKey<String> SERVER_SESSION_ID = AttributeKey.valueOf(SESSION_KEY);
    	 public static final AttributeKey SERVER_SESSION_HEARBEAT = AttributeKey.valueOf("heartbeat");
    }
    
    public static interface ProtobufType{
		int SEND = 1; //请求
		int RECEIVE = 2; //接收
		int NOTIFY = 3; //通知
		int REPLY = 4; //回复
	}
   
    public static interface CmdType{
		int BIND = 1; //绑定
		int HEARTBEAT = 2; //心跳
		int ONLINE = 3; //上线
		int OFFLINE = 4; //下线
		int MESSAGE = 5; //消息
		int RECON = 6; //重连
	}
  
}
