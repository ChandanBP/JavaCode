package DP;

public class KnapSack {

	public static void main(String args[]){
		
		int n=3;
		int W = 50;
		int weights[] = {0,10,20,30};
		int values[] = {0,60,100,120};
		
		
		int knapSack[][] = new int[n+1][W+1];
		
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j<= W; j++) {
				if(i==0||j==0){
					knapSack[i][j]=0;
				}
				else{
					if(j-weights[i]>=0){
						knapSack[i][j]= Math.max(values[i]+knapSack[i-1][j-weights[i]], knapSack[i-1][j]);
					}
					else{
						knapSack[i][j]= knapSack[i-1][j];
					}
				}
			}
		}
		System.out.println(knapSack[n][W]);
	}
	
}
