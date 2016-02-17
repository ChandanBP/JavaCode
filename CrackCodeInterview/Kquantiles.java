import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Kquantiles {

	public static void main(String[] args) {
		try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line;
            
            line = br.readLine();
            int Q = Integer.parseInt(line);
            
            line = br.readLine();
            int m = Integer.parseInt(line);
            
            
            String input[];
            int v,c=0;
            ArrayList<Integer> list = new ArrayList<Integer>();
            ArrayList<Integer> startIndex = new ArrayList<Integer>();
            ArrayList<Integer> endIndex = new ArrayList<Integer>();
            int index = 0;
            for(int i=1;i<=m;i++){
                line = br.readLine();
                input = line.split(" ");
                v = Integer.parseInt(input[0]);
                c = Integer.parseInt(input[1]);
                
                    list.add(new Integer(v));
                    startIndex.add(index);
                    index+=c;
                    endIndex.add(index);
            }
            Collections.sort(list);
            
            int k = Q-1;
            int I;
            int n = index+1;
            for(int j=1;j<=k;j++){
                    I = (int)Math.ceil(n*j/Q);
                    I=I-1;
                    for (int j2 = 0; j2 < startIndex.size(); j2++) {
						if(I>=startIndex.get(j2) && I<=endIndex.get(j2)){
							System.out.println(list.get(j2));
						}
					}
            }
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }

	}
}
