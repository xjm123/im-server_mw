/**
 ***************************************************************************************
 *  @Author     1044053532@qq.com   
 *  @License    http://www.apache.org/licenses/LICENSE-2.0
 ***************************************************************************************
 */
package com.qiqiim.server.proxy.impl;

import java.util.Date;

import com.qiqiim.server.model.ImMessage;
import com.qiqiim.server.model.ImMessageBody;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.qiqiim.constant.Constants;
import com.qiqiim.rebot.proxy.RebotProxy;
import com.qiqiim.server.model.MessageWrapper;
import com.qiqiim.server.proxy.MessageProxy;
import com.qiqiim.webserver.user.model.UserMessageEntity;
import com.qiqiim.webserver.user.service.UserMessageService;

//@Component("proxy")
public class MessageProxyImpl implements MessageProxy {
	private final static Logger log = LoggerFactory.getLogger(MessageProxyImpl.class);
	
	private RebotProxy rebotProxy;
	@Autowired
	private UserMessageService userMessageServiceImpl;

    public MessageWrapper convertToMessageWrapper(String sessionId ,ImMessage message) {
    	
        
        switch (message.getCmd()) {
			case Constants.CmdType.BIND:
				 try {
		            	return new MessageWrapper(MessageWrapper.MessageProtocol.CONNECT, message.getSender(), null,message);
		            } catch (Exception e) {
		                e.printStackTrace();
		            }
				break;
			case Constants.CmdType.HEARTBEAT:
				try {
	                 return new MessageWrapper(MessageWrapper.MessageProtocol.HEART_BEAT, sessionId,null, null);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
				break;
			case Constants.CmdType.ONLINE:
				
				break;
			case Constants.CmdType.OFFLINE:
				
				break;
			case Constants.CmdType.MESSAGE:
					try {
//						  MessageProto.Model.Builder  result = MessageProto.Model.newBuilder(message);
						message.setTimeStamp(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
						message.setSender(sessionId);//存入发送人sessionId
//						  message =  MessageProto.Model.parseFrom(result.build().toByteArray());
						  //判断消息是否有接收人
						  if(StringUtils.isNotEmpty(message.getReceiver())){
							  //判断是否发消息给机器人
							  if(message.getReceiver().equals(Constants.ImserverConfig.REBOT_SESSIONID)){
//								  MessageBodyProto.ImMessageBody  msg =  MessageBodyProto.ImMessageBody.parseFrom(message.getContent());
								  ImMessageBody msg = message.getMessageBody();
								  return  rebotProxy.botMessageReply(sessionId, msg.getContent());

							  }else{
								  return new MessageWrapper(MessageWrapper.MessageProtocol.REPLY, sessionId,message.getReceiver(), message);
							  }
						  }else if(StringUtils.isNotEmpty(message.getGroupId())){
							  return new MessageWrapper(MessageWrapper.MessageProtocol.GROUP, sessionId, null,message);
						  }else {
							  return new MessageWrapper(MessageWrapper.MessageProtocol.SEND, sessionId, null,message);
						  }
		            } catch (Exception e) {
		                e.printStackTrace();
		            }
				break;  
		} 
        return null;
    }

    
 
    @Override
	public void saveOnlineMessageToDB(MessageWrapper message) {
    	try{
    		UserMessageEntity  userMessage = convertMessageWrapperToBean(message);
    		if(userMessage!=null){
    			userMessage.setIsread(1);
            	userMessageServiceImpl.save(userMessage);
    		}
    	}catch(Exception e){
    		 log.error("MessageProxyImpl  user "+message.getSessionId()+" send msg to "+message.getReSessionId()+" error");
    		 throw new RuntimeException(e.getCause());
    	}
	}
    
    
    @Override
	public void saveOfflineMessageToDB(MessageWrapper message) {
    	try{
    		 
    		UserMessageEntity  userMessage = convertMessageWrapperToBean(message);
    		if(userMessage!=null){
    			userMessage.setIsread(0);
            	userMessageServiceImpl.save(userMessage);
    		}
    	}catch(Exception e){
    		 log.error("MessageProxyImpl  user "+message.getSessionId()+" send msg to "+message.getReSessionId()+" error");
    		 throw new RuntimeException(e.getCause());
    	} 
	}
    
    
    private UserMessageEntity convertMessageWrapperToBean(MessageWrapper message){
    	try{
    		//保存非机器人消息
    		if(!message.getSessionId().equals(Constants.ImserverConfig.REBOT_SESSIONID)){
    			ImMessage  msg =  (ImMessage)message.getBody();
            	ImMessageBody  msgConten =  msg.getMessageBody();
            	UserMessageEntity  userMessage = new UserMessageEntity();
            	userMessage.setSend_user_id(null);
            	userMessage.setReceive_user_id(null);
            	userMessage.setSenduser(message.getSessionId());
            	userMessage.setReceiveuser(message.getReSessionId());
            	userMessage.setContent(msgConten.getContent());
            	userMessage.setGroupid(msg.getGroupId());
            	userMessage.setCreatedate(msg.getTimeStamp());
            	userMessage.setIsread(1);
            	return userMessage;
    		}
    	}catch(Exception e){
    		 throw new RuntimeException(e.getCause());
    	} 
    	return null;
    }

	public void setRebotProxy(RebotProxy rebotProxy) {
		this.rebotProxy = rebotProxy;
	}



	@Override
	public ImMessage getOnLineStateMsg(String sessionId) {
		ImMessage  result = new ImMessage();
		result.setTimeStamp(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		result.setSender(sessionId);//存入发送人sessionId
		result.setCmd(Constants.CmdType.ONLINE);
		return result;
	}



	@Override
	public ImMessage getOffLineStateMsg(String sessionId) {
		ImMessage  result = new ImMessage();
		result.setTimeStamp(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		result.setSender(sessionId);//存入发送人sessionId
		result.setCmd(Constants.CmdType.OFFLINE);
		return result;
	}



	@Override
	public MessageWrapper getReConnectionStateMsg(String sessionId) {
		 ImMessage  result = new ImMessage();
		 result.setTimeStamp(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		 result.setSender(sessionId);//存入发送人sessionId
		 result.setCmd(Constants.CmdType.RECON);
		 return  new MessageWrapper(MessageWrapper.MessageProtocol.SEND, sessionId, null,result);
	}


	
    
    
}
