// To find maximum cost path in a matrix

package DP;

public class MaximumCostPath {

	static int cost[][]= {
			{2,3,4,1},
			{1,1,3,9},
			{2,2,3,1},
			{2,2,3,1}
			};
			 		
	static int m=cost.length,n=cost.length;

	public static int getValue(int i,int j){
			
		if(i<0||j<0){
			return 0;
		}
		else{
			return cost[i][j];
		}
	}

	public static void getMaximumCostPath(){

		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				cost[i][j]=Math.max(getValue(i,j-1)+cost[i][j], getValue(i-1,j)+cost[i][j]);
			}
		}
			System.out.println(cost[m-1][n-1]);
	}
			
	public static void main(String args[]){
		getMaximumCostPath();
	}
}
