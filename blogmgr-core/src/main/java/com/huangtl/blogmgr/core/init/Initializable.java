package com.huangtl.blogmgr.core.init;

/**
 * 凡实现该接口的都将在系统启动后调用初始化方法，用来初始化系统
 * @version 
 * @date 2016年4月1日
 * @author PraiseLord
 */
public interface Initializable {
	/**
	 * 初始化工作
	 */
	void init();
}
