package multiThreadingPractice;

public class SynchronizedClass {

	public static void main(String[] args) {
		
		Sam1 S1=new Sam1();
		Sam2 S2=new Sam2(S1);
		S2.start();
		int i=0;
		while(i<=5){
		S1.m1("Jak");
		}

	}

}

class Sam1{
	
	public  synchronized void m1(String S){
		
		int i=0;
		while(i<=5){
			
			System.out.println("m1"+S);
			++i;
		}	
		
		
	}
	
	
public  synchronized void m2(){
		
		int i=0;
		while(i<=5){
			
			System.out.println("m2");
			++i;
		}	
		
		
	}
	
	
	
	
}

class Sam2 extends Thread{
	
	Sam1 S;
	Sam2(Sam1 S){
		
		this.S=S;
		
	}
	public void run(){
	   
		int i=0;
		while(i<=5)
		S.m1("Hus");
		
		
		
		
	}
	
	
	
	
	
	
}
