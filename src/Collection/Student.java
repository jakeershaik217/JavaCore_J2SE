package Collection;

import java.util.Comparator;

class StudentClass{
	
	public String toString() {
		
		return this.StudentID+"  "+this.StudnetName;
	}
	
	public int hashCode() {
		
		return this.StudentID;
	}
	
	String StudnetName;
	int StudentID;
	StudentClass(int StudentID,String StudnetName){
		
		this.StudentID=StudentID;
		this.StudnetName=StudnetName;
	}

}

class StudentName implements Comparator{
	
	
	public int compare(Object o1,Object o2) {
		
		StudentClass s1=(StudentClass)o1;
		StudentClass s2=(StudentClass)o2;
		
		return  s1.StudnetName.compareTo(s2.StudnetName);
	}
	
	
}


class StudentID implements Comparator{
	
	
	public int compare(Object o1,Object o2) {
		
		StudentClass s1=(StudentClass)o1;
		StudentClass s2=(StudentClass)o2;
		if(s1.StudentID==s2.StudentID) {
			
			return 0;
		}
		else if(s1.StudentID>s2.StudentID) {
			
			return 1;
		}
		
        else {
			
			return -1;
		}
		
	}
	
	
}