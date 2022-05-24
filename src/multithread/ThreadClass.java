package multithread;

public class ThreadClass {

	public static void main(String[] args) {
		Thread t2=new Thread("jakeer");//creates new Thread with the given name
		t2.start();
		t2.checkAccess();
		System.out.println(t2.getName());
		Thread t4=new Thread(new RunnableClass(), "hussain");
		t4.start();
		System.out.println(t4.getName());
		System.out.println(Thread.currentThread().activeCount());
		for(int i=0;i<10;i++) {
			
			System.out.println(Thread.currentThread().getName());
			
			
		}
		System.out.println(Thread.currentThread().activeCount());
		
	}

}
class ThreadChild extends Thread{
	
	
	public void run() {
		
   for(int i=0;i<10;i++) {
			
			System.out.println(Thread.currentThread().getName());
			
			
		}
		
	}
	
	
	
}


class RunnableClass implements Runnable{
	
	
	public void run() {
		
   for(int i=0;i<10;i++) {
			
			System.out.println(Thread.currentThread().getName());
			
			
		}
		
	}
	
	
	
}