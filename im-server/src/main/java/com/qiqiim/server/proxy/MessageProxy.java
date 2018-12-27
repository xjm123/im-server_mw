/**
 ***************************************************************************************
 *  @Author     1044053532@qq.com   
 *  @License    http://www.apache.org/licenses/LICENSE-2.0
 ***************************************************************************************
 */
package com.qiqiim.server.proxy;

import com.qiqiim.server.model.ImMessage;
import com.qiqiim.server.model.MessageWrapper;

public interface MessageProxy {

    MessageWrapper  convertToMessageWrapper(String sessionId ,ImMessage message);
    /**
     * 保存在线消息
     * @param message
     */
    void  saveOnlineMessageToDB(MessageWrapper message);
    /**
     * 保存离线消息
     * @param message
     */
    void  saveOfflineMessageToDB(MessageWrapper message);
    /**
     * 获取上线状态消息
     * @param sessionId
     * @return
     */
    ImMessage getOnLineStateMsg(String sessionId);
    /**
     * 重连状态消息
     * @param sessionId
     * @return
     */
    MessageWrapper  getReConnectionStateMsg(String sessionId);
    
    /**
     * 获取下线状态消息
     * @param sessionId
     * @return
     */
    ImMessage  getOffLineStateMsg(String sessionId);
}

