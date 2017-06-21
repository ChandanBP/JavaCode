import java.util.HashSet;
import java.util.Iterator;

public class Test {

	static int modInverse(int a, int m)
	{
	    int g = gcd(a, m);
	    if (g != 1)
	    	return -1;
	        //System.out.println("GCD doesnot exists");
	    else
	    {
	        // If a and m are relatively prime, then modulo inverse
	        // is a^(m-2) mode m
	    	return power(a, m-2, m);
	    	//System.out.println("Modular multiplicative inverse is "+power(a, m-2, m));
	    }
	}
	
	static int power(int x, int y, int m)
	{
	    if (y == 0)
	        return 1;
	    int p = power(x, y/2, m) % m;
	    p = (p * p) % m;
	 
	    return (y%2 == 0)? p : (x * p) % m;
	}
	
	static int gcd(int a, int b)
	{
	    if (a == 0)
	        return b;
	    return gcd(b%a, a);
	}
	
	static int expoModulo(int x,int y,int p){
		
		int res = 1;      // Initialize result
		 
	    x = x % p;  // Update x if it is more than or 
	                // equal to p
	 
	    while (y > 0)
	    {
	        // If y is odd, multiply x with result
	        if (y%2!=0)
	            res = (res*x) % p;
	 
	        // y must be even now
	        y = y>>1; // y = y/2
	        x = (x*x) % p;  
	    }
	    return res;
	}
	
	
	public static int computeAlphaModM(int alpha,int m,int modulo){
		
		int modInverse = modInverse(alpha, modulo);
		int expoMod = expoModulo(modInverse, m, modulo);
		return expoMod;
	}
	
	public static void main(String[] args) {
		
		int m = (int)Math.ceil(Math.sqrt(7));
		int alpha=3;
		int beta=6;
		int modulo=7;
		
		HashSet<Integer>set1 = new HashSet<>();
		
		for(int j=0;j<m;j++){
			set1.add(expoModulo(alpha, j, modulo));
		}
		
		int inverseModulo = modInverse(5, 7);
		int expoModulo = expoModulo(inverseModulo, m, modulo);
		
		
		HashSet<Integer>set2 = new HashSet<>();
		for(int i=0;i<m;i++){
			int val = expoModulo(expoModulo, i, modulo);
			val=(val*beta)%modulo;
			set2.add(val);
		}
		
		
		Iterator<Integer>ite = set1.iterator();
		while(ite.hasNext()){
			System.out.print(ite.next()+",");
		}
		
		System.out.println("***********");
		
		ite = set2.iterator();
		while(ite.hasNext()){
			System.out.print(ite.next()+",");
		}
	}
}
