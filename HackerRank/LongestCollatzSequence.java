package Euler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestCollatzSequence {

static double dp[];
	
	public static double findLongest(int num){
		
		if(num==1)return 1;
		
		// If within range
		if(num>=1&&num<dp.length){

			// If it is already computed
			if(dp[num]!=0){
				return dp[num];
			}
			else if(num%2==0){  // else compute
				dp[num]=1+findLongest(num/2);
				return dp[num];
			}
			else{
				dp[num]=1+findLongest(3*num+1);
				return dp[num];
			}
		}
		else if(num%2==0){
			return 1+findLongest(num/2);
		}
		else{
			return 1+findLongest(3*num+1);
		}
	}
    
    public static void main(String[] args) {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
		
			int numTestCases=Integer.parseInt(br.readLine());
			for(int t=1;t<=numTestCases;t++){
				
				int N = Integer.parseInt(br.readLine());
				dp = new double[N+1];
				double max = Integer.MIN_VALUE;
				int maxI=1;
				for(int i=1;i<=N;i++){
					if(dp[i]==0){
						dp[i] = findLongest(i);
					}
					if(max<=dp[i]){
						max=dp[i];
						maxI=i;
					}
				}
				System.out.println(maxI);
			}
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
    }
}
