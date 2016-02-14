package DP;

import java.util.Arrays;

public class CountSteps {
  
	public static int countSteps(int i,int steps[]){
		
		if(i<0)return 0;
		if(i==0)return 1;
		if(steps[i-1]!=-1)return steps[i-1];
		steps[i-1] = countSteps(i-1, steps)+countSteps(i-2, steps)+countSteps(i-3, steps);
		return steps[i-1];
	}
	
	public static void main(String args[]){
		
		int n = 4;
		int[] steps = new int[n];
		Arrays.fill(steps, -1);
		System.out.println(countSteps(n, steps));
	
	}
	
}
