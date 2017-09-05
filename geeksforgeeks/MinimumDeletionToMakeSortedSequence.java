package com.geeksforgeeks;

public class MinimumDeletionToMakeSortedSequence {
	
	public static int numberOfDeletions(int arr[]){
		
		// If array is null or single element, then number of deletions will be 0
		if(arr==null || arr.length<=1)return 0;
		
		
		// Result array to store longest increasing subsequence
		int lis[]=new int[arr.length];
		int max=1;
		
		for(int i=0;i<arr.length;i++){
			lis[i]=1;
		}
		for(int i=1;i<arr.length;i++){
			for(int j=i-1;j>=0;j--){
				if(arr[i]>arr[j] && lis[i]<lis[j]+1){
					lis[i]=lis[j]+1;
					max=Math.max(max, lis[i]);
				}
			}
		}
		
		return arr.length-max;
	}
	
	public static void main(String[] args) {
		int arr[]={30, 40, 2, 5, 1, 7, 45, 50, 8};
		System.out.println(numberOfDeletions(arr));
	}
}
