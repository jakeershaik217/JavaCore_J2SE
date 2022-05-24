package com.Test;

public class Emp implements Comparable<Emp>{
	public String Sdr="Emp";
	public  int compareTo(Emp e) {
		
		
		return e.Sdr.compareTo(Sdr);
		
		
	}
	
	public Emp(){
		
		System.out.println("Emp");
	}
	
	public Emp(int a,String Sdr){
		this.Sdr=Sdr;
		
		
		
		
	}
	
	
	
}
