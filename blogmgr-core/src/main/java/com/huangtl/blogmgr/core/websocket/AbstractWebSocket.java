package com.huangtl.blogmgr.core.websocket;


import java.io.IOException;
import java.util.Collection;
import java.util.Date;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * WebSocket模板
 * @author PraiseLord
 * @date 2016年3月4日
 */
public abstract class AbstractWebSocket {
	private static Logger logger = LoggerFactory.getLogger(AbstractWebSocket.class);
	//会话id
	protected String sessionId;
	//连接会话
	protected Session session;
	//客户信息
	protected ClientInfo clientInfo;
	
	protected abstract void onOpen(Session session);
	protected abstract void onClose();
	protected abstract void onError(Session session, Throwable error);
	protected abstract void onMessage(String message, Session session);
	
	/**
	 * 通过{@code AbstractWebSocket} 中的{@code session},发送文本消息给客户端
	 * @param message 消息内容
	 * @param socket  消息对象
	 * @param type    发送方式(异步、同步),如果为空则为SendType.Basic同步方式
	 */
	public static void sendMessageText(String message,AbstractWebSocket socket,SendType type){
		//if(socket==null || socket.getSession()==null){return;}
		if(type==null){type = SendType.Basic;}
		
		if(SendType.Async==type){
			socket.getSession().getAsyncRemote().sendText(message);
		}else if(SendType.Basic == type){
			try {
				socket.getSession().getBasicRemote().sendText(message);
			} catch (IOException e) {
				logger.error("消息发送失败：\n消息内容：{}\n客户信息：{}\n发送类型：Async",message,socket.getClass());
				logger.error("异常信息",e);
			}
		}
	}
	/**
	 * 文本消息群发
	 * @param sockets 允许集合为空
	 */
	public static void sendMessageText(String message,Collection<AbstractWebSocket> sockets,SendType type){
		if (CollectionUtils.isEmpty(sockets)) {return;}
		for (AbstractWebSocket socket : sockets) {
			sendMessageText(message,socket,type);
		}
	}
	
	
	@OnOpen
	public final void _onOpen(Session session){
		if(session==null){return;}
		
		this.sessionId = session.getId();
		this.session = session;
		this.clientInfo = new ClientInfo(sessionId);
		this.clientInfo.setConnectDate(new Date());
		
		logger.info("新的连接\n用户信息：{}。",clientInfo.toString());
		onOpen(session);
	}
	
	@OnClose
	public final void _onClose(){
		onClose();
		logger.info("用户退出连接\n用户信息：{}",clientInfo.toString());
		session = null;
		sessionId = null;
		clientInfo = null;
	}
	
	@OnError
	public final void _onError(Session session, Throwable error){
		logger.error("WebSocket连接发生了错误！", error);
		onError( session, error);
	}
	
	@OnMessage
	public final void _onMessage(String message, Session session){
		logger.debug("【{}】消息:{}",this.sessionId,message);
		onMessage( message,session);
	}
	
	public Session getSession() {
		return session;
	}
	public ClientInfo getClientInfo() {
		return clientInfo;
	}
	public String getSessionId() {
		return sessionId;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
	
	/**
	 * 消息发送类型
	 * @author PraiseLord
	 * @date 2016年3月4日
	 */
	public enum SendType{
		Async,	//异步推送
		Basic;	//同步推送
	}
	
	/**
	 * 客户信息
	 * @author PraiseLord
	 * @date 2016年3月4日
	 */
	public static class ClientInfo{
		private String id;	//标识(也是sessionId)
		private String ip;	//用户ip
		private String browse;	//用户使用的浏览器
		private String device;	//用户所使用的设备pc/phone
		private String nick;	//呢称
		private String address;	//所处地址
		private Date connectDate;	//接入时间
		
		public ClientInfo() {
			this(null);
		}
		public ClientInfo(String id) {
			super();
			this.id = id;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getIp() {
			return ip;
		}
		public void setIp(String ip) {
			this.ip = ip;
		}
		public String getBrowse() {
			return browse;
		}
		public void setBrowse(String browse) {
			this.browse = browse;
		}
		public String getDevice() {
			return device;
		}
		public void setDevice(String device) {
			this.device = device;
		}
		public String getNick() {
			return nick;
		}
		public void setNick(String nick) {
			this.nick = nick;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public Date getConnectDate() {
			return connectDate;
		}
		public void setConnectDate(Date connectDate) {
			this.connectDate = connectDate;
		}
		@Override
		public String toString() {
			return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
		}
	}
}
