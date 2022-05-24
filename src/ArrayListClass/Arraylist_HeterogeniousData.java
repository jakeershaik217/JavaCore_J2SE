package ArrayListClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

import com.Test.Emp;

class Student implements Comparable{
	
int StudentID;
String StudentName;
static String CollegeName;
public  int compareTo(Object o) {
	
	Student s=(Student)o;
	if(StudentID==s.StudentID) {
		
		return 0;
	}
	else if(StudentID>s.StudentID) {
		
		
		return 1; 
	}
	else {
		
		return -1;
	}
	
}
public Student(){
	
	this(1,"Jakeer");
	
	
}
public Student(int StudentID,String StudentName)	{
	
	Student.CollegeName="HSB";
	this.StudentID=StudentID;
	this.StudentName=StudentName;
	System.out.println(StudentID+"------------"+StudentName);
	System.out.println(this.StudentID+"------------"+this.StudentName);
	
	
}
	
	
}

public class Arraylist_HeterogeniousData {
	
	public static void main(String[] args) {
	
	ArrayList a1=new ArrayList();
	Emp e=new Emp(123,"Employee");
	Student s=new Student();
	a1.add(e);
	a1.add(s);
	System.out.println(a1);//toString() method for all the Object
	a1.clear();//Checking the Memory Location using Hashcode is same after adding in another collection
	a1.add(e);
	a1.add(s);
	//Calling toString() Method
	for(Object o:a1) {
		
		System.out.println(o.toString());
		System.out.println(o);
	}
  
	//Copying one arrayList(Collection of Object) into another ArrayList using "addAll()"
	ArrayList a2=new ArrayList();
	a2.addAll(a1);
	System.out.println(a2);
	
	//Contains()  check
	System.out.println(a1.contains(e));
	//trimtoSize() for trimming arrayList to Current size
	a1.trimToSize();
	System.out.println("After Trim"+" "+a1.size());
	a1.add("SHAIK");
	System.out.println("After adding Object"+" "+a1.size());
	
	
	//get() Check
	System.out.println("Get the index of the List"+"  "+a1.get(a1.size()-1));
	//Set() to replace the Index value with new Value
	a1.set(a1.size()-1,"Set MEthods Works");//method check
	System.out.println(a1.get(a1.size()-1));
	
	//Object Cloning(Creating Duplicates)
	Object a3=a1.clone();
	System.out.println("After Object Cloning"+"   "+a3);
	
	//RemoveAll()
	System.out.println("Before Remove all"+" "+a2);
	a2.removeAll(a1);//Method check
	System.out.println("After Remove all "+" "+a2);
	
	
	//Adding Null value since ArrayList supports Null insertion
	a1.add(null);
	System.out.println("Printing the ArrayList A after Null insertion"+a1);
	
	//Printing the location of the Object,it is not present return -1 value
	int index=a1.indexOf(null);
	System.out.println("Printing the Index of current Object"+"   "+index);
	
	int inx=a1.indexOf("SHAIK");
	System.out.println("Printing the Index of current Object"+"  "+inx);
	
	//Contains()
	a1.clear();
	a1.add("High");
	a1.add("Low");
	System.out.println(a1.contains("High"));
	
	//ContainsAll()
	a2.addAll(a1);
	System.out.println(a1.containsAll(a1));
	
	
	a1.ensureCapacity(2);
	
	
	//Hashcode()
	StringBuffer sb=new StringBuffer("Jakeer");
	a1.add(sb);
	a1.add(e);
	System.out.println(a1.toString());
	for(Object o:a1) {
	System.out.println(o);
	System.out.println(o.hashCode());
	}
	
	
	//Equals()
	a2.clear();
	a2.addAll(a1);
	System.out.println("***********Equals Method******************");
	System.out.println(a1.equals(a2));
	System.out.println("***********Equals Method after Change******************");
	a1.set(0, "Low");
	System.out.println(a1.equals(a2));
	
	//Iterator
	Iterator itr = a1.iterator();
	while(itr.hasNext()){
		
		Object o=itr.next();
		System.out.println("Iterator");
		System.out.println(o);
	}
	
	ListIterator lst=a1.listIterator();
	
	while(lst.hasNext()) {
		
		Object o=lst.next();
		System.out.println("Iterator");
		System.out.println(o);
		
		
	}
	
	//converting Array to ArrayList
	System.out.println("*************converting Array to ArrayList*******************");
	String[] array= {"Jakeer","Hussain","Shaik"};
	ArrayList<String> arlst=new ArrayList<String>(Arrays.asList(array));
	for (String string : arlst) {
		
		System.out.println(string);
		
		
	}
	
	
	//Converting ArrayList to Array when ArrayList contains same type of objects
	
	System.out.println("*********Converting ArrayList to Array when ArrayList contains same type of objects************");
	String[] Str=new String[arlst.size()];
	arlst.toArray(Str);
    for (String string : Str) {
		
		System.out.println(string);
		
	 }
	
    
  //Converting ArrayList to Array when ArrayList contains different type of objects
	
  	System.out.println("*********Converting ArrayList to Array when ArrayList contains different type of objects************");
  	ArrayList anew=new ArrayList();
  	anew.add("New");
  	anew.add(10.5);
  	anew.add(10);
  	Object[] obj=anew.toArray();
      for (Object string : obj) {
  		
  		System.out.println(string);
  		
  	 }
      
      //Sorting String data in the Arraylist
      System.out.println("*********Sorting the Arraylist******************");
      System.out.println("Before Sort"+"\n"+arlst);
      Collections.sort(arlst);
      System.out.println("After Sort"+"\n"+arlst);
      
      //Sorting The Object in ArrayList
      
      System.out.println("*********Sorting the Arraylist By StudentID******************");
      
      ArrayList<Student> a4=new ArrayList<Student>();
      a4.add(new Student(136,"Jakeer"));
      a4.add(new Student(123,"Hussain"));
      a4.add(new Student(125,"Shaik"));
      System.out.println("Before Sorting");
      for(Student Sd:a4) {
    	  
    	  System.out.println(Sd.StudentID);  
    	  
      }
     
     
      Collections.sort(a4);
      System.out.println("After Sorting");
   for(Student Sd:a4) {
    	  
    	  System.out.println(Sd.StudentID);  
    	  
      }
   
   System.out.println("*********Sorting the Arraylist By Emp Name******************");
   ArrayList<Emp> a5=new ArrayList<Emp>();
   a5.add(new Emp(136,"Jakeer"));
   a5.add(new Emp(123,"Hussain"));
   a5.add(new Emp(125,"Shaik"));
   System.out.println("Before Sorting");
   for(Emp Sd:a5) {
 	  
 	  System.out.println(Sd.Sdr);  
 	  
   }
   Collections.sort(a5);
   System.out.println("After Sorting");
   for(Emp Sd:a5) {
	 	  
	 	  System.out.println(Sd.Sdr);  
	 	  
	   }
      
	}
}
