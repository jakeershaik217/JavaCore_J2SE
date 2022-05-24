package multiThreadingPractice;

public class ThreadClassextension{

	public static void main(String[] args) throws InterruptedException {
		
		ThreadClassExt t=new ThreadClassExt();
		t.start();
		Thread.currentThread().setPriority(2);
		int i=0;
		while(i<=5){
			
			
			System.out.println(Thread.currentThread().getName());
			++i;
		}
		
		Thread.currentThread().setName("Thread-1");
		i=0;
		while(i<=5){
			
			
			System.out.println(Thread.currentThread().getName());
			++i;
		}

	}

}

class ThreadClassExt extends Thread{
	
	
	
	@Override
	public void run(){
		
		int i=0;
		while(i<=5){
			
			try {
				Thread.sleep(1);//Thread join will not effect due to sleep
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName());
			++i;
		}
		
		Thread.currentThread().setName("Thread-2");
		i=0;
		while(i<=5){
			
			System.out.println(Thread.currentThread().getName());
			++i;
		}
		
		
	}
	
	
	
	
}