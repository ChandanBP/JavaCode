import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class ReverseWords {

	public static void main(String args[]){
	    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    try{
	    	
	    	String line = br.readLine();
	    	if(line==null||line.length()==0){
	    		System.out.println("");
	    		return;
	    	}
	    	String input[] = line.split(" ");
	    	ArrayList<String>list = new ArrayList<String>();
	    	for(int i=0;i<input.length;i++){
	    		list.add(input[i]);
	    	}
	    	Collections.reverse(list);
	    	StringBuilder sb = new StringBuilder();
	    	for(int i=0;i<list.size();i++){
	    		sb.append(list.get(i));
	    		if(i!=list.size()-1){
	    			sb.append(" ");
	    		}
	    	}
	    	System.out.println(sb.toString());
	    }
	    catch(IOException ioException){
	    	ioException.printStackTrace();
	    }
	}
}
