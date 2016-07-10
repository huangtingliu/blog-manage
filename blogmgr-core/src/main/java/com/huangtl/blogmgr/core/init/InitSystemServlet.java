package com.huangtl.blogmgr.core.init;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Properties;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 在系统启动后做些初始化的工作
 * @version 
 * @date 2016年4月1日
 * @author PraiseLord
 */
public class InitSystemServlet  implements Servlet {
	private static Logger logger = LoggerFactory.getLogger(InitSystemServlet.class);
	
	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		//加载配置文件
		initProperties(servletConfig.getServletContext(),servletConfig.getInitParameter("config"));
		//系统初始化工作
		if(System.getProperty("pld.init")!=null&&System.getProperty("pld.init").equals("true")){
			ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletConfig.getServletContext());
			Map<String, Initializable> initItems = context.getBeansOfType(Initializable.class);
			for (String key : initItems.keySet()) {
				logger.debug("{}开始初始化",key);
				initItems.get(key).init();
				logger.debug("{}完成初始化",key);
			}
		}
	}
	
	private void initProperties(ServletContext servletContext,String path){
		if(path==null){
			 logger.warn("InitSystemServlet的初始化参数config未指定系统配置文件路径");
			 return;
		}
		try {
			URL url = servletContext.getResource(path);
			Properties pop = new Properties();
			pop.load(url.openStream());
			for (Object key : pop.keySet()) {
				String k = key.toString();
				System.setProperty(k, pop.getProperty(k));
			}
		} catch (MalformedURLException e) {
			logger.error("系统初始异常",e);
		} catch (IOException e) {
			logger.error("系统初始异常",e);
		}
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void destroy() {
		
	}
}
