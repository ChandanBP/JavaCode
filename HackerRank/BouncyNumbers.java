import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class BouncyNumbers {

	
	public static boolean isBouncing(String num){

		boolean first = true;
		boolean greaterOrLesser = true;
		int diff;
		int len =num.length();

		if(len<=2){
			return false;
		}
		else if(len>2){
			
			for(int i=0;i<num.length()-1;i++){
				diff = Character.getNumericValue(num.charAt(i+1))-Character.getNumericValue(num.charAt(i));
				if( first && diff!=0){
					first=false;
					greaterOrLesser = (diff>0)?true:false;
				}
				else if(!first && diff!=0){
					if(greaterOrLesser==true && diff<0){
						return true;
					}
					else if(greaterOrLesser==false && diff>0){
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
//	public static long getBouncyNumbers(long n,long m){
//		
//		int lastDigit;
//		long denom=100,numerat=0;
//        long base=10;
//        long i;
//		float percentage = (n*100.0f)/m;
//		float resPercentage = (numerat*100.0f)/denom;
//		String s;
//		
//		while(resPercentage<=percentage){
//		
//			for(i=base;i<=i+10;i++){
//				
//				s = String.valueOf(i);
//				if(isBouncing(s)){
//					numerat+=10;
//				}
//				else{
//					
//					lastDigit = Character.getNumericValue(s.charAt(s.length()-1));
//					if(lastDigit==0){
//						numerat+=10;
//					}
//					else{
//						numerat+=lastDigit;
//					}
//				}
//				denom+=10;
//				resPercentage = (numerat*100.0f)/denom;
//				if(resPercentage>percentage){
//					return denom;
//				}
//			}
//			
//			base+=10;
//		}
//		return denom;
//	}

	public static long getBouncyNumbers(long n,long m){
		
		long denom=99,numerat=0;
		
		while( (numerat*m) < (n*denom)){
		
			denom++;
			if(isBouncing(String.valueOf(denom))){
				numerat++;
			}
		}
		return denom;
	}
	
	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
		
			int numTestCases = Integer.parseInt(br.readLine());
			long n,m;
			
			for(int i=1;i<=numTestCases;i++){
				String input[] = br.readLine().split(" ");
				n = Integer.parseInt(input[0]);
				m = Integer.parseInt(input[1]);
				long start = System.currentTimeMillis();
				System.out.print(getBouncyNumbers(n, m));
				long end = System.currentTimeMillis();
				System.out.println("in "+(end-start)/1000);
			}
			
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
}
