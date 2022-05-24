package FIlesHandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class Text {
	
	public static File src=new File("G:\\Notepad\\txt.txt");
	public static File src1=new File("G:\\Notepad\\txt1.txt");
	public static File OUTPUT=new File("G:\\Notepad\\compare.txt");
   public static void CreateNewFIle() throws IOException {
		
	   if(src.exists()==false){
			
			src.createNewFile();
			
		}
	}

	public static void Bufferreader(String src) throws IOException {
		
		BufferedReader br=new BufferedReader(new FileReader(src));
		String Str;
		int ch;
		while((Str=br.readLine())!=null){
			
			System.out.println(Str);//for reading the lines of the txt file
			
		}
        while((ch=br.read())!=-1){
			
			System.out.println((char)ch);//for reading the lines of the txt file
			
		}
		
	}

public static void Scanner() throws FileNotFoundException{
	
	File file = new File("G:\\Notepad\\txt.txt");
    java.util.Scanner sc = new java.util.Scanner(file);
		 
		    while (sc.hasNextLine())
		      System.out.println(sc.nextLine());
		  }
	
public static void ReadingEntireFileWithoutLoop() throws FileNotFoundException{
	
	File file = new File("G:\\Notepad\\txt.txt");
	java.util.Scanner sc = new java.util.Scanner(file);
	 
    // we just need to use \\Z as delimiter
    sc.useDelimiter("\\Z");
 
    System.out.println(sc.next());
}

public static List readFileInList(String fileName) throws IOException{
	
	List<String> lines = Collections.emptyList();
	lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
	return lines;
}

public static void Listoperations() throws IOException{
	
	List l = readFileInList("G:\\Notepad\\txt.txt");
	ListIterator lt=l.listIterator();
	while(lt.hasNext()){
		
		
		System.out.println(lt.next());
	}
}
public static String readFileAsString(String fileName)throws Exception
{
  String data = "";
  data = new String(Files.readAllBytes(Paths.get(fileName)));
  return data;
}
public static void readFileAsString()throws Exception
{
	String data = readFileAsString("G:\\Notepad\\txt.txt");
    System.out.println(data);
}

public static void ReadFilesInDifferentWays() throws Exception{
	CreateNewFIle();
	Bufferreader("G:\\Notepad\\txt.txt");
	Scanner();
	ReadingEntireFileWithoutLoop();
	Listoperations();
	readFileAsString();
	
}
	
	
	public static void main(String[] args) throws Exception {
		BufferedWriter bw=new BufferedWriter(new FileWriter(OUTPUT));
		BufferedReader br1=new BufferedReader(new FileReader(src));
		BufferedReader br2=new BufferedReader(new FileReader(src1));
		String line1 = br1.readLine();
		String line2 = br2.readLine();
		String ch1;
		String ch2;
	    int linecounter=1;	
		
	
		while(line1!=null || line2!=null){
			
			if(line1==null || line2==null){
				System.out.println("Null");
				break;
			}
			else if(!line1.equals(line2)){
			
			
				char c1[]=line1.toCharArray();
				char c2[]=line2.toCharArray();
				
				if(c1.length>c2.length){
					int remcount=0;
					int count=0;
					char c3_1[]=new char[c1.length];
					char c3_2[]=new char[c1.length];
				for(int i=0;i<c2.length;i++){
					
					
					if(c1[i]!=c2[i]){
						
						c3_1[count]=c1[i];
						c3_2[count]=c2[i];
						count++;
						
					}
					
					remcount=i;
					
				}
					
				for(int i=remcount+1;i<c1.length;i++)	{
					
					c3_1[count]=c1[i];
					count++;
					
					
					
				}
					
					
				if(count!=0){
					System.out.println("\n"+"Different charectors in "+linecounter+"of first text file");
					for(char c: c3_1){
						
						System.out.print(c);
						
					}
					System.out.println("\n"+"Different charectors in "+linecounter+"of second text file");
					for(char c: c3_2){
						
						System.out.print(c);
						
					}
					
					}	
					
					
					bw.write(c3_1);
					bw.write(c3_2);
					bw.write(System.getProperty("line.separator"));
					
				}
				else if(c1.length<c2.length){
					
                    int remcount=0;
					int count=0;
					char c3_1[]=new char[c2.length];
					char c3_2[]=new char[c2.length];
				for(int i=0;i<c1.length;i++){
					
					
					if(c1[i]!=c2[i]){
						
						c3_1[count]=c1[i];
						c3_2[count]=c2[i];
						count++;
						
					}
					
					remcount=i;
					
				}
					
				for(int i=remcount+1;i<c2.length;i++)	{
					
					c3_2[count]=c2[i];
					count++;
					
					
					
				}
					
				if(count!=0){
					System.out.println("\n"+"Different charectors in "+linecounter+"of first text file");
					for(char c: c3_1){
						
						System.out.print(c);
						
					}
					System.out.println("\n"+"Different charectors in "+linecounter+"of second text file");
					for(char c: c3_2){
						
						System.out.print(c);
						
					}
					
					}	
					
					
				bw.write(c3_1);
				bw.write(c3_2);
				bw.write(System.getProperty("line.separator"));
				}
				else{

					

					int count=0;
					char c3_1[]=new char[c1.length];
					char c3_2[]=new char[c1.length];
				for(int i=0;i<c1.length;i++){
					
					
					if(c1[i]!=c2[i]){
						
						c3_1[count]=c1[i];
						c3_2[count]=c2[i];
						count++;
						
					}
					
					
					
				}
				
				if(count!=0){
				System.out.println("\n"+"Different charectors in "+linecounter+"of first text file");
				for(char c: c3_1){
					
					System.out.print(c);
					
				}
				System.out.println("\n"+"Different charectors in "+linecounter+"of second text file");
				for(char c: c3_2){
					
					System.out.print(c);
					
				}
				
				}
				
				bw.write(c3_1);
				bw.write(c3_2);
				bw.write(System.getProperty("line.separator"));
				
				
				
				}
				
			
		}
		else{
			
			

			System.out.println("Equal "+line1);
			
			
		}
		
			line1 = br1.readLine();
			line2 = br2.readLine();
			
			linecounter++;
			
		
		}

		bw.close();	
	}

}
