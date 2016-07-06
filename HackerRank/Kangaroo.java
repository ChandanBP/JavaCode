package hackerrank;

import java.util.Scanner;

public class Kangaroo {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
        int a1 = in.nextInt();
        int d1 = in.nextInt();
        int a2 = in.nextInt();
        int d2 = in.nextInt();
        
        try{
           if(d1>=d2){
              System.out.println("NO");
              return;
           } 
            
           float n = (float)(a1-a2)/(d2-d1);
           n+=1;
           System.out.println(n);
           if(n<=0){
               System.out.println("NO");   
           }
           else{
               System.out.println("YES");
           }
        }
        catch(ArithmeticException exception){
            System.out.println("NO");
        }
		
	}
}
