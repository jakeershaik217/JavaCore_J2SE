package Collection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


public class PropertiesClass {
	static Properties p;
	 public int getPropertyCount(String locator) throws IOException{        
         
         String searchFor = "\""+ (locator.substring(0, locator.length()));
         int searchLength = searchFor.length();                   
         int searchCount = 0;        
         FileInputStream fin=new FileInputStream(new File("C:\\Users\\Jakeer\\eclipse-workspace\\Core Java\\src\\Collection\\Notepad.xml"));	
         BufferedReader br = null;
         
         try {        
                           br = new BufferedReader(new InputStreamReader(fin));
             String ffline = null;                           
             while ((ffline = br.readLine()) != null) {
            	int it= ffline.length();
                                         for(int searchIndex=0; searchIndex<ffline.length(); ) {
                                                         int index=ffline.indexOf(searchFor,searchIndex);
                                                         if(index!=-1) {                                                                    
                                                                         searchCount++;
                                                                         searchIndex += index+searchLength;
                                                         } else {
                                                                         break;
                                                         }
                                         }
                         }  
         
         } catch(Exception e) {
                         System.out.println(e);
         } finally {
                         try {
                                         br.close();
                                         fin.close();
                         } catch (IOException e) {
                                         // TODO Auto-generated catch block
                                         e.printStackTrace();
                         }
         }
         if(searchCount == 0){
                        // Reporter.log(">>>> Check the XML - Property >>>> "+ locator +" not exists in XML");     
                         //Assert.fail("Check XML");
        	 System.out.println("COunt is zero");
         }
         
         //System.out.println("count is: "+searchCount);
         return searchCount;                       
         }              


	 public int getPropertyCount2(String Key) throws IOException {
		 FileInputStream fin=new FileInputStream(new File("C:\\Users\\Jakeer\\eclipse-workspace\\Core Java\\src\\Collection\\Notepad.xml"));
		 p.loadFromXML(fin);
	     int count=0;
		 Set set=p.entrySet(); 
		 Iterator it=set.iterator(); 
		 while(it.hasNext()) {
				Map.Entry<String,String> entry=(Map.Entry)it.next();	
				boolean b=entry.getKey().contains(Key);
				if(b) {
				count++;
				}
		 }
		 fin.close();
		 p.clear();
		return count;
		
	 }
	 
	public static void main(String[] args) throws IOException {
		p=new Properties();
		
		
		PropertiesClass pr=new PropertiesClass();
		
		System.out.println(pr.getPropertyCount("titlejakeer"));
		System.out.println(pr.getPropertyCount2("titlejakeer"));
		FileInputStream fin=new FileInputStream(new File("C:\\Users\\Jakeer\\eclipse-workspace\\Core Java\\src\\Collection\\Notepad1.xml"));	     
		
		p.loadFromXML(fin);   //loading xml
		Set set=p.entrySet();  //using cursor
		Iterator it1=set.iterator();
		while(it1.hasNext()) {
			Map.Entry<String,String> entry=(Map.Entry)it1.next();
			System.out.println(entry.getValue());
			System.out.println(entry.getKey());
			Integer i=Integer.parseInt(entry.getKey());
			if(i%(Integer)2==(Integer)0) {
			entry.setValue("even");
			}
			else{
				entry.setValue("odd");
			}
			
			
			
		}
		System.out.println("*********************Poperty update****************************");
		for(Object o:p.keySet()) {
			
			
			System.out.println(p.get(o));
			
		}
	       
		FileOutputStream fout=new FileOutputStream(new File("C:\\Users\\Jakeer\\eclipse-workspace\\Core Java\\src\\Collection\\Notepad.xml"));	
		p.storeToXML(fout, "updated xml");
	    p.clear();
	    
		
       
	}
	

	

}

