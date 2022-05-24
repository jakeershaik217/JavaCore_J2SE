package multiThreadingPractice;

public class ThreadSleep {
	
	

	public static void main(String[] args) {
		
		
		ThreadClass2 d=new ThreadClass2();
		d.start();
		d.interrupt();//it will interrupt sleeping thread
		int i=0;
		while(i<=5){
			
			System.out.println(Thread.currentThread().getName());
			++i;
			
		}
		
	

	}

}

class ThreadClass2  extends Thread{
	
	public void run(){
		
		int i=0;
		while(i<=5){
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName());
			++i;
			
		}
		
	}
	
	
	
}