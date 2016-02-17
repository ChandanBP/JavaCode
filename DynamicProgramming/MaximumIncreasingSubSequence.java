package DP;

public class MaximumIncreasingSubSequence {

	public static void main(String args[]){
		
		int a[] = {0,1, 101, 2, 3, 100, 4, 5};
		int n = a.length;
		int LMS[] = new int[n];
		
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < LMS.length; i++) {
			
			for (int j = 0; j < i; j++) {
				
				if(a[i]>a[j]&&(LMS[j]+a[i])>LMS[i]){
					LMS[i] = LMS[j]+a[i];
					max = (LMS[i]>max)?LMS[i]:max;
				}
			}
		}
		
		System.out.println(max);
	}
	
}
