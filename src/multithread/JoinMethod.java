package multithread;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JoinMethod {

	public static void main(String[] args) throws InterruptedException {
		ThreadClassChild td=new ThreadClassChild();
		TrdChild t=new TrdChild();
		HighPriority ht=new HighPriority();
		LowPriority lw=new LowPriority();
		lw.start();
		ht.start();
		td.start();
		t.start();
		for(int i=0;i<10;i++) {
			   
		       
			System.out.println(Thread.currentThread().getName());
			//td.join();   //will wait the current Thread until to complete remaining thread
			
			td.join(100);
			
			
		}

	}

}

class ThreadClassChild extends Thread{
	
	
	
	public void run() {
		Thread.currentThread().setName("ThreadClassChild");

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

class TrdChild extends Thread{
	
	
	
	public void run() {
		Thread.currentThread().setName("TrdChild");

		for(int i=0;i<10;i++) {
			   
		       
			System.out.println(Thread.currentThread().getName());
			
			
		}
		
	}
	
	

}

class HighPriority extends Thread{
	
	
	
	public void run() {
		
		Thread.currentThread().setPriority(MAX_PRIORITY);
		Thread.currentThread().setName("HighPriority");
		for(int i=0;i<10;i++) {
			   
		       
			System.out.println(Thread.currentThread().getName());
			
			
		}
		
	}
	
	

}


class LowPriority extends Thread{
	
	
	
	public void run() {
		
		Thread.currentThread().setPriority(MIN_PRIORITY);
		Thread.currentThread().setName("LowPriority");
		for(int i=0;i<10;i++) {
			   
		       
			System.out.println(Thread.currentThread().getName());
		}
		
	}
	
	

}