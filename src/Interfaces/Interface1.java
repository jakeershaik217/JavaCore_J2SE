package Interfaces;

interface Interface1 extends Interface2,Interface3{
	
	public static void me(){
		
		System.out.println("static modifier is allowed in interface");
	} 
	void m1();
	void m2();

}

interface Interface2 {
	
	public int k=50;//by default variables are public and final
	public static int i=20;//ambiguous  situation
	void m3();//by default all methods public and abstract
	void m4();
public static void m7(){
		
		System.out.println("m7 ::: Interface2");
		
	}

}
interface Interface3 {
	/*{
		                     //instance blocks are not allowed
		
	}*/
	
	/*static{
		
		                      //static blocks are not allowed
	}*/
	public static int i=15;
	void m5();
	void m6();
	//void m6(int i);//overloading
	public static void m7(){
		
		System.out.println("m7 ::: Interface3");
		
	}

}