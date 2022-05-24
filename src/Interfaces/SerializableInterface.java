package Interfaces;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableInterface {

	public static void main(String[] args) throws IOException {
		Student s1=new Student("Jakeer");
		FileOutputStream fout=new FileOutputStream("G:\\Java\\Notepad.txt");
		ObjectOutputStream out=new ObjectOutputStream(fout);//Used to write the Byte 
		out.writeObject(s1);
		out.flush();
		out.writeBytes("jakeer");

	}

}

class Student implements Serializable{//Serializable is used to convert Object to byte Stream
	
	
	static String Str;
	int id;
	Student(String Str){
		
		this.Str="Jakeer";
		id=20;
		System.out.println(this.Str);
	
		
	}
	
	
}