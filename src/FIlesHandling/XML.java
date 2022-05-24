package FIlesHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class XML {


	public static void main(String[] args) throws IOException {
		
		File src=new File("G:\\XML\\MbusaAMG_GT_C_RoadstarByoPage.xml");
		if(src.exists()!=true){
			
			src.createNewFile();
		}
		FileInputStream fin=new FileInputStream(src);
		
		Properties p=new Properties();
		p.loadFromXML(fin);
		String Str=p.getProperty("linkAMG_GT_C_Roadstar_ExteriorOptions1");//will get value of Key
		System.out.println(Str);
		String S1=(String)p.put("linkAMG_GT_C_Roadstar_ExteriorOptions1", "Jakeer");//will insert the value at the Key's value and return the previous value
		String S2=(String)p.put("Fevicol Se", "Jakeer");//will insert the value at the Key's value and return the previous value if the previous value is null then it will return null value
		String S3=(String)p.setProperty("paru", "shaik");
		String S4=(String)p.remove("paru");
		//p.clear(); will clear the property file
		boolean b=p.containsKey("imgAMG_GT_C_Roadstar_PerfSafetyFeatures1_1");// will return true if complete key value is present
		p.compute("linkAMG_GT_C_Roadstar_PerfSafetyFeatures1_1", (k, v) -> v.toString().contains("Blind") ? v+"change" : "change");
		//p.compute("linkAMG_GT_C_Roadstar_ExteriorOptions1", (k, v) -> (Object)v==(Object)10 ? 15 : 20);
		Set  S=p.entrySet();
		int keynumber=0;
		Iterator it=S.iterator();
		while(it.hasNext()==true){
			Map.Entry dd=(Map.Entry)it.next();
			if(dd.getKey().toString().contains("link")==true){
				
				dd.setValue("Link");
				++keynumber;
				
			}
			
			
			
		}
		System.out.println("The number of keys:::"+keynumber);
		FileOutputStream fout=new FileOutputStream(src);
		p.storeToXML(fout, "Just");
		System.out.println(S1);
		System.out.println(S2);
		System.out.println(S3);
		System.out.println(S4);
		System.out.println(b);
	}

}
