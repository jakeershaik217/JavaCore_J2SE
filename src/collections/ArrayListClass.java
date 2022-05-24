package collections;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListClass {

	public static void main(String[] args) {
		ArrayList<Object> A=new ArrayList<Object>();
		String temp="";
		
		String[] Str={"Jakeer","Hussain","Shaik","Jakeer","Jakeer","Hussain","Shaik","Jakeer"};
		for(int i=0;i<Str.length;i++){
			for(int j=i+1;j<Str.length;j++){
				
				if((Str[i]).equals(Str[j])){
					int k=j;
					while(k<Str.length){
						
						temp=Str[k+1];
						Str[k]=temp;
						k=k+1;
					
						
					}
					
				}

				
			}
			
		}
		
		for(String S:Str){
			
			
			System.out.println(S+"  ");
		}
		/*A.add("Hussain");
		A.add("Jakeer");
		A.add("Jakeer");
		A.add("Hussain");
		A.add("Hussain");
		A.add("Hussain");
		A.add("Hussain");
		A.add("Jakeer");
		A.add("Hussain");
		A.add("Hussain");
		A.add("Hussain");
		A.add("shaik");
		A.add(Math.PI);
		A.add("Jakeer");
		
		
		for(int i=0;i<A.size();i++){
			for(int j=i+1;j<A.size();j++){
				
				if((A.get(i)).equals(A.get(j))){
					
					
					A.remove(j);
					j--;
				}

				
			}
			
		}
		
		
		Iterator<Object> a=A.iterator();
		while(a.hasNext())
			System.out.println(a.next());*/
	}

}
