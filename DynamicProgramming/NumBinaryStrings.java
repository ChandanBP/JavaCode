package DP;

public class NumBinaryStrings {

	public static void main(String args[]){
		int N =5;
		
		int zero[] = new int[N+1];
		int one[] = new int[N+1];
		
		zero[1] = 1;
		one[1] = 1;
		
		for (int i = 2; i <=N; i++) {
			zero[i] = zero[i-1]+one[i-1];
			one[i] = zero[i-1];
		}
		System.out.println(zero[N]+one[N]);
	}
}
