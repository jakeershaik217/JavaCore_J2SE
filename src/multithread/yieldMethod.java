package multithread;

public class yieldMethod {

	public static void main(String[] args) {
		WithSleepMethod td=new WithSleepMethod();
		YieldChildClass t=new YieldChildClass();
		WitHighPriority ws=new WitHighPriority();
		WithLessPriority wl=new WithLessPriority();
		td.start();
		wl.start();
		t.start();
		ws.start();
		
		for(int i=0;i<10;i++) {
			   
		       
			System.out.println(Thread.currentThread().getName());
			Thread.yield();//will pause current thread and allocates the process for the remaining threads with same or high priority
			
		}
		System.out.println(Thread.currentThread().getName());
		System.out.println("MainClassPriority"+Thread.currentThread().getPriority());
		
		

	}

}

class WithSleepMethod extends Thread{
	
	
	
	public void run() {
		
		
		Thread.currentThread().setName("WithSleepMethod");

		
		for(int i=0;i<10;i++) {
			   
		       
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	
	}
}


class YieldChildClass extends Thread{
	
	
	
	public void run() {
		
		
		
		Thread.currentThread().setName("YieldChildClass");
		
		for(int i=0;i<10;i++) {
			   
		       
			System.out.println(Thread.currentThread().getName());
			Thread.currentThread().interrupt();
		}
		
	
	}
	
	
}
	class WithLessPriority extends Thread{
		
		
		public void run() {
			
			
			Thread.currentThread().setName("WithLessPriority");

			Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
			System.out.println(Thread.currentThread().getPriority());
			
			for(int i=0;i<10;i++) {
				   
			       
				System.out.println(Thread.currentThread().getName());
				
			}
			
		
		}	
		
		
		
		
		
		
	}
class WitHighPriority extends Thread{
		
		
		public void run() {
			
			
			Thread.currentThread().setName("WitHighPriority");

			Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
			System.out.println(Thread.currentThread().getPriority());
			
			for(int i=0;i<10;i++) {
				   
			       
				System.out.println(Thread.currentThread().getName());
				
			}
			
		
		}	
		
		
		
		
		
		
	}
