import java.util.*;

public class ArrayInWaveForm {

	public static void main(String args[]){
		
		int a[] = {3,3,3,3,4,4,4,4};
		
		Arrays.sort(a);
		
		int i = a.length-1;
		int j = 0;
		int swap = 1;
		
		while(j<=i){
		
			if(swap==1){
				System.out.print(a[i]+" ");
				i--;
			}
			else{
				System.out.print(a[j]+" ");
				j++;
			}
			swap = 1-swap;
		}
	}
}
