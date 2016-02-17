import java.util.LinkedList;
import java.util.Stack;

public class SumOfTwoArrays {

	public static void getSum(int a1[],int a2[]){
		
		int a[] = new int[a1.length+1];
		int i = a.length-1;
		int j = a1.length-1;
		int k = a2.length-1;
		int sum,carry=0;
		
		while(j>=0){
			
			if(k>=0){
				sum = a1[j]+a2[k]+carry;
			}
			else{
				sum = a1[j]+carry;
			}
			carry = sum/10;
			sum = sum%10;
			
			a[i] = sum;
			i--;
			j--;
			k--;
		}
		
		a[i]=carry;
		for (int l = 0; l < a.length; l++) {
			System.out.print(a[l]);
		}
	}
	
	public static void main(String args[]){
		
		int a1[] = {9,9,2};
		int a2[] = {0,1,3};
		int res[];
		
		if(a1.length>a2.length){
			getSum(a1, a2);
		}
		else if(a1.length<a2.length){
			getSum(a2,a1);
		}
		else{
			getSum(a1,a2);
		}
		
		
		
	}
}
