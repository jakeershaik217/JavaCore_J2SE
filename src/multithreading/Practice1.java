package multithreading;

import java.util.ArrayList;
import java.util.Collections;

class Thread1 extends Thread{
	int i=0;
	public void run(){
		
		while(i<=10){
			
			System.out.println("Thread");
			i=i+1;
			
			
		}
		
		
		
	}
	
}

public class Practice1 extends  Thread1{

	public static void main(String[] args) {
		
		Thread1 t=new Thread1();
		t.start();
		System.out.println(t.getName());
		t.setName("Thr");
		System.out.println(t.getName());
		/*System.out.println(t.getId());
		System.out.println(t.isAlive());
		System.out.println(t.activeCount());
		System.out.println(Thread.activeCount());*/
		System.out.println(t.getPriority());
		
		ArrayList<String>  a=new ArrayList(22);
		a.add("jak");
		a.add("jj");
		a.add("str");
		
		Collections.reverse(a);
		for(Object o:a){
			
			System.out.println(o);
			
		}
		
		
		
	}

}
