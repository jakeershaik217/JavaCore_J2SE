package Array;

public class Addition {
	

	public static void main(String[] args) {
 
		
		getPermutations(new char[]{'a','b'});
		
		
		
	}

	 public static void getPermutations(char[] array){  
	        helper(array, 0);  
	    }  

	    private static void helper(char[] array, int pos){  
	        if(pos >= array.length - 1){   
	            System.out.print("[");  
	            for(int i = 0; i < array.length - 1; i++){  
	                System.out.print(array[i] + ", ");  
	            }  
	            if(array.length > 0)   
	                System.out.print(array[array.length - 1]);  
	            System.out.println("]");  
	            return;  
	        }  
	  
	        for(int i = pos; i < array.length; i++){   
	          
	            char t = array[pos];  
	            array[pos] = array[i];  
	            array[i] = t;  
	  
	            helper(array, pos+1);  
	  
	            t = array[pos];  
	            array[pos] = array[i];  
	            array[i] = t;  
	        }  
	    }  
public void addition(int a,int b) {
	
	int c=0;
	c=a+b;
	
	System.out.println(c);
	
}
	
}
