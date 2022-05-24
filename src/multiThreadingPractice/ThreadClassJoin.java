package multiThreadingPractice;

public class ThreadClassJoin{

	public static void main(String[] args) throws InterruptedException {
		
		ThreadClassExt t=new ThreadClassExt();
		t.start();
		Thread.currentThread().setPriority(2);
		int i=0;
		while(i<=5){
			
			t.join();//caller thread will wait untill t thread complete
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


	
