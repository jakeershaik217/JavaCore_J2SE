package exceptionHandling.checked;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Checked {
	
	public static void main(String []Jakeer) {
		
		try {
			
			Thread.sleep(3000);//Checked Expection(Checked By Complier)
			System.out.println("inside try block");
			/*Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
		      Unhandled exception type InterruptedException

		      at exceptionHandling.checked.Checked.main(Checked.java:7)*/
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    System.out.println("inside catch block");
		}
		

		
		try {
			File src=new File("Jakeer.txt"); //Checked Expection(Checked By Complier)	
			                     	
			FileInputStream File=new FileInputStream(src);//Checked Expection(Checked By Complier)
			System.out.println("inside try block");
			/*Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
			Unhandled exception type FileNotFoundException

			at exceptionHandling.checked.Checked.main(Checked.java:11)*/
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("inside catch block");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		try {
			Class.forName("oracle:jdbc:driver:OracleDriver");//Unhandled exception type ClassNotFoundException
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		try {
			Connection Con=DriverManager.getConnection("something");//Unhandled exception type SQLException
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
