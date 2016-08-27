package augustcircuits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class GameWithXOR {

	static int[] max;
	static Trie root;
	static HashMap<Integer, String> bMap;
	static HashMap<Integer, Trie> indexRef;
	static HashMap<Integer, LinkedList<Integer>>length;

	static class Trie {
		char c;
		int num;
		List<Integer> list;
		Trie p;
		Trie ref[];
	}

	static class Node implements Comparable<Node>{
		int length;
		LinkedList<Integer>list;
		@Override
		public int compareTo(Node o) {
			return o.length-this.length;
		}
		
	}
	
	static void put(int num, String bits, int index) {

		Trie curr;
		curr = root;

		for (int i = 0; i < bits.length(); i++) {

			char bit = bits.charAt(i);
			int dig = (bit == '0') ? 0 : 1;

			if (curr.ref == null) {
				curr.ref = new Trie[2];
			}
			if (curr.ref[dig] == null) {
				curr.ref[dig] = new Trie();
			}
			
			curr.ref[dig].p = curr;
			curr = curr.ref[dig];
			curr.c = bit;
		}
		curr.num = num;
		indexRef.put(num, curr);

		if (curr.list == null) {
			curr.list = new LinkedList<>();
		}
		curr.list.add(index);
	}

	static void delete(Trie curr) {

		if (curr == null)
			return;
		if (curr.list == null)
			return;

		if (curr.list.size() > 0) {
			
			curr.list.remove(0);
			if (curr.list.size() == 0) {

				Trie p = curr.p;
				int dig = (curr.c == '0') ? 0 : 1;
				p.ref[dig] = null;

				while (p.ref[0] == null && p.ref[1] == null) {
    
					curr = p;
					p = curr.p;
					if(p==null)break;
					dig = (curr.c == '0') ? 0 : 1;
					p.ref[dig] = null;
				}
			}
		}
	}

	static String getBinary(int num) {

		
		String binary = Integer.toBinaryString(num);
		char zeroes[] = new char[32 - binary.length()];
		Arrays.fill(zeroes, '0');
		return new StringBuilder().append(String.valueOf(zeroes)).append(binary).toString();
	}

	static int get(int num, boolean flag) {

		String binary = bMap.get(num);
		if (binary == null) {
			binary = getBinary(num);
			bMap.put(num, binary);
		}
		Trie curr = root;
        int index;
		
		for (int i = 0; i < binary.length(); i++) {
			char bit = binary.charAt(i);
			int dig = (bit == '0') ? 0 : 1;

			if (dig == 1 && curr.ref[0] != null) {
				curr = curr.ref[0];
			} else if (dig == 0 && curr.ref[1] != null) {
				curr = curr.ref[1];
			} else if (curr.ref[0] != null) {
				curr = curr.ref[0];
			} else {
				curr = curr.ref[1];
			}
		}

		// to get xor pair
        index=curr.list.get(0);
		// only call delete when finding optimal solution
		if (!flag) {
			delete(curr);
		}
		return index;
	}

	static void xorPair(int arr[]) {
		
		Iterator ite=length.entrySet().iterator();
		
		PriorityQueue<Node>queue=new PriorityQueue<>();
		while(ite.hasNext()){
			Map.Entry<Integer, LinkedList<Integer>>entry=(Map.Entry<Integer, LinkedList<Integer>>)ite.next();
				Node node=new Node();
				node.length=entry.getKey();
				node.list=entry.getValue();
				queue.add(node);
		}
		
	}

	public static void updateTrie(int arr[]) {

		Trie ref1 = indexRef.get(arr[max[0]]);
		Trie ref2 = indexRef.get(arr[max[1]]);

		delete(ref1);
		delete(ref2);
	}

	public static void findWinner(int arr[]) {

		int xorA = arr[max[0]];
		int xorB = arr[max[1]];

		updateTrie(arr);
		int count=2;

		boolean flag = true;
		int index;
		while (count != arr.length) {

			if (flag) {
				index = get(xorA, false);
				xorA ^= arr[index];
			} else {
				index = get(xorB, false);
				xorB ^= arr[index];
			}
			++count;
			flag = !flag;
		}

		if (xorA == xorB) {
			System.out.println("Draw");
		} else if (xorA > xorB) {
			System.out.println("Alice");
			System.out.println(max[0]);
		} else {
			System.out.println("Bob");
		}
	}

	public static void main(String[] args) {
		
		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int T = Integer.parseInt(br.readLine());
			for (int t = 1; t <= T; t++) {

				bMap = new HashMap<>();
				root = new Trie();
				indexRef = new HashMap<>();
				length=new HashMap<>();

				// read N
				int n = Integer.parseInt(br.readLine());

				String line = br.readLine();

				// declare array for N numbers
				int arr[] =(n%2==0)?new int[n]:new int[n+1];

				int i = 0, j = 0;

				// read N numbers
				while (i < line.length()) {

					// Read number
					StringBuilder sb = new StringBuilder();
					while (i < line.length() && line.charAt(i) != ' ') {
						sb.append(line.charAt(i));
						i++;
					}

					String sVal = sb.toString();
					int num = Integer.valueOf(sVal);
					arr[j] = num;

					String binary = Integer.toBinaryString(num);
					LinkedList<Integer>list;
					if(length.containsKey(binary.length())){
						list=length.get(binary.length());
					}
					else{
						list=new LinkedList<>();
					}
					list.add(j);
					length.put(binary.length(), list);
					char zeroes[] = new char[32 - binary.length()];
					Arrays.fill(zeroes, '0');
					binary= new StringBuilder().append(String.valueOf(zeroes)).append(binary).toString();
					bMap.put(num, binary);
					

					// Once the binary string is ready insert into Trie
					put(num, binary, j);

					j++;
					i++;
				}
                if(n%2!=0){
                	String binary=getBinary(0);
                	put(0,binary,arr.length-1);
                }
				if(n==2){
					if(arr[0]==arr[1]){
						System.out.println("Draw");
					}
					else{
						System.out.println("Alice");
						System.out.println(Math.max(arr[0], arr[1]));
					}
					continue;
				}
                
				// generate xor pairs
				xorPair(arr);

				// find winner
				findWinner(arr);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}