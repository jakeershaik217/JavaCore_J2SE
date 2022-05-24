import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

public class DataTypeRange {

	public static void main(String[] args) throws IOException {

		
	     //  int j=2147483648;  int range -(2^31)-1---0----2^31(4 bytes)
		//   int k=-2147483648; int range -(2^31)-1---0----2^31(4 bytes)
		//   char l=65536;  char->unsigned char range 0 to 65535
		//     double d=Math.pow(2, 64);
		//   System.out.println(d);
        int i=(int)Math.pow(2, 31);
		System.out.println(i);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		FileUtils.writeStringToFile(new File("G:\\Java\\D.txt"), "Jak");
		
		
	}

}
