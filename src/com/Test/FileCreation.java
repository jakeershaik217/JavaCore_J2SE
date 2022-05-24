package com.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringBufferInputStream;

public class FileCreation {
	
	public static void main(String[] args) throws IOException {
		
		File src=new File("G:\\Java\\Notepad.txt");
		if(!src.exists()) {
		src.createNewFile();	
			
		}
         
		
		StringBuffer sb=new StringBuffer();
		sb.append("jakeer");
		FileOutputStream fou=new FileOutputStream(src);
		
		
	
	}

}
