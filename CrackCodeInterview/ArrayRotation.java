
public class ArrayRotation {

	public static void print(int arr[]){
	    for(int i=0;i<7;i++){
        System.out.print(arr[i]+" ");
      }
	    System.out.println();
	}
	
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7};
	    int n=7;
	    int d = 2;
	    int index;
	    int i=0,swap,temp;
	    boolean done = false;
	    
	    swap = arr[0];
	    while(!done){
	        
	        if(i<d){
	        	index = (n-d)+i;
	            temp = arr[index];
	            arr[index] = swap;
	            print(arr);
	            i = index;
	            swap = temp;
	            
	        }
	        if(i>=d){
	            temp = arr[i-d];
	            arr[i-d]=swap;
	            print(arr);
	            i=i-d;
	            swap = temp;
	            
	        }
	        
	        if(i==0){
	            done = true;
	        }
	    }
	    

	}
}
