package DP;

public class LongestPalindromSequence {
    
	public static void main(String args[]){
		
		
		String s = "CHANDAN";
		int n = s.length();
		
		int LPS[][] = new int[s.length()][s.length()];
		
		for (int i = 1; i < LPS.length; i++) {
			LPS[i][i]=1;
		}
		
		int j;
		for (int cl = 2; cl <= LPS.length; cl++) {
			
			for (int i = 0; i <n-cl+1; i++) {
				
				j = cl+i-1;
				if(s.charAt(i)==s.charAt(j) && cl==2){
					LPS[i][j] = 2;
				}
				else if(s.charAt(i)==s.charAt(j)){
					LPS[i][j] = 2+LPS[i+1][j-1];
				}
				else if(s.charAt(i)!=s.charAt(j)){
					LPS[i][j] = Math.max(LPS[i][j-1], LPS[i+1][j]);
				}
			}
		}
		
		System.out.println(LPS[0][n-1]+" ");
		System.out.println(Integer.MAX_VALUE);
	}
}

