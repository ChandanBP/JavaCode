package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlternatingCharacters {

	public static void main(String[] args) {

		
		try{
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int numTestCases = Integer.parseInt(br.readLine());
	        
	        for(int t=1;t<=numTestCases;t++){
	        	int i=0;
                int j;
                int sum=0;
	            String s = br.readLine();
	            if(s.length()<=1){
	                System.out.println(0);
	            }
	            else{
	                
	                while(i<=s.length()-1){
	                    if(s.charAt(i)=='A'){
	                        j = s.indexOf('B',i);
	                    }
	                    else{
	                        j = s.indexOf('A',i);
	                    }
	                    if(j==-1){
	                        sum+=s.length()-(i+1);
	                        break;
	                    }
	                    else if(j-i!=1){
	                    	
	                    	sum+=((j-1)-(i+1))+1;
	                    	i=j-1;
	                    }
	                    i++;
	                }
	                System.out.println(sum);
	            }
	        }
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
}