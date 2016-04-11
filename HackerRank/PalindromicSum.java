import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class PalindromicSum {
	
	public static boolean isPalindrome(String s){
	
	int i=0;
	int j=s.length()-1;
	
	while(i<j){
		if(s.charAt(i)!=s.charAt(j)){
			return false;
		}
		i++;
		j--;
	}
	return true;
}

public static void main(String[] args) {
    
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	try{
		
		int numCases = Integer.parseInt(br.readLine());
		long N,d;
		
		
		for(int t=1;t<=numCases;t++){
			
			String input[] = br.readLine().split(" ");
			N = Long.parseLong(input[0]);
			d = Long.parseLong(input[1]);
			
			HashSet<Long>set = new HashSet<Long>();
			long limit = (long)Math.sqrt(N);
			long number;
			long sum=0;
			for(long i=1;i<=limit;i++){
				number=i*i;
				for(long j=i+d;j<=limit;j=j+d){
					number+=(j*j);
					if(number>N){
						break;
					}
					else if(isPalindrome(String.valueOf(number)) && !set.contains(number)){
						set.add(number);
						sum+=number;
					}
				}
			}
			System.out.println(sum);
		}
		
	}
	catch(IOException ioException){
		ioException.printStackTrace();
	}

}}
