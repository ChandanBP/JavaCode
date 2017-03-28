package geeksforgeeks;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

public class DiffAlternateChars {
	
	static class charCount implements Comparable<charCount>{
		char c;
		int count;
		
		@Override
		public int compareTo(charCount o) {
			return o.count-this.count;
		}
	}
	
	public static void main(String[] args) {
		
		String s="aa";
		HashMap<Character, Integer>map = new HashMap<Character, Integer>();
		
		// store frequency in a map
		for(int i=0;i<s.length();i++){
			int count;
			if(map.containsKey(s.charAt(i))){
				count=map.get(s.charAt(i));
			}
			else{
				count=0;
			}
			count++;
			map.put(s.charAt(i), count);
		}
		
		
		PriorityQueue<charCount>queue = new PriorityQueue<DiffAlternateChars.charCount>();
		Iterator<Map.Entry<Character, Integer>>set = map.entrySet().iterator();
		while(set.hasNext()){
			
			Map.Entry<Character, Integer>entry = set.next();
			charCount c = new charCount();
			c.c = entry.getKey();
			c.count = entry.getValue();
			queue.add(c);
		}
		
		StringBuilder sb = new StringBuilder();
		charCount prev = new charCount();
		prev.c='#';
		prev.count=-1;
		
		while(!queue.isEmpty()){
			
			charCount c = queue.poll();
			sb.append(c.c);
			
			if(prev.count>0){
				queue.add(prev);
			}
			
			c.count--;
			prev=c;
		}
		
		String res = sb.toString();
		if(res.length()!=s.length()){
			System.out.println("Not possible");
			return;
		}
		System.out.println(res);
	}
}
