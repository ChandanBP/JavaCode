import java.util.Collections;
import java.util.PriorityQueue;

public class Istr {

	int count(String s, int k){

		int v;
		int c[] = new int[26];
		int value=0;
		PriorityQueue<Integer>queue = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for(int i=0;i<s.length();i++){
			c[s.charAt(i)-97]++;
		}
		
		for (int i = 0; i < c.length; i++) {
			queue.add(c[i]);
		}
		
		for(int i=1;i<=k;i++){
			v = queue.poll();
			v--;
			queue.add(v);
		}
		
		while(!queue.isEmpty()){
			v = queue.poll();
			v = v*v;
			value+=v;
		}
		return value;
	}
	
	public static void main(String[] args) {
		
		Istr i = new Istr();
		System.out.println(i.count("aba", 1));
		System.out.println(i.count("abacaba", 0));
		System.out.println(i.count("abacaba", 1));
		System.out.println(i.count("abacaba", 3));
		System.out.println(i.count("abc", 3));
		System.out.println(i.count("wersrsresesrsesrawsdsw", 11));
		
		System.out.println(1%3);
	}
}
