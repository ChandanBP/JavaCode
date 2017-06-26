package com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JumpOut {
	
	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			
			int N = Integer.parseInt(br.readLine());
			int dest = N+1;
			
			String input[] = br.readLine().split(" ");
			for(int i=0;i<input.length;i++){
				int power = Integer.parseInt(input[i]);
				if(power>=(dest-(i+1))){
					System.out.println(i+1);
					break;
				}
			}
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
}
