import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RepUnit {

	public static void main(String args[]){
		
		try{
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String line = br.readLine();
			
			int numTestCases = Integer.parseInt(line);
			double digit;
			int incr;
			long n;
			boolean cont = true;
			for(int i=1;i<=numTestCases;i++){

				n = Integer.parseInt(br.readLine());
				digit=0;
				incr=0;
				long temp = n;
				while(n>0){
					n = n/10;
					digit+=Math.pow(10, incr);
					incr++;
				}
				n = temp;
				incr--;
				cont = true;
				//System.out.println(digit);
				while(cont){
					
					if(digit%n==0){
						System.out.println(incr+1);
						cont = false;
					}
					else{
						incr++;
					}
					digit+=Math.pow(10, incr);
				}
				
			}
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
		
	}
	
}
