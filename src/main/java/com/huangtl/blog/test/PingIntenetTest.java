package com.huangtl.blog.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *描述：
 *创建人:黄廷柳
 *创建日期：2016年5月19日 上午9:49:20
 **/
public class PingIntenetTest {

//	public static void main(String[] args) {
//		String ip = "192.168.1.";
//        for (int i = 0; i <= 255; i++) {
//            InetAddress n;
//            try {
//                n = InetAddress.getByName(ip + i);
//            	if (n.isReachable(1)){
//            		System.out.println(ip+i);
//            	}
////                n = InetAddress.getAllByName(ip + i);
//                //System.out.println(ip+i);
////                for (int j = 0; j < n.length; j++) {
////                	if (n[j].isReachable(1)){
////                		System.out.println(ip+i);
////                		System.out.println(n[j].getHostAddress());
////                	}
////				}
//            } catch (UnknownHostException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            } catch (ConnectException e) {
//                // TODO Auto-generated catch block
//                System.out.println("==============");
//                System.out.println(ip + i);
//                System.out.println("==============");
//                e.printStackTrace();
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//	}
	
	public static void main(String[] args) {
		String ip = "192.168.1.";
		for (int i = 0; i <= 255; i++) {
			if(pingServer(ip+i,1)){
				System.out.println(ip+i);
			}
			System.out.println(pingServer(ip+i,1));
		}
	}

	 public static boolean pingServer(String server, int timeout)
	    {
	        BufferedReader in = null;
	        Runtime r = Runtime.getRuntime();
	       
	        String pingCommand = "ping " + server + " -n 1 -w " + timeout;
	        try
	        {
	            Process p = r.exec(pingCommand);
	            if (p == null)
	            {
	                return false;
	            }
	            in = new BufferedReader(new InputStreamReader(p.getInputStream()));
	            String line = null;
	            while ((line = in.readLine()) != null)
	            {
	                if (line.startsWith("Reply from"))
	                {
	                    return true;
	                }
	            }
	           
	        }
	        catch (Exception ex)
	        {
	            ex.printStackTrace();
	            return false;
	        }
	        finally
	        {
	            try
	            {
	                in.close();
	            }
	            catch (IOException e)
	            {
	                e.printStackTrace();
	            }
	        }
	        return false;
	    } 
}
