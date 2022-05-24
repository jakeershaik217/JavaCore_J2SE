package exceptionHandling.Throw;

import java.util.Scanner;

public class Throw {
	static void age(int age){
		if(age>20) {
			
			System.out.println("eligiable");
		}
		else {
			
			
		}
		
	}
	
	public static void main(String[] args) throws WorkspaceExcpetion {
		
		Scanner s=new Scanner(System.in);
		System.out.println("Enter a interger");
		int a=s.nextInt();
		age(a);
		throw new WorkspaceExcpetion("jakeer");
		
	}

}
