package Euler;

import java.io.*;
import java.util.*;

public class NameScores {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
		
			int N=Integer.parseInt(br.readLine());
            String names[]=new String[N];
			for(int t=0;t<N;t++){
				names[t]=br.readLine();
			}
			Arrays.sort(names);
            
			int q=Integer.parseInt(br.readLine());
            for(int t=1;t<=q;t++){
            	String name=br.readLine(); 
            	for(int i=0;i<names.length;i++){
                    if(names[i].equals(name)){
                        int val=0;
                        int k;
                        for(k=0;k<name.length();k++){
                            val+=name.charAt(k)-65+1;
                        }
                        System.out.println(val*(i+1));
                        break;
                    }
                }
            }
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
	
}
