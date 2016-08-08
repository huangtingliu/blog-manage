package com.huangtl.blogmgr.model.common;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.huangtl.blogmgr.exceptoin.ServiceException;


/**
 * 用户操作后（如：修改用户，删除用户）后台统一返回的消息模型
 * @author PraiseLord
 * @date 2016年3月9日
 */

public class Message implements Serializable {
	private static final long serialVersionUID = 8645327167090301453L;
	
	private  String title;				//消息标题
	private final MessageType type;		//消息类型
	private Object content;				//消息内容
	private Object annex;				//附带结果
	
	private static final String title_msg = null;
	private static final String info_msg = "";
	private static final String success_msg = "操作成功！";
	private static final String warn_msg = "操作警告！";
	private static final String error_msg = "操作失败！";
	private static final String exception_msg = "系统异常！";
	public static final Message INFO;
	public static final Message SUCCESS;
	public static final Message WARN;
	public static final Message ERROR;
	public static final Message EXCEPTION;
	
	private Message(String title, MessageType type, Object content) {
		super();
		this.title = title;
		this.type = type;
		this.content = content;
	}
	
	static{
		INFO = new Message(title_msg, MessageType.info, info_msg);
		SUCCESS = new Message(title_msg, MessageType.success, success_msg);
		ERROR = new Message(title_msg, MessageType.error, error_msg);
		WARN = new Message(title_msg, MessageType.warn, warn_msg);
		EXCEPTION = new Message(title_msg, MessageType.exception, exception_msg);
	}
	
	public static Message info(Object content){
		return INSTANCE(title_msg, MessageType.info, content);
	}
	public static Message info(String title,Object content){
		return INSTANCE(title, MessageType.info, content);
	}
	public static Message success(Object content){
		return INSTANCE(title_msg, MessageType.success, content);
	}
	public static Message success(String title,Object content){
		return INSTANCE(title, MessageType.success, content);
	}
	public static Message warn(Object content){
		return INSTANCE(title_msg, MessageType.warn, content);
	}
	public static Message warn(String title,Object content){
		return INSTANCE(title, MessageType.warn, content);
	}
	public static Message error(Object content){
		return INSTANCE(title_msg, MessageType.error, content);
	}
	public static Message error(String title,Object content){
		return INSTANCE(title, MessageType.error, content);
	}
	public static Message exception(Object content){
		return INSTANCE(title_msg, MessageType.exception, content);
	}
	public static Message exception(String title,Object content){
		return INSTANCE(title, MessageType.exception, content);
	}
	
	/**
	 * 根据数据操作的影响结果，返回消息相应的消息对象
	 * @param effectRow
	 * @return
	 */
	public static Message get(int effectRow){
		if(effectRow>0){return Message.SUCCESS;}
		return Message.ERROR;
	}
	
	/**
	 * 参考 Message#get(int effectRow, String title,String successMsg,String errorMsg)
	 * @param effectRows
	 * @param content
	 */
	public static Message get(int effectRow, String successMsg,String errorMsg){
		if(effectRow>0){return Message.success(successMsg);}
		return Message.error(errorMsg);
	}
		
	/**
	 * 根据数据库返回的影响数来决定消息类型，规则：{@code effectRows} >0 success 否则为 error
	 * @param effectRows
	 * @param title
	 * @param content
	 * @return
	 */
	public static Message get(int effectRow, String title,String successMsg,String errorMsg){
		if(effectRow>0){return Message.success(title, successMsg);}
		
		return Message.error(title, errorMsg);
	}
	
	/**
	 * 创建一个消息实体
	 * @param title
	 * @param type
	 * @param content
	 * @return
	 */
	public static Message INSTANCE(String title, MessageType type, Object content){
		return new Message(title, type, content);
	}
	
	@JSONField(serialize=false)	//fastjson 注解
	public boolean isInfo(){
		return this.type==MessageType.info;
	}
	public boolean isSuccess(){
		return this.type==MessageType.success;
	}
	@JSONField(serialize=false)
	public boolean isWarn(){
		return this.type==MessageType.warn;
	}
	@JSONField(serialize=false)
	public boolean isError(){
		return this.type==MessageType.error || this.type == MessageType.exception;
	}
	@JSONField(serialize=false)
	public boolean isException(){
		return this.type==MessageType.exception;
	}
	
	/**
	 * 如果消息类型为error,或exception那么就抛出{@link ServiceException}
	 * @param message
	 */
	public void throwIfError(Object message){
		if(isError() || isException()){
			this.content = message;
			throw new ServiceException(this);
		}
	}
	
	/**
	 * 如果消息类型为error,或exception那么就抛出{@link ServiceException}
	 */
	public void throwIfError(){
		if(isError()|| isException()){throw new ServiceException(this);}
	}
	
	/**
	 * 转成json字符
	 * @return
	 */
	public String toJson(){
		return JSON.toJSONString(this);
	}
	
	public String getTitle() {
		return title;
	}
	public MessageType getType() {
		return type;
	}
	public Object getContent() {
		return content;
	}
	public Object getAnnex() {
		return annex;
	}
	/**
	 * 设置消息的附加数据
	 * @param data
	 */
	public void setAnnex(Object data) {
		this.annex = data;
	}
	/**
	 * 设置消息的内容
	 * @param content
	 */
	public void setContent(Object content){
		this.content = content;
	}
	/**
	 * 设置消息的标题
	 * @param title 
	 * @throws OperationNotSupportedException 如果对象为ERROR/INFO/SUCCESS..修改对象时将抛出
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return toJson();
	}
}
