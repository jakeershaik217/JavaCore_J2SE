package exceptionHandling.checked;

import java.io.IOException;

public class CheckedPropagation {
	
	public void m1() throws Exception{
		
		throw new IOException("Throw");//Cheked exception
		//int a=25/0;
		
	}
	
	public void m2()throws Exception{
		
		
		m1();
	}
	
public void m3() {
		
		try{
		m2();
		}catch(Exception e){
			System.out.println("m1 block is caught");
		}
	}

	public static void main(String[] args){

		CheckedPropagation C=new CheckedPropagation();
		C.m3();
	}

}
