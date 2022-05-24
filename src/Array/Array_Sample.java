package Array;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Array_Sample {

	@Test
	public static void mn() {
		int temp=0;
		//Assert.assertTrue(false);
		Student[] s=new Student[(int)(Math.pow(10, 1))];
		s[0]=new Student();
		s[1]=new Student();
		//s[2]=new Custmer(); can't be allocate in array of type Student 
		//s[9999999]=new Student();
		//we can slove the problem by Object type array
		Object a[]=new Object[100];
		a[0]=new Student(); 
		                  //Not have stranded data structures so no methods are available        
		
		//Incremental Order of array
		
		Integer[] I1={1,2,4,3,5,124,254,12};
		for(int i=0;i<I1.length;i++){
			
			for(int j=i+1;j<I1.length-i;j++){
				
				if(I1[i].compareTo(I1[j])==1){
					
					temp=I1[j];
					I1[j]=I1[i];
					I1[i]=temp;
					
					
				}
				
			}
			
			
			
		}
		
		for(Integer I:I1){
			
			System.out.println(I);
		}
		
		
		
		//Decremental Order of array
		
				Integer[] I2={1,2,4,3,5,124,254,12};
				for(int i=0;i<I2.length;i++){
					
					for(int j=i+1;j<I2.length;j++){
						
						if(I2[i].compareTo(I2[j])==-1){
							
							temp=I2[j];
							I2[j]=I2[i];
							I2[i]=temp;
							
							
						}
						
					}
					
					
					
				}
				
				for(Integer I:I2){
					
					System.out.println(I);
				}
				
				
				
				
				//Remove duplicates
				int count2=0;
				String Str[]={"Jak","Hus","Jak","Shaik","shaik","Jak","shaik"};
				String Str1[]=Str;
				for(int i=0;i<Str1.length;i++){
					int count1=0;
					for(int j=0;j<Str.length;j++){
						
						if(Str1[i].equals(Str[j])){
							
							
							count1++;
						}
						
						
					}	
					
					
				}
				for(int i=0;i<Str.length;i++){
					
					for(int j=i+1;j<Str.length;j++){
						
						if(Str[i].equals(Str[j])){
							
							
							for(int k=j;k<Str.length;k++){
								
								
							}
							
							
						}
						
						
						
					}
					
					
					
					
				}
				
				
				
				
	}

}

class Student{
	
	Student(){
		
		
		System.out.println("Jakeer");
		
	}
	
	
}

class Custmer{
	
	
	
}
