package Collection ;

class EmployeeClass_GenericComparable implements Comparable<EmployeeClass_GenericComparable> {

	int EmpID;
	String EmpName;
	static String CompanyName;
	
	public  int compareTo(EmployeeClass_GenericComparable o) {
		
		
		
		if(EmpID==o.EmpID) {
			
			return 0;
		}
		else if(EmpID>o.EmpID) {
			
			return 1;
		}
		else {
			
			return -1;
		}
		
	}
	
	EmployeeClass_GenericComparable(int EmpID,String EmpName){
		
		this.EmpName=EmpName;
		this.EmpID=EmpID;
	}
	
}
