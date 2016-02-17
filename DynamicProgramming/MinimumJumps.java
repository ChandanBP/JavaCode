package DP;

public class MinimumJumps {

	public static void main(String args[]){
		
		int a[] = {1,3,5,8,9,2,6,7,6,8,9};
		int n = a.length;
		int jumps[] = new int[n];
		
		jumps[n-1]=0;
		int min ;
		int j;
		for (int i = n-2; i >=0; i--) {
			
			if(a[i]>=n-1-i){
				jumps[i] = 1;
			}
			else{
				j=i+1;
				min = Integer.MAX_VALUE;
				while(j<=n-1 && j<=i+a[i]){
					if(jumps[j]<min){
						min = jumps[j];
					}
					j++;
				}
				
				jumps[i] = min+1;
			}
		}
		System.out.println(jumps[0]);
	}
	
}
