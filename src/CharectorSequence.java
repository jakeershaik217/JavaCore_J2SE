
public class CharectorSequence {
	
	public static void main(String args[]) {
		
		String S1="Jakeer";
		String S4="Jakeer";
		String S2=new String("Jakeer");
		String S3=new String("Jakeer");
		System.out.println(S2==S3);
		System.out.println(S1==S4);
		System.out.println("\""+"String comparison using equals method"+"\"");
		System.out.println(S2.equals(S3));
		System.out.println(S1.equals(S4));
		System.out.println(S1.equals(S3));
		System.out.println("\""+"hashCode comparison"+"\"");
		Object obj="Jakeer";
		//if .equals Methods returns true then hasCode of those two objects are same
		
		System.out.println(S1.hashCode()+"\t"+obj.hashCode());
		System.out.println(S1.hashCode()==obj.hashCode());
		System.out.println(S1.hashCode()==S2.hashCode());
		System.out.println(S1.hashCode()==S4.hashCode());
		
		//This is for String immutability
		S1.concat("Hussain");
		S2.concat("Hussain");
		System.out.println(S1);
		System.out.println(S2);

		
	}
	public int hashCode() {
		
		int i=super.hashCode();
		
		return i+78456112;
		
		
		
		
	}

	
	//******************Needs to investigate hashcode************************************
}
