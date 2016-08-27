package augustcircuits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DualIssues {
	static int[] primes=new int[1001];
	static void generatePrimes(){
		for (int i=2; i*i<=1000; i++){
	        if (primes[i] == 0){
	            for (int j=i*2; j<=1000; j += i){
	            	primes[j] = 1;
	            }
	        }
	    }
	}
	
	public static void main(String[] args) {
		
		generatePrimes();
		try{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			int T=Integer.parseInt(br.readLine());
			for(int t=1;t<=T;t++){

				int n=Integer.parseInt(br.readLine());
				String line=br.readLine();
				int max=-1;
				int i=0;
				while(i<line.length()){
					StringBuilder sb=new StringBuilder();
					while(i<line.length() && line.charAt(i)!=' '){
						sb.append(line.charAt(i));
						i++;
					}
					int num=Integer.valueOf(sb.toString());
					if(num!=1 && primes[num]==0 && num>max){
						max=num;
					}
					i++;
				}
				if(max==-1){
					System.out.println(max);
				}
				else{
					System.out.println(max*max);
				}
			}
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
}