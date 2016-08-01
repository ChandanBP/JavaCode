import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
public class Rhezo {


    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running*/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int Q =  Integer.parseInt(br.readLine());
        BigInteger big,seven,two;
        seven = new BigInteger("7");
        two = new BigInteger("2");
       
        int si,ei;
        for (int i = 1; i <=Q; i++) {
            String input[] = br.readLine().split(" ");
            si=Integer.parseInt(input[0]);
            ei=Integer.parseInt(input[1]);
            
            if((ei-si)==0){
            	if(Integer.parseInt(N.substring(si-1, ei))%7==0){
            		System.out.println("YES");
            	}
            }
            else if(si>ei || si<1 || ei>N.length() || (ei-si)>N.length()){
            	System.out.println("NO");
            }
            else{
            	
            	String s = N.substring(si-1,ei-1);
            	big = new BigInteger(s);
            	
            	BigInteger last = new BigInteger(N.substring(ei-1, ei));
            	last = last.multiply(two);
            	big = big.subtract(last);
            	BigInteger rem =  big.remainder(seven);
            	
            	if(rem.intValue()%7==0){
            		System.out.println("YES");
            	}
            	else{
            		System.out.println("NO");
            	}
            }
        }
    }

}
