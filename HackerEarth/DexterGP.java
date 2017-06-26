package com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class DexterGP {
	
	static long modInverse(long a, long m)
	{
	    long g = gcd(a, m);
	    if (g != 1)
	    	return (long)-1;
	    else
	    {
	    	return power(a, m-2, m);
	    }
	}
	
	static long power(long x, long y, long m)
	{
	    if (y == 0)
	        return 1;
	    long p = power(x, y/2, m) % m;
	    p = (p * p) % m;
	 
	    return (y%2 == 0)? p : (x * p) % m;
	}
	
	static long gcd(long a, long b)
	{
	    if (a == 0)
	        return b;
	    return gcd(b%a, a);
	}
	
	static long expoModulo(long x,long y,long p){
		
		long res = 1;      // Initialize result
		 
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
	
	
	public static void main(String[] args) {
		
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String line = br.readLine();
			
			int T = Integer.parseInt(line);
			for(int t=1;t<=T;t++){
				line = br.readLine();
				String input[]=line.split(" ");
				long r = Long.parseLong(input[0]);
				long s = Long.parseLong(input[1]);
				long p = Long.parseLong(input[2]);
				
				s=s%p;
				
				long rMinusOne = ((r%p)-(1%p))%p;
				long rhs = (((rMinusOne)%p)*(s%p))%p;
				rhs = (rhs%p+1%p)%p;
				if(rhs%p==0){
					System.out.println(-1);
					continue;
				}
				else{
					
					long h = rhs; // s
					long g = r;  // r
					
					long m = (long)Math.ceil(Math.sqrt(p));
					
					HashMap<Long, Integer>left = new HashMap<>();
					for(int i=0;i<m;i++){
						left.put(expoModulo(g, i, p)%p, i);
					}
					
					long gMinusM = modInverse(g, p)%p;
					if(gMinusM==-1){
						System.out.println(-1);
						continue;
					}
					gMinusM = expoModulo(gMinusM, m, p)%p;
					
					boolean flag=false;
					for(int j=0;j<m;j++){
						long val = expoModulo(gMinusM, j, p)%p;
						val = ((val%p) *(h%p))%p;
						if(left.containsKey(val)){
							long i=left.get(val);
							long index = j*m+i;
							System.out.println(index);
							flag=true;
							break;
						}
					}
					if(!flag)
					System.out.println(-1);
				}
			}
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
}
