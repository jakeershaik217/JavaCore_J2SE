package Collection;

import java.util.Hashtable;

public class HashTableC {
	
	/**
	 * HastTable Methods Are synchronized
	 * @param args
	 */
	
	public static void main(String[] args) {
		java.util.Map<Long, String> hash1=new Hashtable<>();
		java.util.Map<Long, String> hash2=new Hashtable<>(25);
		java.util.Map<Long, String> hash3=new Hashtable<>(50,0.75f);
		java.util.Map<Long, String> hash4=new Hashtable<>(hash1);
		
		runHashCodeAllocation();
	}
	
	public static void runHashCodeAllocation() {
		
		Hashtable<hashCodearrangement, Object> hash=new Hashtable<>();//(Default capacity 11) 11  buckets will be created starting index of 0 to 10
		hash.put(new hashCodearrangement(10), "A");// placed in 10th bucket
		hash.put(new hashCodearrangement(0), "B");// placed in 0th bucket
		hash.put(new hashCodearrangement(12), "C");// placed in 1st bucket(12%11=1)
		hash.put(new hashCodearrangement(2), "D");// placed in 2nd bucket
		hash.put(new hashCodearrangement(16), "E");// placed in 5th bucket(16%11=1)    
		hash.put(new hashCodearrangement(5), "F");// placed in 5th bucket
		
	  //arrangement will happen from top of the bucket to bottom and if the same bucket contains more than one element then latest to oldest
	 //so keys might be 10,5(latest),16(oldest),2,12,0
		System.out.println(hash);
		
		
	}

}

class hashCodearrangement{
	
	int i;
	
	hashCodearrangement(int i){
		this.i=i;
	}
	
	public int hashCode() {
		return i;
	}
	public String toString() {
		
		return i+"";
	}
	
	
}
