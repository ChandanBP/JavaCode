package geeksforgeeks;


// To split the array into two parts such that sum are equal without re ordering elements
public class SplitArray {

	public static void main(String[] args) {
		
		int arr[] = {1 , 2 ,3 , 4};
		
		int totalSum=0;
		for(int i:arr){
			totalSum+=i;
		}
		
		int sum=0;
		for(int i:arr){
			sum+=i;
			if(sum==(totalSum-sum)){
				System.out.println("Possible");
				return;
			}
		}
		System.out.println("Not possible");
	}
}
