package com.huangtl.blogmgr.model.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.naming.OperationNotSupportedException;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.huangtl.blogmgr.exceptoin.ServiceOperateFailException;


/**
 * 用户操作后（如：修改用户，删除用户）后台统一返回的消息模型
 * @author PraiseLord
 * @date 2016年3月9日
 */

public class Message implements Serializable {
	private static final long serialVersionUID = 8645327167090301453L;
	
	private  String title;				//消息标题
	private final MessageType type;		//消息类型
	private String content;				//消息内容
	private Map<String, Object> data;	//返回结果
	
	private static final String title_msg = "操作提示";
	private static final String info_msg = "";
	private static final String success_msg = "操作成功！";
	private static final String warn_msg = "操作警告！";
	private static final String error_msg = "操作失败！";
	private static final String exception_msg = "系统异常！";
	private static final String modify_reject_msg = "拒绝修改！";
	public static final Message INFO;
	public static final Message SUCCESS;
	public static final Message WARN;
	public static final Message ERROR;
	public static final Message EXCEPTION;
	
	private Message(String title, MessageType type, String content) {
		super();
		this.title = title;
		this.type = type;
		this.content = content;
	}
	
	static{
		INFO = new Message(title_msg, MessageType.info, info_msg){
			private static final long serialVersionUID = -1833549720584810885L;
			@Override
			public void setTitle(String title) throws OperationNotSupportedException {
				throw new OperationNotSupportedException(modify_reject_msg);
			}
			@Override
			public void setContent(String content) throws OperationNotSupportedException {
				throw new OperationNotSupportedException(modify_reject_msg);
			}
			@Override
			public void setData(Map<String, Object> data) throws OperationNotSupportedException {
				throw new OperationNotSupportedException(modify_reject_msg);
			}
			@Override
			public Message pushData(String key, Object value) throws OperationNotSupportedException {
				throw new OperationNotSupportedException(modify_reject_msg);
			}
		};
		SUCCESS = new Message(title_msg, MessageType.success, success_msg){
			private static final long serialVersionUID = 4235292389960576772L;
			@Override
			public void setTitle(String title) throws OperationNotSupportedException {
				throw new OperationNotSupportedException(modify_reject_msg);
			}
			@Override
			public void setContent(String content) throws OperationNotSupportedException {
				throw new OperationNotSupportedException(modify_reject_msg);
			}
			@Override
			public void setData(Map<String, Object> data) throws OperationNotSupportedException {
				throw new OperationNotSupportedException(modify_reject_msg);
			}
			@Override
			public Message pushData(String key, Object value) throws OperationNotSupportedException {
				throw new OperationNotSupportedException(modify_reject_msg);
			}
		};
		ERROR = new Message(title_msg, MessageType.error, error_msg){
			private static final long serialVersionUID = -4367202540338122215L;
			@Override
			public void setTitle(String title) throws OperationNotSupportedException {
				throw new OperationNotSupportedException(modify_reject_msg);
			}
			@Override
			public void setContent(String content) throws OperationNotSupportedException {
				throw new OperationNotSupportedException(modify_reject_msg);
			}
			@Override
			public void setData(Map<String, Object> data) throws OperationNotSupportedException {
				throw new OperationNotSupportedException(modify_reject_msg);
			}
			@Override
			public Message pushData(String key, Object value) throws OperationNotSupportedException {
				throw new OperationNotSupportedException(modify_reject_msg);
			}
		};
		WARN = new Message(title_msg, MessageType.warn, warn_msg){
			private static final long serialVersionUID = 6091253788900790488L;
			@Override
			public void setTitle(String title) throws OperationNotSupportedException {
				throw new OperationNotSupportedException(modify_reject_msg);
			}
			@Override
			public void setContent(String content) throws OperationNotSupportedException {
				throw new OperationNotSupportedException(modify_reject_msg);
			}
			@Override
			public void setData(Map<String, Object> data) throws OperationNotSupportedException {
				throw new OperationNotSupportedException(modify_reject_msg);
			}
			@Override
			public Message pushData(String key, Object value) throws OperationNotSupportedException {
				throw new OperationNotSupportedException(modify_reject_msg);
			}
		};
		EXCEPTION = new Message(title_msg, MessageType.exception, exception_msg){
			private static final long serialVersionUID = -3952314153162352153L;

			@Override
			public void setTitle(String title) throws OperationNotSupportedException {
				throw new OperationNotSupportedException(modify_reject_msg);
			}
			@Override
			public void setContent(String content) throws OperationNotSupportedException {
				throw new OperationNotSupportedException(modify_reject_msg);
			}
			@Override
			public void setData(Map<String, Object> data) throws OperationNotSupportedException {
				throw new OperationNotSupportedException(modify_reject_msg);
			}
			@Override
			public Message pushData(String key, Object value) throws OperationNotSupportedException {
				throw new OperationNotSupportedException(modify_reject_msg);
			}
		};
	}
	
	public static Message info(String content){
		return INSTANCE(title_msg, MessageType.info, content);
	}
	public static Message info(String title,String content){
		return INSTANCE(title, MessageType.info, content);
	}
	public static Message success(String content){
		return INSTANCE(title_msg, MessageType.success, content);
	}
	public static Message success(String title,String content){
		return INSTANCE(title, MessageType.success, content);
	}
	public static Message warn(String content){
		return INSTANCE(title_msg, MessageType.warn, content);
	}
	public static Message warn(String title,String content){
		return INSTANCE(title, MessageType.warn, content);
	}
	public static Message error(String content){
		return INSTANCE(title_msg, MessageType.error, content);
	}
	public static Message error(String title,String content){
		return INSTANCE(title, MessageType.error, content);
	}
	public static Message exception(String content){
		return INSTANCE(title_msg, MessageType.exception, content);
	}
	public static Message exception(String title,String content){
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
	public static Message INSTANCE(String title, MessageType type, String content){
		return new Message(title, type, content);
	}

	@JSONField(serialize=false)
	public boolean isInfo(){
		return this.type==MessageType.info;
	}
	@JSONField(serialize=false)
	public boolean isSuccess(){
		return this.type==MessageType.success;
	}
	@JSONField(serialize=false)
	public boolean isWarn(){
		return this.type==MessageType.warn;
	}
	@JSONField(serialize=false)
	public boolean isError(){
		return this.type==MessageType.error;
	}
	@JSONField(serialize=false)
	public boolean isException(){
		return this.type==MessageType.exception;
	}
	
	/**
	 * 如果消息类型为error,那么就抛出{@link ServiceOperateFailException}
	 * @param message
	 */
	public void throwIfError(String message){
		if(isError()){
			this.content = message;
			throw new ServiceOperateFailException(this);
		}
	}
	
	/**
	 * 如果消息类型为error,那么就抛出{@link ServiceOperateFailException}
	 */
	public void throwIfError(){
		if(isError()){throw new ServiceOperateFailException(this);}
	}
	
	/**
	 * 注入返回结果值
	 * @param key
	 * @param value
	 * @return
	 */
	public Message pushData(String key,Object value) throws OperationNotSupportedException{
		if(data==null){data = new HashMap<String, Object>();}
		data.put(key, value);
		return this;
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
	public String getContent() {
		return content;
	}
	public Map<String, Object> getData() {
		return data;
	}
	/**
	 * 设置消息的附加数据
	 * @param data
	 * @throws OperationNotSupportedException 如果对象为ERROR/INFO/SUCCESS..修改对象时将抛出
	 */
	public void setData(Map<String, Object> data)throws OperationNotSupportedException {
		this.data = data;
	}
	/**
	 * 设置消息的内容
	 * @param content
	 * @throws OperationNotSupportedException 如果对象为ERROR/INFO/SUCCESS..修改对象时将抛出
	 */
	public void setContent(String content)throws OperationNotSupportedException {
		this.content = content;
	}
	/**
	 * 设置消息的标题
	 * @param title 
	 * @throws OperationNotSupportedException 如果对象为ERROR/INFO/SUCCESS..修改对象时将抛出
	 */
	public void setTitle(String title) throws OperationNotSupportedException {
		this.title = title;
	}
	@Override
	public String toString() {
		return toJson();
	}
}
