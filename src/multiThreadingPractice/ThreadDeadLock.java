package multiThreadingPractice;

public class ThreadDeadLock{

	public static void main(String[] args) throws InterruptedException {
		
		ThreadClas t=new ThreadClas();
		t.start();
		Thread.currentThread().setPriority(2);
		int i=0;
		while(i<=5){
			
			t.join();
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

class ThreadClas extends Thread{
	
	
	
	@Override
	public void run(){
		
		int i=0;
		while(i<=5){
			try {
				Thread.currentThread().join();
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