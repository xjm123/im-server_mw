/**
 ***************************************************************************************
 *  @Author     1044053532@qq.com   
 *  @License    http://www.apache.org/licenses/LICENSE-2.0
 ***************************************************************************************
 */
package com.qiqiim.server.group;

import com.google.gson.Gson;
import com.qiqiim.common.utils.JsonUtils;
import com.qiqiim.console.redis.RedisUtil;
import com.qiqiim.server.model.ImMessage;
import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.ChannelGroupFuture;
import io.netty.channel.group.ChannelMatcher;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.Iterator;

/**
 * Im广播组
 * 用于推送全员信息及系统消息 或断开所有用户连接
 *
 */
public class ImChannelGroup {
	 
    private static final ChannelGroup CHANNELGROUP = new DefaultChannelGroup("ChannelGroup", GlobalEventExecutor.INSTANCE);
     
    public static void add(Channel channel) {
        CHANNELGROUP.add(channel);
    }
    public static void remove(Channel channel) {
        CHANNELGROUP.remove(channel);
    }
  
    /**
     * 广播 
     * @param msg
     * @return
     */
    public static ChannelGroupFuture broadcast(Object msg) {
//        String a = "{\"title\":\"123\",\"type\":\"0\",\"content\":\"nihao\"}";
//        Gson gson = new Gson();
//        String s = gson.toJson(msg);

//        String s = JsonUtils.ObjToJson(msg);
//
//        return CHANNELGROUP.writeAndFlush(new TextWebSocketFrame(s));

        ChannelGroup CHANNELGROUP_TEST = new DefaultChannelGroup("ChannelGroupTest", GlobalEventExecutor.INSTANCE);
        Iterator<Channel> iterator = CHANNELGROUP.iterator();
        while(iterator.hasNext()){
            Channel channel = iterator.next();
//            RedisUtil redisUtil = new RedisUtil();
            Jedis redisUtil = new Jedis("192.168.19.137",6379);
            String s = (String) redisUtil.get("NID:" + channel.id());
            if(s.equals(redisUtil.get("SESSIONID:"+((ImMessage)msg).getSender()))){
                CHANNELGROUP_TEST.add(channel);
            }

        }
        return CHANNELGROUP_TEST.writeAndFlush(msg);
    }
    /**
     * 广播
     * @param msg
     * @param matcher
     * @return
     */
    public static ChannelGroupFuture broadcast(Object msg, ChannelMatcher matcher) {
        return CHANNELGROUP.writeAndFlush(msg, matcher);
    }
     
    public static ChannelGroup flush() {
        return CHANNELGROUP.flush();
    }
    /**
     * 丢弃无用连接 
     * @param channel
     * @return
     */
    public static boolean discard(Channel channel) {
        return CHANNELGROUP.remove(channel);
    }
    /**
     * 断开所有连接
     * @return
     */
    public static ChannelGroupFuture disconnect() {
        return CHANNELGROUP.disconnect();
    }
    /**
     * 断开指定连接 
     * @param matcher
     * @return
     */
    public static ChannelGroupFuture disconnect(ChannelMatcher matcher) {
        return CHANNELGROUP.disconnect(matcher);
    }
    /**
     * 
     * @param channel
     * @return
     */
    public static boolean isExist(Channel channel) {
        return CHANNELGROUP.contains(channel);
    }
    public static int size() {
        return CHANNELGROUP.size();
    }
}