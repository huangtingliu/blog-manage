package com.huangtl.blog.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 *描述：http通讯测试
 *创建人:黄廷柳
 *创建日期：2016年5月30日 下午2:20:30
 **/
public class HttpTest {

	public static void main(String[] args) {
//		new readByHttpGet().start();
//		new readByHttpPost().start();
//		new readByHttpClientGet().start();
		new readByHttpClientPost().start();
	}
	
	
	/**
	 * http Get通信 
	*/
	static class readByHttpGet extends Thread{
		@Override
		public void run() {
			try {
				
				URL url = new URL("http://fanyi.youdao.com/openapi.do?keyfrom=huangtl-blog&key=255063158&type=data&doctype=xml&version=1.1&q=welcome");
				URLConnection cn = url.openConnection();
				InputStream in = cn.getInputStream();
				InputStreamReader isr = new InputStreamReader(in, "UTF-8");
				BufferedReader br= new BufferedReader(isr);
				
				String line;
				StringBuffer sb = new StringBuffer();
				while ((line=br.readLine())!=null) {
					sb.append(line);
				}
				System.out.println(sb);
				br.close();
				isr.close();
				in.close();
				/*System.out.println("Authority:"+url.getAuthority());
				System.out.println("Host:"+url.getHost());
				System.out.println("Port:"+url.getPort());
				System.out.println("Protocol:"+url.getProtocol());
				System.out.println("Query:"+url.getQuery());
				System.out.println("UserInfo:"+url.getUserInfo());
				System.out.println("DefaultPort:"+url.getDefaultPort());*/
				
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			super.run();
		}
	}

	/**
	 * 
	 * @author 黄廷柳
	 * @todo httpPost通信
	 * @时间  2016年5月30日下午3:19:08
	 */
	static class readByHttpPost extends Thread{
		@Override
		public void run() {
			
			try {
				URL url = new URL("http://fanyi.youdao.com/openapi.do");
				HttpURLConnection cn = (HttpURLConnection) url.openConnection();
				cn.setRequestMethod("POST");
				cn.setDoInput(true);//设置开启输入
				cn.setDoOutput(true);//设置开启输出

				OutputStream os  = cn.getOutputStream();
				OutputStreamWriter ow = new OutputStreamWriter(os);
				BufferedWriter bw = new BufferedWriter(ow);
				String param = "keyfrom=huangtl-blog&key=255063158&type=data&doctype=xml&version=1.1&q=welcome";
				bw.write(param);
				bw.flush();
				
				InputStream in = cn.getInputStream();
				InputStreamReader isr = new InputStreamReader(in);
				BufferedReader br = new BufferedReader(isr);
				
				String line;
				StringBuffer sb = new StringBuffer();
				while((line=br.readLine())!=null){
					sb.append(line);
				}
				
				System.out.println(sb);
				br.close();
				isr.close();
				in.close();
				bw.close();
				ow.close();
				os.close();
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			super.run();
		}
	}
	
}

/**
 * 
 * @author 黄廷柳
 * @todo httpClient get通信
 * @时间  2016年5月30日下午3:42:42
 */
class readByHttpClientGet extends Thread{
	@Override
	public void run() {
		try {
			HttpClient client = HttpClients.createDefault();
			
			HttpGet get = new HttpGet("http://fanyi.youdao.com/openapi.do?keyfrom=huangtl-blog&key=255063158&type=data&doctype=xml&version=1.1&q=welcome");
			HttpResponse re = client.execute(get);
			HttpEntity entity = re.getEntity();
			System.out.println(EntityUtils.toString(entity));
			
			get.releaseConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.run();
	}
}

/**
 * 
 * @author 黄廷柳
 * @todo httpClient post通讯
 * @时间  2016年5月30日下午4:13:34
 */
class readByHttpClientPost extends Thread{
	@Override
	public void run() {
		try {
			HttpClient client = HttpClients.createDefault();
			HttpPost post = new HttpPost("http://fanyi.youdao.com/openapi.do"); 
			
			//创建参数列表
			List<NameValuePair> list=new ArrayList<NameValuePair>();
			list.add(new BasicNameValuePair("keyfrom", "huangtl-blog"));
			list.add(new BasicNameValuePair("key", "255063158"));
			list.add(new BasicNameValuePair("type", "data"));
			list.add(new BasicNameValuePair("doctype", "xml"));
			list.add(new BasicNameValuePair("version", "1.1"));
			list.add(new BasicNameValuePair("q", "which"));
			
			//url格式编码
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list);
			
			post.setEntity(entity);
			
			HttpResponse re = client.execute(post);
			HttpEntity resultEntity = re.getEntity();
			
			System.out.println(EntityUtils.toString(resultEntity));
			
		}catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		super.run();
	}
}
