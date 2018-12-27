package com.qiqiim.server.group;

import java.util.List;

import com.qiqiim.server.model.Session;

import io.netty.channel.Channel;
import io.netty.channel.group.ChannelMatcher;

public class ChannelMatcherImpl implements ChannelMatcher {
	private List<Session> SessionList ;
	ChannelMatcherImpl( List<Session> SessionList){
		this.SessionList = SessionList;
	}
	@Override
	public boolean matches(Channel channel) {
		boolean isOK = false ; 
		if (SessionList != null && SessionList.size() > 0){
			for (Session session : SessionList){
				if (channel.id().asShortText().equals(session.getNid())){
					isOK = true ;
					break ;
				}
			}
		}
		return isOK;
	}

}
