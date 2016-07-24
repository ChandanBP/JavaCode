import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Encryption {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        
        LinkedHashMap<Character,Integer>map=new LinkedHashMap<>();
        int count;
        for(int i=0;i<line.length();i++){
        	if(map.containsKey(line.charAt(i))){
        		count=map.get(line.charAt(i));
        		count++;
        		map.put(line.charAt(i),count);
        	}
        	else{
        		map.put(line.charAt(i),1);
        	}
        }
        
        Iterator ite = map.entrySet().iterator();
        while(ite.hasNext()){
        	Map.Entry<Character,Integer>entry=(Map.Entry<Character,Integer>)ite.next();
        	System.out.print(entry.getKey()+""+entry.getValue());
        }
	}
}
