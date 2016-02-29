// Obtain maximum value for cutting the rods

package DP;

public class RodCutting {
	
	public static void main(String args[]){
		
		int length[] = {0,1,2,3,4,5,6,7,8};
		int price[] = {0,1,5,8,9,10,17,17,20};
		int maxProfit[] = new int[length.length+1];
               
            maxProfit[0] = 0;
		for(int i=1;i<=length.length-1;i++){
			maxProfit[i] = price[i];
			for(int j=0;j<=i;j++){
				if((maxProfit[j]+maxProfit[i-j])>=maxProfit[i]){
					maxProfit[i] = maxProfit[j]+maxProfit[i-j];
				}
			}
		}
		System.out.println(maxProfit[length.length-1]);
	}
}
