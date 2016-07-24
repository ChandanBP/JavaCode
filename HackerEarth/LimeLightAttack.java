import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LimeLightAttack {

	static long sn;
	
	public static long getNumberOfTerms(long a,long d,long tn){
		long val = tn;
		val-=a;
		val/=d;
		val+=1;
		return val;
	}
	
	
	public static void computeSum(long a,long d,long n){
		
		long sum=0;
		
		sum= ( (2*a) + ((n-1)*d) );
		sum=sum*n;
		sum/=2;
		sum%=1000000009;
		sn = (sn%1000000009+sum)%1000000009;
	}
	
	public static void main(String[] args) {
		
		try{
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int numTestCases = Integer.parseInt(br.readLine());
			long N;
			long d;
			long a;
			long rem;
			long tn;
			for(int t=1;t<=numTestCases;t++){
				
				// Read N
				N = Integer.parseInt(br.readLine());
				d = N-1;
				a = N*N;
				tn=a;
				sn = 0;
				a=N*N-(3*d);
				
				while(d!=0){
				
					rem = getNumberOfTerms(a,d,tn);
					
					if(rem<4){
						computeSum(a, d, rem);
						break;
					}
					else{
						computeSum(a, d, 4);
					}
					tn=a-d;
					d=d/2;
					a = tn-3*d;
					if(a<0){
						sn+=1;
						break;
					}
				}
				System.out.println(sn);
			}
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
	
}
