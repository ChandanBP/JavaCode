import java.util.Arrays;

public class SumOfTwoNumbers {
     
	public static void main(String args[]){
		
		int a[] = {5,1,4,1,2,0};
		
		Arrays.sort(a);
		int i=0;
		int j = a.length-1;
		while(i<j){
		   if(a[i]+a[j]==6){
		      System.out.println("Found");
		  break;
		     }
		else if(a[i]+a[j]<6){
		    i++;
		}
		else if(a[i]+a[j]>6){
		    j--;
		}
		}

		
	}
}
