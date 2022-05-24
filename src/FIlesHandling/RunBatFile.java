package FIlesHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class RunBatFile {
	private String FilePath;

	public static void main(String[] args) throws IOException {

		RunBatFile runBatFile=new RunBatFile("\\src\\FIlesHandling\\run.bat");

	}
	
	RunBatFile(String FilePath) throws IOException{
		
		String CurrentDirectory=System.getProperty("user.dir");
		File file=new File(CurrentDirectory+FilePath);
		if(file.exists()) {
		Runtime.getRuntime().exec(file.getAbsolutePath());
		System.out.println(file.getAbsolutePath());
		}else {
			
			throw new FileNotFoundException("File Directory"+file.getAbsolutePath()+"does ot exist");
		}
	}

}

