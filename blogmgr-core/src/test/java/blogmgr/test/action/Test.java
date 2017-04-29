package blogmgr.test.action;

public class Test {
	
	public static  Object a = new Object();
	public  static Object b = new Object();
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized(a){
				 try {
					Thread.sleep(2000);
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				 
				 synchronized (b) {
					 System.out.println("print a");
				}
				}
				
				
				
				
			}
		});
			
		
		Thread t2   = new Thread(new Runnable() {
			
			@Override
			public void run() {
				synchronized (b) {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}				
				
				
				synchronized (a) {
					System.out.println("print b");
				}  
				
				
				}
			}
		});
		
		t1.start();
		t2.start();
		
	}
	
}
