package geeksforgeeks;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


// Substring with first and last same characters
public class StringWithFirstLast {
	
	public static void main(String[] args) {
		
		String s = "aba";
		
		HashMap<Character, Integer>map = new HashMap<Character, Integer>();
		
		for(char c:s.toCharArray()){
			int count=0;
			if(map.containsKey(c)){
				count = map.get(c);
			}
			else{
				count=0;
			}
			++count;
			map.put(c, count);
		}
		
		Iterator<Map.Entry<Character, Integer>>ite = map.entrySet().iterator();
		long count=0;
		while(ite.hasNext()){
			Map.Entry<Character, Integer>entry = ite.next();
			count+=(entry.getValue()*(entry.getValue()+1))/2;
		}
		
		System.out.println(count);
	}
}
