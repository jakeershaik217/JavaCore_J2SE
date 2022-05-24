package exceptionHandling.checked;

import java.io.IOException;

public class UncheckedPropagation {
	
	public void m1(){
		
		 for(int i=0;i<=Math.pow(2,64);i++){
	         //System.out.println(i);
	         
	         }
		
	}
	
	public void m2(){
		
		
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

		UncheckedPropagation C=new UncheckedPropagation();
		C.m3();
	}

}
