// Longest even length substring such that dp of first half is equal to second half

package DP;


public class LongestEvenSubString {

	public static void main(String args[]){
		
		String s = "153803";
		int dp[][] = new int[s.length()][s.length()];
		
		
		for (int i = 0; i < dp.length; i++) {
			dp[i][i] = Integer.parseInt(s.charAt(i)+"");
		}
		
		int n = s.length();
		int j,k;
		int maxLen = Integer.MIN_VALUE;
		for (int len = 2; len <= s.length(); len++) {
			
			for (int i = 0; i<=n-len; i++) {
				
				j = i+len-1;
				k = len/2;
				
				dp[i][j] = dp[i][j-k] + dp[j-k+1][j];

				if (len%2 == 0 && dp[i][j-k] == dp[(j-k+1)][j]
	                           && len > maxLen)
	            	maxLen = len;
			}
		}
		
		System.out.println(maxLen);
	}
	
}
