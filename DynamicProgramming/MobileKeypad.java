package DP;

public class MobileKeypad {
	
	static int keyPad[][] = {{1,2,3},
            				 {4,5,6},
            				 {7,8,9},
            				 {-1,0,-1}
            				 };
	
	static int N = 5;
	
	static int count[][] = new int[10][N+1];
	
	public static int getSum(int i,int j,int n){
		
		if((i==3&&j==0)||(i==3&&j==2)){
			return 0;
		}
		else if(i<0 || i>3 || j>2 || j<0){
			return 0;
		}
		else{
			return count[keyPad[i][j]][n-1];
		}
	}
	
	public static void main(String args[]){
		
		// Intialise count array
		for(int i=0;i<10;i++){
			count[i][1] = 1;
		}
		int sum;
		for(int n=2;n<=N;n++){
			for(int i=0;i<4;i++){
				for(int j=0;j<3;j++){
					sum=0;
					if(keyPad[i][j]!=-1){
						
						// self element
						sum+=getSum(i,j,n);
						
						// left
						sum +=getSum(i, j-1, n);
						
						// right
						sum +=getSum(i, j+1, n);

						// top
						sum +=getSum(i-1, j, n);
						
						// bottom
						sum +=getSum(i+1, j, n);
						
						count[keyPad[i][j]][n] = sum;
						//System.out.print(count[keyPad[i][j]][n]+" ");
					}
				}
				//System.out.println();
			}
		}
		
		sum=0;
		for(int i=0;i<10;i++){
			sum+=count[i][N];
		}
		System.out.println(sum);
	}
	
}
