package multithread;

class Singlethread extends Thread{//step 1 extend Thread class
	
	public void run() {// override run() method of thread class with Empty implementation
		
		System.out.println("one"); 
		System.out.println("two"); //Business Logics
		System.out.println("three"); 
		for(int i=0;i<=10;i++) {
			System.out.println("Jakeer");
			
		}
		
	}
	public void  noramMethod() {
		
		
		for(int i=0;i<=10;i++) {
			System.out.println("noramMethod");
			
		}	
		
		
	}
	
}




/*To start any thread we need a single main thread*/
public class TwoThreads {

	public static void main(String []args) {
		
		System.out.println("main 1");
		System.out.println("main 2");
		System.out.println(Thread.currentThread().activeCount());
		Singlethread s=new Singlethread();//Instantiation of user thread class 
		s.start(); 
		System.out.println(Thread.currentThread().activeCount());
		//start the user thread by calling start method(thread is created by registering in thread scheduler)
	//	s.start(); Same thread can't be called more than 1 time since it will dead once it is done
		System.out.println("main 3");
		System.out.println("main 4");
		for(int i=0;i<=10;i++) {               //Thread will be called off by Thread scheduler(Random algorithm it follows) 
			System.out.println("Main");
			
		}
		//Normal flow of execution
		System.out.println("*******Normal flow of execution**********************");
		s.noramMethod();
		for(int i=0;i<=10;i++) {
			System.out.println("Normal Main method");
			
		}
		
	}

}
