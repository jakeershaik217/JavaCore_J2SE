package Object;

public class ObjectClass implements Cloneable {

	public void finalize(){
		
		System.out.println("before die i'll run this");
		
	}
	
	public int hashCode(){
		
		int hashc=super.hashCode();
		return hashc;
		
	}
	private int hashCode(int i){
		
		return i;
		
	}
   private int hashCode(int i,int j){
		
		return i;
		
	}
   public String toString(){
	   
	   return super.toString();
	   
   }
	public static void main(String[] args) throws CloneNotSupportedException {
		int hashcod=0; 
		ObjectClass obj[]={new ObjectClass(),new ObjectClass()};
		ObjectClass obj1=new ObjectClass();
		ObjectClass obj2=new ObjectClass();			
		hashcod=obj[1].hashCode();
		System.out.println(hashcod);
		System.out.println(obj[0].equals(obj[1]));
		obj[0]=(ObjectClass) obj[1].clone();
		System.out.println(obj[0].equals(obj[1]));
		obj=null;//here there r 2 objects thats why it will call the function 2 times
		System.gc();
		Integer a=5;
		Integer b=new Integer(5);
		System.out.println(a.equals(b));
		
		

	}

}
