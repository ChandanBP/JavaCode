package Euler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargestPrimeFactor {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
		
			long numTestCases = Long.parseLong(br.readLine());
			long N;
			long factors;
			
			for(int t=1;t<=numTestCases;t++){
				
				N = Long.parseLong(br.readLine());
				factors = (long)Math.sqrt(N);
				System.out.println(Math.sqrt(N));
			}
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
	
}
