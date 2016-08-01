import java.io.*;
import java.util.*;

public class Test {

  
  static LinkedList<Integer>result = new LinkedList<Integer>();
	
  public static HashSet<String> generatePrimes(int a){
	  
	  int[] primes = new int[a+1];
	  HashSet<String>set = new HashSet<String>();
	  
	  for(int p=2;p<=a;p++){
		  if(primes[p]==0){
			  for(int i=p*2;i<=a;i+=p){
				  primes[i]=1;
			  }
		  }
	  }
	  
	  for(int p=2;p<=a;p++){
		  if(primes[p]==0){
			  set.add(String.valueOf(p));  
		  }
	  }
	  return set;
  }
	
   public static HashSet<String> getPrimes(int a){
		
		HashSet<String>set = new HashSet<String>();
		int d=2;
			
		for(int n=2;n<=a;n++){
			for(int j=2;j<=Math.sqrt(n);j++){
				if(n%j!=0){
					set.add(String.valueOf(j));
				}
			}
		}
		
		return set;
	}
	
	public static void main(String[] args)throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        
        int Q = Integer.parseInt(line);
        String sa,sb;
        for (int i = 1; i <=Q; i++) {
            String input[] = br.readLine().split(" ");
            
            sa=input[0];
            sb=input[1];
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            
            HashSet<String>set = generatePrimes(b);
            String val;
            int f;
            long count=0;
            int numPrimes;
            for(int range=a;range<=b;range++){
            	val = String.valueOf(range);
            	numPrimes=0;
            	if(range==1){
            		count++;
            		continue;
            	}
            	for(String s:set){
                	f = Integer.parseInt(s);
                	if(range%f==0){
                		numPrimes++;
                	}
                }
            	if(val.length()==numPrimes){
            		count++;
            	}
            }
            System.out.println(count);
        }
	}
}