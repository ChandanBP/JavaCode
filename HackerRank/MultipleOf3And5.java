package Euler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultipleOf3And5 {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
		
			long numTestCases = Integer.parseInt(br.readLine());
			long N;
			long mult3,mult5,mult15;
			long sum3,sum5,sum15;
			long totalSum;
			
			for(long t=1;t<=numTestCases;t++){
				
				N = Long.parseLong(br.readLine());
				N=N-1;
				
				mult3 = N/3;
				mult5 = N/5;
				mult15 = N/15;
				
				sum3 = (3*mult3*(mult3+1))/2;
				sum5 = (5*mult5*(mult5+1))/2;
				sum15 = (15*mult15*(mult15+1))/2;
				
				totalSum = sum3+sum5-sum15;
				System.out.println(totalSum);
			}
			
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
	
}
