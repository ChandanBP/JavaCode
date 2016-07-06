package hackerrank;

import java.util.Scanner;

public class BalanceArray {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N+1];
		
		int totalSum=0;
		for(int i=1;i<=N;i++){
			arr[i]=sc.nextInt();
			totalSum+=arr[i];
		}
		
		int leftSum=0,rightSum=0;
		int remSum;
		for(int i=1;i<=N;i++){
			
			remSum=totalSum-arr[i];
			rightSum=remSum-leftSum;
			if(leftSum==rightSum){
				System.out.println(i);
				break;
			}
			leftSum+=arr[i];
		}
	}
}
