package FilesHandle;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class NotePadClass {

	public static void main(String[] args) throws IOException {

		File src= new File("D:\\Notepad\\Sample.txt");
		
		if(!src.exists()){
			
			src.createNewFile();
		}
		System.out.println(System.getProperty("file.separator"));//used for "\" in windows and "/" in UNIX
		System.out.println(System.getProperty("java.class.path"));//Path used to find directories and JAR archives containing class files. Elements of the class path are separated by a platform-specific character specified in the path.separator property.
		System.out.println(System.getProperty("path.separator"));//path separator in java
		System.out.println(System.getProperty("java.home"));//path for JRE
		System.out.println(System.getProperty("java.vendor"));//java.vendor
		System.out.println(System.getProperty("java.vendor.url"));//JRE vendor URL
		System.out.println(System.getProperty("java.version"));
		System.out.println(System.getProperties());//get all the properties
		System.out.println(System.getProperty("os.arch"));//Operating system architecture
		System.out.println(System.getProperty("os.name"));//Operating system name
		System.out.println(System.getProperty("os.version"));//Operating system version
		System.out.println(System.getProperty("user.dir"));//User's current working directory
		System.out.println(System.getProperty("user.home"));//User home directory
		System.out.println(System.getProperty("user.name"));//User account name
		System.out.println(System.setProperty("os.arch", "Win"));
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("line.separator"));
		
		StringBuilder Sb=new StringBuilder();
		BufferedReader Br=new BufferedReader(new FileReader(src));
		while(Br.read()!=-1){
			
			System.out.println(Br.readLine());
			
		}
	
		
		
		
		
		
	}

}
