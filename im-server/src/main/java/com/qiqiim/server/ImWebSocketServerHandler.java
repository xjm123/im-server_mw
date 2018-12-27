/**
 ***************************************************************************************
 *  @Author     1044053532@qq.com   
 *  @License    http://www.apache.org/licenses/LICENSE-2.0
 ***************************************************************************************
 */
package com.qiqiim.server;

import com.google.gson.Gson;
import com.qiqiim.common.utils.JsonUtils;
import com.qiqiim.server.model.ImMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qiqiim.constant.Constants;
import com.qiqiim.server.connertor.impl.ImConnertorImpl;
import com.qiqiim.server.model.MessageWrapper;
import com.qiqiim.server.proxy.MessageProxy;
import com.qiqiim.util.ImUtils;
@Sharable
public class ImWebSocketServerHandler   extends SimpleChannelInboundHandler<Object>{

	private final static Logger log = LoggerFactory.getLogger(ImWebSocketServerHandler.class);
    private ImConnertorImpl connertor = null;
    private MessageProxy proxy = null;

    public ImWebSocketServerHandler(MessageProxy proxy, ImConnertorImpl connertor) {
        this.connertor = connertor;
        this.proxy = proxy;
    }
	
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object o) throws Exception {
    	 String sessionId = ctx.channel().attr(Constants.SessionConfig.SERVER_SESSION_ID).get();
    	 String msg=ctx.channel().toString();
         String name=ctx.name();
         System.out.println("======="+msg+"========="+name);
    	//发送心跳包
    	if (o instanceof IdleStateEvent && ((IdleStateEvent) o).state().equals(IdleState.WRITER_IDLE)) {
			  if(StringUtils.isNotEmpty(sessionId)){
				  ImMessage builder = new ImMessage();
				  builder.setCmd(Constants.CmdType.HEARTBEAT);
			      builder.setMsgtype(Constants.ProtobufType.SEND);
				  ctx.channel().writeAndFlush(builder);
			  } 
 			 log.debug(IdleState.WRITER_IDLE +"... from "+sessionId+"-->"+ctx.channel().remoteAddress()+" nid:" +ctx.channel().id().asShortText());
 	    } 
	        
	    //如果心跳请求发出70秒内没收到响应，则关闭连接
	    if ( o instanceof IdleStateEvent && ((IdleStateEvent) o).state().equals(IdleState.READER_IDLE)){
			log.debug(IdleState.READER_IDLE +"... from "+sessionId+" nid:" +ctx.channel().id().asShortText());
			Long lastTime = (Long) ctx.channel().attr(Constants.SessionConfig.SERVER_SESSION_HEARBEAT).get();
	     	if(lastTime == null || ((System.currentTimeMillis() - lastTime)/1000>= Constants.ImserverConfig.PING_TIME_OUT))
	     	{
	     		connertor.close(ctx);
	     	}
	     	//ctx.channel().attr(Constants.SessionConfig.SERVER_SESSION_HEARBEAT).set(null);
	    }
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Object message)
			throws Exception {
		  try {
			   String sessionId = connertor.getChannelSessionId(ctx);
			  ImMessage m = new ImMessage();
			  if(message instanceof WebSocketFrame){
				  WebSocketFrame frame = (WebSocketFrame) message;
				  // 判断是否是关闭链路的指令
				  if (frame instanceof CloseWebSocketFrame) {
//                      handshaker.close(ctx.channel(), (CloseWebSocketFrame) frame.retain());
					  return;
				  }
				  // 判断是否是Ping消息
				  if (frame instanceof PingWebSocketFrame) {
					  ctx.channel().write(new PongWebSocketFrame(frame.content().retain()));
					  return;
				  }
				  // 当前只支持文本消息，不支持二进制消息
				  if (!(frame instanceof TextWebSocketFrame)) {
					  throw new UnsupportedOperationException("当前只支持文本消息，不支持二进制消息");
				  }

				  String text = ((TextWebSocketFrame) frame).text();
				  System.out.println(text);
                  m = JsonUtils.jsonToObj(text,ImMessage.class);
				  if(null!=m.getMessageBody()){
					  System.out.println(m.getMessageBody().getContent());
				  }else{
					  System.out.println("...............");
				  }

			  }

                // inbound
                if (m.getMsgtype() == Constants.ProtobufType.SEND) {
                	ctx.channel().attr(Constants.SessionConfig.SERVER_SESSION_HEARBEAT).set(System.currentTimeMillis());
                    MessageWrapper wrapper = proxy.convertToMessageWrapper(sessionId, m);
                    if (wrapper != null)
                        receiveMessages(ctx, wrapper);
                }
                // outbound
                if (m.getMsgtype() == Constants.ProtobufType.REPLY) {
                	MessageWrapper wrapper = proxy.convertToMessageWrapper(sessionId, m);
                	if (wrapper != null)
                      receiveMessages(ctx, wrapper);
                }
	        } catch (Exception e) {
	            log.error("ImWebSocketServerHandler channerRead error.", e);
	            throw e;
	        }
		 
	}
	
	//注册的
	public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
    	log.info("ImWebSocketServerHandler  join from "+ImUtils.getRemoteAddress(ctx)+" nid:" + ctx.channel().id().asShortText());
    }
	//关闭后调用
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        log.debug("ImWebSocketServerHandler Disconnected from {" +ctx.channel().remoteAddress()+"--->"+ ctx.channel().localAddress() + "}");
    }
//开启连接
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        log.debug("ImWebSocketServerHandler channelActive from (" + ImUtils.getRemoteAddress(ctx) + ")");
    }
//断开连接
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        log.debug("ImWebSocketServerHandler channelInactive from (" + ImUtils.getRemoteAddress(ctx) + ")");
        String sessionId = connertor.getChannelSessionId(ctx);
        receiveMessages(ctx,new MessageWrapper(MessageWrapper.MessageProtocol.CLOSE, sessionId,null, null));  
    }
    //异常捕获
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.warn("ImWebSocketServerHandler (" + ImUtils.getRemoteAddress(ctx) + ") -> Unexpected exception from downstream." + cause);
    }





    /**
     * to send message
     *
     * @param hander
     * @param wrapper
     */
    private void receiveMessages(ChannelHandlerContext hander, MessageWrapper wrapper) {
    	//设置消息来源为Websocket
    	wrapper.setSource(Constants.ImserverConfig.WEBSOCKET);
        if (wrapper.isConnect()) {
       	    connertor.connect(hander, wrapper); 
       	    System.out.println("初始用户绑定 =》"+wrapper.toString());
        } else if (wrapper.isClose()) {
        	connertor.close(hander,wrapper);
        } else if (wrapper.isHeartbeat()) {
        	connertor.heartbeatToClient(hander,wrapper);
        	System.out.println("********心跳********");
        	System.out.println(wrapper.toString());
        }else if (wrapper.isGroup()) {
        	connertor.pushGroupMessage(wrapper);
        	System.out.println("********群发********");
        	System.out.println(wrapper.toString());
        }else if (wrapper.isSend()) {
        	connertor.pushMessage(wrapper);
        } else if (wrapper.isReply()) {
        	System.out.println("1对1发送****************");
        	System.out.println(wrapper.toString());
        	connertor.pushMessage(wrapper.getSessionId(),wrapper);
        }  
    }
}
