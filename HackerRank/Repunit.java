import java.io.*;
import java.util.*;

public class Repunit {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
        	
            String line = br.readLine();
            String input[] = line.split(" ");
            long L = Long.parseLong(input[0]);
            long R = Long.parseLong(input[1]);
            
            HashMap<Long,Boolean>primes = new HashMap<Long,Boolean>();
            for(long i=L;i<=R;i++){
            	if(primes.get(i)==null){
            		primes.put(i, true);
            	}
            	if(primes.get(i)==true){
            		for(int j=2;(i*j)<=R;j++){
            			primes.put((i*j), false);
            		}
            	}
            }
            
            String s;
            for(long i=L;i<=R;i++){
            	if(primes.get(i)){
            		s="1";
            		for(long k=1;k<=i-1;k++){
            			if((i-1)%k==0 && Long.parseLong(s)%i==0){
            				System.out.println(i);
            				s+="1";
            			}
            		}
            	}
            }
            
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
		
	}
	
}
