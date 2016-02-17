
public class LongestOneStreak {

	public static void main(String args[]){
		
		int a[] = {1,0,0,0,1,0,1,1,1,0,1,0,1,1};
		//int a[] = {1,1,0,0,1,1,1,0,1,1};
		int n = a.length;
		
		int i,k;
		
		i = n-1;
		k = 1;
		int length=0;
		int maxLength = Integer.MIN_VALUE;
		int si=n-1;
		int c=k;
		
		while(i>=0){
			
			if(a[i]==1){
				length++;
			}
			else if(c>0&&c<k){
				length++;
				c--;
				
			} // Number read is 0
			else if(c==k){
					si=i;
					c--;
				}
			else{
					
					maxLength = Math.max(maxLength, length);
					c = k;
					length = 0; 
					int tmp = i;
	    			i = si;
	    			si = tmp;
			}
			i--;
		}
			
    	System.out.println(Math.max(maxLength, length));
	}
	
}
