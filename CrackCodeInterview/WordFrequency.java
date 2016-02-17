import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

public class WordFrequency {

	class Node implements Comparable<Node>{
		
		char alpha;
		String word;
		int frequency;
		Node next[];
		@Override
		public int compareTo(Node o) {
			return o.frequency-this.frequency;
		}
	}
	
	Node root = new Node();
	
	HashMap<String, Node>map = new HashMap<>();
	PriorityQueue<Node>queue = new PriorityQueue<>();
	
	public void readFile(){
		
		try{
			
			BufferedReader br = new BufferedReader(new FileReader("Corpus.txt"));
			String line = br.readLine();
			String words[];
			
			while(line!=null){
				
				words = line.split(" ");
				String word;
				for (int i = 0; i < words.length; i++) {
					
					word = words[i];
					Node node = root;
					int index;
					
					for (int j = 0; j < word.length(); j++) {
						
						index = word.charAt(j)-97;
						if(node.next==null){
							node.next = new Node[26];
						}
						
						if(node.next[index] == null){
							node.next[index] = new Node();
						}
						node = node.next[index];
					}
					
					node.frequency++;
					node.word = word;
					map.put(node.word, node);
				}
				line = br.readLine();
			}
			
			
			Iterator it = map.entrySet().iterator();
			ArrayList<Integer>list = new ArrayList<Integer>();
			
			int c = 100000000;
			list.add(7);
			list.add(7);
			list.add(6);
			list.add(6);
			list.add(5);
			list.add(5);
			Collections.sort(list);
			
			while(it.hasNext()){
				Map.Entry<String, Node>pair = (Map.Entry<String, Node>)it.next();
				queue.add(pair.getValue());
			}
			
			
			
		}
	    catch(FileNotFoundException fileNotFoundException){
	    	fileNotFoundException.printStackTrace();
	    }
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
	
	public static void main(String args[]){
		
		WordFrequency freq = new WordFrequency();
		freq.readFile();
	}
}
