package DP;

public class LongestPathInMatrix {
   
	static int m=3,n=3;
	static int a[][] = {{1, 2, 3},
			            {6, 5, 4},
			            {7, 8, 9}};
	
	static boolean dp[][] = new boolean[m][n];
	
	public static int findLongest(int i,int j){
		
		int len=0;
		int diff;
		
		if((i-1)>=0&&!dp[i-1][j]){
			diff = a[i][j]-a[i-1][j];
			if(diff==1||diff==-1){
				len++;
				dp[i-1][j]=true;
				len+=findLongest(i-1,j);
			}
		}
		if((i+1)<m&&!dp[i+1][j]){
			diff = a[i+1][j]-a[i][j];
			if(diff==1||diff==-1){
				len++;
				dp[i+1][j]=true;
				len+=findLongest(i+1,j);
			}
		}
        if((j-1)>=0&&!dp[i][j-1]){
        	diff = a[i][j-1]-a[i][j];
			if(diff==1||diff==-1){
				len++;
				dp[i][j-1]=true;
				len+=findLongest(i,j-1);
			}
		}
		if((j+1)<n&&!dp[i][j+1]){
			diff = a[i][j+1]-a[i][j];
			if(diff==1||diff==-1){
				len++;
				dp[i][j+1]=true;
				len+=findLongest(i,j+1);
			}
		}
		return len;
	}
	
	public static void main(String args[]){
		
		int max = Integer.MIN_VALUE;
		int val;
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a.length;j++){
				
				if(!dp[i][j]){
					dp[i][j]= true;
					val = findLongest(i, j);
					if(val>max){
						max = val;
					}
				}
			}
		}
		System.out.println(max+1);
	}
}
