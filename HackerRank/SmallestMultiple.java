package Euler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SmallestMultiple {

	public static long gcd(long a, long b)
	{
	  while(a!=0 && b!=0)
	  {
	     long c = b;
	     b = a%b;
	     a = c;
	  }
	  return a+b; 
	}
	
	public static long getLCM(long a,long b){
		return a * (b / gcd(a, b));
	}
	
  public static void main(String[] args) {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
		
			int numTestCases = Integer.parseInt(br.readLine());
            int N;
            for(int t=1;t<=numTestCases;t++){
                
                N = Integer.parseInt(br.readLine());
                
                	
                	long res[] = new long[N];
                	for(int i=0;i<N;i++){
                		res[i]=i+1;
                	}
                	
                	long lcm = res[0];
                	for(int i=1;i<N;i++){
                		lcm = getLCM(lcm, res[i]);
                	}
                	System.out.println(lcm);
            }
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	
    }
}
