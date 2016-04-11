// Project Euler #2: Even Fibonacci numbers

package Euler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class EvenFibonacci {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
		
			long numTestCases = Long.parseLong(br.readLine());

			BigInteger N;
			BigInteger arr[];
			BigInteger res; 
			BigInteger mult = new BigInteger("4");
			BigInteger sum;
			
			for(int t=1;t<=numTestCases;t++){
				
				N = new BigInteger(br.readLine());
				
				arr = new BigInteger[3];
				arr[0] = new BigInteger("0");
				arr[1] = new BigInteger("0");
				arr[2] = new BigInteger("2");
				sum = new BigInteger("2");
				
				res = new BigInteger("1");
				res = res.multiply(arr[2]);
				res = res.multiply(mult);
				res = res.add(arr[1]);
				sum = sum.add(res);
				
				while(res.subtract(N).compareTo(BigInteger.valueOf(0))<0){
					
					arr[1] = arr[2];
					arr[2] = res;
					
					res = new BigInteger("1");
					res = res.multiply(arr[2]);
					res = res.multiply(mult);
					res = res.add(arr[1]);
					if(res.compareTo(N)>0){
						break;
					}
					sum = sum.add(res);
				}
				System.out.println(sum.toString());
			}
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
}
