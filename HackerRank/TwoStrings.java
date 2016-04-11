import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoStrings {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
         try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine();
            int T = Integer.parseInt(line);
            String A;
            String B;
             
             int count[];
             boolean found;

             for(int i=1;i<=T;i++){

                 A = br.readLine();
                 B = br.readLine();
               
                 found = false;
                 count = new int[26];
                 
                 for(int j=0;j<A.length();j++){
                     
                         count[A.charAt(j)-97]++;
           
                 }
                 
                 for(int j=0;j<B.length();j++){
                     if(count[B.charAt(j)-97]>0){
                        System.out.println("YES");
                         found = true;
                         break;
                     }
                 }
                 if(found == false){
                     System.out.println("NO");
                 }
             }
         }
         catch(IOException ioException){
             ioException.printStackTrace();
         }
    }
}
