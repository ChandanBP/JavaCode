package DP;

import java.util.Arrays;

public class CoinDenominations {

	int n;
	int memo[];
	
	public CoinDenominations(int n){
		this.n = n;
		memo = new int[n];
		Arrays.fill(memo, -1);
	}
	
	public int getCoinWays(int n){
		
		if(n==1)return 1;
		if(n<=0)return 0;
		if(memo[n-1]!=-1)return memo[n-1];
		return getCoinWays(n-1)+getCoinWays(n-5)+getCoinWays(n-10)+getCoinWays(n-25);
		
	}
	
	public static void main(String args[]){
		
		int n = 10;
		CoinDenominations obj = new CoinDenominations(n);
		System.out.println(obj.getCoinWays(n));
	}
	
}
