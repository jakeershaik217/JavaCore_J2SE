package ComparatorClass;

import java.util.Comparator;
import java.util.TreeSet;

public class FinalComparatorClass {

	public static void main(String[] args) {
		
		
		TreeSet tr1=new TreeSet(new TeamIDComparator());
		tr1.add(new TeamNameClass(123,"Jakeer"));
		tr1.add(new TeamNameClass(231,"hussain"));
		tr1.add(new TeamNameClass(111,"shaik"));
		
		System.out.println(tr1);
		
	
	}

}


class TeamNameClass{
	
	int TeamID;
	String TeamName;
	static String Organisation="Syntel";
	TeamNameClass(int TeamID,String TeamName){
		
		this.TeamID=TeamID;
		this.TeamName=TeamName;
		
	}
	
	TeamNameClass(){
		
		
		
	}
	public String toString(){
		
		
		return TeamName;
		
	}
	
	
	
	
}

class TeamIDComparator implements Comparator<TeamNameClass>{
	
	
	public int compare(TeamNameClass o1,TeamNameClass o2){
		
		Integer i1=new Integer(o1.TeamID);
		Integer i2=new Integer(o2.TeamID);
		
	return  i1.compareTo(o2.TeamID);
}
}
	class TeamNameComparator implements Comparator<TeamNameClass>{
		
		
		public int compare(TeamNameClass o1,TeamNameClass o2){
			
		
		return o1.TeamName.compareTo(o2.TeamName);
		
		
		
		
		}
		}
	
