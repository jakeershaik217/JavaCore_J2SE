package Variables;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.apache.http.entity.mime.content.InputStreamBody;

public class StaticVariables extends StaticVariableBaseClass {
	
	public StaticVariables(int i){
		
		
		super(i);
		
		
	}
	
	public static void main(String[] args){
		
		StaticVariableBaseClass sb=new StaticVariableBaseClass(15);
		StaticVariableBaseClass sb1s=new StaticVariableBaseClass(10.0f,10.0);
		i=sb.m4();
		int i=sb.m4();
	    System.out.println(i);
		System.out.println(i);//1st way of accessing static variable
		System.out.println(sb.j);//accessing static variable using Object is not preferable(2nd Way)
		System.out.println(StaticVariableBaseClass.Str);//3rd Way of accessing
		System.out.println(d);
		System.out.println(b);
		System.out.println(f);
	    m1();         //1st way of accessing static method
	   sb.m1();       //accessing static method using Object is not preferable(2nd Way)
	   StaticVariableBaseClass.m1();//3rd Way of accessing
       sb.m3(22222);
       
       
	}

}

class StaticVariableBaseClass{
	
	
	static int i;
	static int j;
	static  String Str;
	static double d;
	static boolean b;
	static float f;
	public int ite;
	public static void m1(){
		
	j=j+1;	
		
	System.out.println(i);
	System.out.println(j);
	System.out.println(Str);
	
		
	}
	
	void m2(){
		
		int i;
	//	System.out.println(i); local value need to be initialized
		
		
	}
	public  StaticVariableBaseClass(int i){//local variable will be destroyed after method completion
		
		System.out.println("StaticVariableBaseClass(int i)");
		StaticVariableBaseClass.i=20;
		System.out.println(StaticVariableBaseClass.i);
		
		
	}
   public StaticVariableBaseClass(float f,double d){//
		
		System.out.println("StaticVariableBaseClass(float f,double d)");
		this.f=f;    //static keyword is not recommended by this keyword
		this.d=d;
		System.out.println(this.f+"\n"+this.d);
		
		
	}
   
   public void m3(int interger){
	   
	  i= interger;
	   
	   System.out.println(i);
	   
   }
   
   public int m4(){//same area so no object is required
	   
	   
	ite=50; 
	return ite;
	   
 
	   
   }
   
}
