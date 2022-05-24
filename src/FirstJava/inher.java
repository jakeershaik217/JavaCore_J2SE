package FirstJava;

public class inher extends jakeer {

	
	String S;
	public static void main(String[] args) {
		inher st=new inher();
		st.m1("Jakeer");
		System.out.println(st.S);
		jakeer js=new jakeer();
		js.m1("j");
		
		String[] Str= {"ja","hu"} ;
		for(int i=0;i<Str.length;i++) {
			
			System.out.println(Str[i]);
			
		}
		int[] it= {1,2,3,4};
         for(int i=0;i<it.length;i++) {
			
			for(int j=i+1;j<it.length;j++) {
				
				if(it[i]<it[j]) {
					
					
					
					
				}
				
			}
			
		}
		
		
	}
	
	void m1(String S){
	
		
		this.S=S;
		System.out.println("Base");
		
	}
	
	inher(){
		
		super(1,"j");
		System.out.println("inher");
		
	}
	

}

class jakeer{
	
	String S;	
void m1(String S){
	
		
		System.out.println("derived");
		
	}
jakeer(){
	
	
	System.out.println("vamsi");
}
jakeer(int i){
	
	
	System.out.println("krishna:");
}
jakeer(int i,String s){
	
	
	System.out.println("krishna:");
}
	
}


abstract class temp{
	
	
	
	public abstract void j();
	public abstract void j2();
	void m2() {
		
		
	}
	
	
	
	
	
}

abstract class jer extends temp{
	
	
	public void j() {
		
		
		
		
	}
	
	
	
}

interface ifr{
	
	public abstract void j();

	
}

class jie implements ifr{
	
	public void j(){
		
		
	}
	
	
	
	
	
}