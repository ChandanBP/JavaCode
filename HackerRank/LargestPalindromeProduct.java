package Euler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargestPalindromeProduct {

	public static boolean isPalindrome(String num){
		
		StringBuilder reverse = new StringBuilder();
		reverse.append(num);
		if(num.equals(reverse.reverse().toString())){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
		
			long numTestCases = Long.parseLong(br.readLine());
            long prod,N;
            long palindrome;
			
            for(int t=1;t<=numTestCases;t++){
				
				N = Long.parseLong(br.readLine());
				palindrome = 0;
				for(int i=100;i<=999;i++){
					for(int j=100;j<=999;j++){
						prod = i*j;
						if(prod>N||j>i){
							break;
						}
						if(isPalindrome(String.valueOf(prod))){
							palindrome = Math.max(palindrome, prod);
						}
					}
				}
				System.out.println(palindrome);
			}
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
}
