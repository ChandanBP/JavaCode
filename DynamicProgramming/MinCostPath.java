package DP;

public class MinCostPath {

	static int a[][] = {{1,2,3},
			            {4,8,2},
			            {1,5,3}
			            };
	
	public static int getMinCostPath(int i,int j,int m,int n,int pathLen){
		
		int min=0,i1,j1;
		
		if(i==m && j==n){
			return pathLen;
		}
		
		i1=i;
		j1=j;
		if((i+1)<=m){
			min = a[i+1][j];
			i1 = i+1;
			j1 = j;
		}
		if((j+1)<=n&&a[i][j+1]<min){
			min = a[i][j+1];
			i1 = i;
			j1 = j+1;
		}
		if(((j+1)<=n)&&((i+1)<=m)&&a[i+1][j+1]<min){
			min = a[i+1][j+1];
			i1 = i+1;
			j1 = j+1;
		}
		pathLen+=min;
		pathLen=getMinCostPath(i1,j1,m,n,pathLen);
		
		return pathLen;
	}
	
	public static void main(String args[]){
		
		System.out.println(getMinCostPath(0,0,2,2,a[0][0]));
	}
}
