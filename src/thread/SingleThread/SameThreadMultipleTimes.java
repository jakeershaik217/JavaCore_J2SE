package thread.SingleThread;

public class SameThreadMultipleTimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WhileThread w1=new WhileThread();
		System.out.println("Thread 1");
		w1.start();
		w1.start();
		int i=10;
		w1.start();
		
	}

}
