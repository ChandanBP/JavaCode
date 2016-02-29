package DP;

public class ShortestCommonSuperSequence {

	static String s1="AGGTAB";
	static String s2="GXTXAYB";
	static int LCS[][] = new int[s1.length()][s2.length()];
	static StringBuilder sb = new StringBuilder();
	
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
		int len = LCS[s1.length()-1][s2.length()-1];
		System.out.println(len+(s1.length()-len)+((s2.length()-len)));
		
//		char lcs[] = new char[LCS[s1.length()-1][s2.length()-1]];
//		int index = LCS[s1.length()-1][s2.length()-1];
//		int i,j;
//		i = s1.length();
//		j = s2.length();
//		while(i>0&&j>0){
//			
//			if(s1.charAt(i-1)==s2.charAt(j-1)){
//				lcs[index-1]=s1.charAt(i-1);
//				i--;
//				j--;
//				index--;
//			}
//			else if (LCS[i-1][j] > LCS[i][j-1])
//		         i--;
//		      else
//		         j--;
//		}
//		for (int j2 = 0; j2 < lcs.length; j2++) {
//			System.out.print(lcs[j2]);
//		}
	}
	
	public static void main(String args[]){
		
		ShortestCommonSuperSequence obj = new ShortestCommonSuperSequence();
		obj.getLongestCommonSubsequence();
	}
	
}
