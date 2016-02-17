
public class NumOfFibonnaci {

	public static void main(String args[]){
		
		int count =2;
		int n = 4;
		int prev = 0,next =1,cur;
		cur =2;
		
		while(cur<n){
			cur = prev+next;
			prev = next;
			next = cur;
			count++;
		}
		System.out.println(count-1);
	}
}
