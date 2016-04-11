import java.io.*;

public class UtopianTree {

public static void main(String[] args) {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            int numTestCases = Integer.parseInt(br.readLine());
            int numCycles;
            for(int t=1;t<=numTestCases;t++){
                
                numCycles = Integer.parseInt(br.readLine());
                if(numCycles==0){
                    System.out.println(1);
                }
                else{
                    int spring = 1;
                    int height=1;
                    for(int c=1;c<=numCycles;c++){
                        if(spring==1){
                            height = height*2;
                        }
                        else{
                            height+=1;
                        }
                        spring = 1-spring;
                    }
                    System.out.println(height);
                }
            }
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
    }
}
