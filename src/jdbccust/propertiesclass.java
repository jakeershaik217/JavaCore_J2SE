package jdbccust;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

import com.codeid.demo.App;

public class propertiesclass {
	
	public static Connection Cn;
	public static File fs;
	public static FileInputStream fin;
	public static Properties p;
	public static String Std[]=new String[2];;
	
	public static String[] loadXML(String Location,String UserIDKey,String PasswordKey) throws IOException{
		fin=new FileInputStream(new File(Location));
		p=new Properties();
		p.loadFromXML(fin);
		String St1=p.getProperty(UserIDKey);
		String St2=p.getProperty(PasswordKey);
		Std[0]=St1;
		Std[1]=St2;
		return Std;
		
	}

	public static void main(String[] args) throws IOException {
		
		loadXML("C:\\Users\\Jakeer\\eclipse-workspace\\Core Java\\src\\Collection\\Notepad.xml", "userid", "password");


	}

}
