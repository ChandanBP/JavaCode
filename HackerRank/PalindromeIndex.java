import java.io.*;
public class PalindromeIndex {

    public static void main(String[] args) {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        try{
        int numTestCases = Integer.parseInt(br.readLine());
        String input;

        for(int t=1;t<=numTestCases;t++){
           
           input = br.readLine();
           if(input==null||input.length()==1){
               System.out.println(-1);
           }
           else{
               
              int i=0;
              int j=input.length()-1;
              while(i<j){
            	  if(input.charAt(i)!=input.charAt(j)){
            		  break;
            	  }
            	  i++;
            	  j--;
              }
              
              if(i>=j){
            	  System.out.println("-1");
              }
              int i1=i;
              int j1=j;
            
              i++;
              boolean flag=true;
              while(i<j){
            	  if(input.charAt(i)==input.charAt(j)){
            		  i++;
                	  j--;
            	  }
            	  else{
            		  flag=false;
            		  break;
            	  }
              }
              if(flag==true){
            	  System.out.println(i1);
              }
              else{
            	  System.out.println(j1);
              }
           }
        }
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
    }
}