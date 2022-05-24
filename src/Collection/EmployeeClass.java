package Collection ;

class EmployeeClass implements Comparable {

	int EmpID;
	String EmpName;
	static String CompanyName;
	
	public  int compareTo(Object o) {
		
		EmployeeClass emp=(EmployeeClass)o;
		
		if(EmpID==emp.EmpID) {
			
			return 0;
		}
		else if(EmpID>emp.EmpID) {
			
			return 1;
		}
		else {
			
			return -1;
		}
		
	}
	
	EmployeeClass(int EmpID,String EmpName){
		
		this.EmpName=EmpName;
		this.EmpID=EmpID;
	}
	
}
