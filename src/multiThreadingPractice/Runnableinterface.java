package multiThreadingPractice;

public class Runnableinterface {

	public static void main(String[] args) {
		
		Runnableif r=new Runnableif();
		r.run();
		

	}

}

class Runnableif implements Runnable{
	
	public void run(){
		int i=0;
		while(i<=5){
			
			System.out.println(Thread.currentThread().getName());
			++i;
			
		}
		
	}
	
}