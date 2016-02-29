package DP;

public class LongestPalindromSubstring {

public static void main(String args[]){
		
		
		String s = "forgeeksskeegfor";
		String palindrome="";
		int n = s.length();
		
		int LPS[][] = new int[s.length()][s.length()];
		
		for (int i = 1; i < LPS.length; i++) {
			LPS[i][i]=1;
		}
		
		int j;
		int max = Integer.MIN_VALUE;
		for (int cl = 2; cl <= LPS.length; cl++) {
			
			for (int i = 0; i <n-cl+1; i++) {
				
				j = cl+i-1;
				if(s.charAt(i)==s.charAt(j) && cl==2){
					LPS[i][j] = 1;
				}
				else if(s.charAt(i)==s.charAt(j)&&LPS[i+1][j-1]==1){
					LPS[i][j]=1;
					if(max<cl){
						max=cl;
						palindrome = s.substring(i, j+1);
					}
				}
			}
		}
		
		System.out.println(palindrome+" "+max);
	}
}
