package multiThreadingPractice;

public class ThreadClassyield{

	public static void main(String[] args) throws InterruptedException {
		
		ThreadClass1 t=new ThreadClass1();
		ThreadClassA d=new ThreadClassA();
		t.start();
		d.start();
		//Thread.currentThread().setPriority(2);
		int i=0;
		while(i<=5){
			
			Thread.currentThread().yield();
			System.out.println(Thread.currentThread().getName());
			++i;
		}
		
		Thread.currentThread().setName("Thread-A");
		i=0;
		while(i<=5){
			
			
			System.out.println(Thread.currentThread().getName());
			++i;
		}

	}

}

class ThreadClass1 extends Thread{
	
	
	
	@Override
	public void run(){
		
		Thread.currentThread().setPriority(7);
		int i=0;
		while(i<=5){
			
			
			System.out.println(Thread.currentThread().getName());
			++i;
		}
		
		Thread.currentThread().setName("Thread-B");
		i=0;
		while(i<=5){
			
			System.out.println(Thread.currentThread().getName());
			++i;
		}
		
		
	}
	
	
	
	
}


class ThreadClassA extends Thread{
	
	
	
	@Override
	public void run(){
		
		Thread.currentThread().setPriority(10);
		int i=0;
		while(i<=5){
			
			
			System.out.println(Thread.currentThread().getName());
			++i;
		}
		
		Thread.currentThread().setName("Thread-C");
		i=0;
		while(i<=5){
			
			System.out.println(Thread.currentThread().getName());
			++i;
		}
		
		
	}
	
	
	
	
}