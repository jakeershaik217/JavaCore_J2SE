package multiThreadingPractice;

public class ThreadPriorities {

	public static void main(String[] args) {
       
		PriorityCLS p=new PriorityCLS();
		p.start();
		int i=0;
		while(i<=5){
			
			System.out.println(Thread.currentThread().getName()+Thread.currentThread().getPriority());
			++i;
			
			
		}
		
		
	}

}


class PriorityCLS extends Thread{
	

	public void run(){
	int i=0;	
	while(i<=5){
		System.out.println(Thread.currentThread().getName()+Thread.currentThread().getPriority());
		++i;
		
		
	}
	
}
	
}

