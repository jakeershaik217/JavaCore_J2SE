package StringCls;

public class StringBufferClass {

	
	public static void main(String[] args) {
		
		StringBuffer Sb=new StringBuffer("Jakeer");
		Sb.append("jakeer");
		Sb.append(System.lineSeparator());
		System.out.println(Sb.capacity());
		Sb.trimToSize();
		System.out.println(Sb.substring(0, 2));
		Sb.append(0);
		Sb.append(1);
		System.out.println(Sb.toString());
		

	}

}
