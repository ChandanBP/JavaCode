import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class Milly {

	
	static HashMap<Integer, Integer>gcd = new HashMap<>();
	public static int findGCD(int number1, int number2) { 

		if(gcd.containsKey(number1+number2)){
			return gcd.get(number1+number2);
		}
		
		//base case 
		if(number2 == 0){ return number1; } 
		return findGCD(number2, number1%number2); 
	}
	
	public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running*/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int T = Integer.parseInt(line);
        HashSet<Integer>set = new HashSet<>();
        int g;
        double lcm;
        for (int i = 1; i <=T; i++) {
        	
        	String input[] = br.readLine().split(" ");
            
            
            int N = Integer.parseInt(input[0]);
            set.add(Integer.parseInt(input[1]));
            set.add(Integer.parseInt(input[2]));
            set.add(Integer.parseInt(input[3]));
            
            Integer factors[] = new Integer[set.size()];
            set.toArray(factors);
            
            String numbers[] = br.readLine().split(" ");
            
            int n1,n2;
            n1=Integer.parseInt(numbers[0]);
        	n2=Integer.parseInt(numbers[1]);
        	lcm=n1*n2;
            g=findGCD(n1,n2);
            
            for(int j=2;j<numbers.length;j++){
            	
            	n1=Integer.parseInt(numbers[j]);
            	lcm*=n1;
            	g=findGCD(n1,g);

            	if(!gcd.containsKey(n1+g)){
            		gcd.put(n1+g, g);
            	}
            }
            if(g==1){
            	System.out.println("She can't");
            	continue;
            }
            
            double res=lcm/g;
            boolean flag=false;
            for(int k=0;k<factors.length;k++){
            	if(res%factors[k]==0){
            		flag=true;
            		break;
            	}
            }
            if(flag){
            	System.out.println("She can");
            }
            else{
            	System.out.println("She can't");
            }
        }
    }
}
