package DP;

public class LongestCommonSubsequence {

	static String s1="ABCD";
	static String s2="ABEFHACD";
    static int LCS[][] = new int[s1.length()][s2.length()];

	public static int getValue(int i,int j){
	 	if(i<0||j<0){
			return 0;
	 	}
	 	else{
	 		return LCS[i][j];
	 	}
	}

	public static void getLongestCommonSubsequence(){
		
		for(int i=0;i<s1.length();i++){
			for(int j=0;j<s2.length();j++){
				if(s1.charAt(i)==s2.charAt(j)){
					LCS[i][j] = 1+getValue(i-1,j-1);
				}
				else{
					LCS[i][j] = Math.max(getValue(i-1,j),getValue(i,j-1));
				}			
			}
		}
		System.out.println(LCS[s1.length()-1][s2.length()-1]);
	}	

	public static void main(String args[]){
		getLongestCommonSubsequence();
	}
}
