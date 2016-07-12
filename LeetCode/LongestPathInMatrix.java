package leetcode;

public class LongestPathInMatrix {

	int m;
    int n;
    int longest[][];
    
    public int findLongest(int i,int j,int a[][]){
        if(longest[i][j]!=0)return longest[i][j];
    	if( (i-1)>=0 && (a[i-1][j]>a[i][j]) ){
    		longest[i][j] = Math.max(longest[i][j], findLongest(i-1,j,a));
    	}
    	if((i+1)<m && (a[i+1][j]>a[i][j]) ){
    		longest[i][j] = Math.max(longest[i][j], findLongest(i+1,j,a));
    	}
    	if(j-1>=0 && (a[i][j-1]>a[i][j]) ){
    		longest[i][j] = Math.max(longest[i][j], findLongest(i,j-1,a));
    	}
    	if((j+1)<n && (a[i][j+1]>a[i][j]) ){
    		longest[i][j] = Math.max(longest[i][j], findLongest(i,j+1,a));
    	}
    	return ++longest[i][j];
    }
    
    public int longestIncreasingPath(int[][] matrix) {
        
        m = matrix.length;
        if(m==0){
            return 0;
        }
        n = matrix[0].length;
        int max = Integer.MIN_VALUE;
        int val;
        longest = new int[m][n];
        for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
					val = findLongest(i, j,matrix);
					if(val>max){
						max = val;}
			}
		}
        return max;
    }

}
