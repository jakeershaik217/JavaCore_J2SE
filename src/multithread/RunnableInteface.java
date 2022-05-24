package multithread;

public class RunnableInteface extends Run {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println(Thread.activeCount());
		Thread t=new Thread(new Run());
		t.start();
		System.out.println(Thread.activeCount());
		Thread t1=new Thread(new ThreadYeild());
		t1.start();
		System.out.println(Thread.activeCount());
		Thread.currentThread().setName("Main Thread");
       for(int i=0;i<10;i++) {
			
			
			System.out.println(Thread.currentThread().getName());
			
			
		}
		
	}

}

class Run  implements Runnable {
	
	
	public void run() {
		
		Thread.currentThread().setName("Child Thread:::1");
		for(int i=0;i<10;i++) {
			
			
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(100);         //When Thread get sleep then remaining thread will interrupt and start running remaining thread
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
}
	class ThreadYeild implements Runnable{
		
		
		
		public void run() {
			Thread.currentThread().setName("Child Thread:::2");
			for(int i=0;i<10;i++) {
				
				
				System.out.println(Thread.currentThread().getName());
				Thread.yield();
				
			}	
			
			
			
			
			
			
			
			
		}
	}
	
