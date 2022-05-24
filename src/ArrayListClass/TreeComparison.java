package ArrayListClass;

import java.util.ArrayList;
import java.util.Collections;

public class TreeComparison {

	public static void main(String[] args) {

		ArrayList<RoomMateClass> Rm=new ArrayList();
		Rm.add(new RoomMateClass(250,"Jakeer"));
		Rm.add(new RoomMateClass(120,"Venkat"));
		Rm.add(new RoomMateClass(125,"Bru"));
		Collections.sort(Rm);
		for(RoomMateClass R:Rm)
		System.out.println(R.Name);
		
		
	}
	
	

}

class RoomMateClass implements Comparable<RoomMateClass>{
	
	
	int Amount;
	String Name;
	RoomMateClass(int Amount,String Name){
		
		this.Amount=Amount;
		this.Name=Name;
	}
	
	public int compareTo(RoomMateClass O){
		
		
	if(Amount==O.Amount){
		
		return 0;
	}
	
	else if(Amount>O.Amount){
		
		
		return 1;
	}
	else{
		
		return -1;
	}
		
	}
}
