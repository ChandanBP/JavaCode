import java.io.*;
import java.util.*;

public class Ontology {
	HashMap<String, Node>smallAlphaTree = new HashMap<String,Node>();
	HashMap<String, Node>capsAlphaTree = new HashMap<String,Node>();
	Trie trie=new Trie();
	
	class Node{
		String key;
		LinkedList<Node>children;
		public Node(String key,LinkedList<Node>children){
			this.key=key;
			this.children=children;
		}
	}
	
	class Trie{
		HashMap<String, Integer>aToZ;
		HashMap<String, Integer>AToZ;
		public Trie(){
			aToZ=new HashMap<String,Integer>();
			AToZ=new HashMap<String,Integer>();
		}
		Trie ref[];
	}
	
	public void putInTopicTree(String word,Node node){
		if(word.charAt(0)>=65 && word.charAt(0)<=90){
			capsAlphaTree.put(word, node);
		}
		if(word.charAt(0)>=97 && word.charAt(0)<=122){
			smallAlphaTree.put(word, node);
		}
	}
	
	public Node getFromTopicTree(String word){
		if(word.charAt(0)>=65 && word.charAt(0)<=90){
			return capsAlphaTree.get(word);
		}
		else{
			return smallAlphaTree.get(word);
		}
	}
	
	public void parseTree(String flatTree){
		String words[] = flatTree.split(" ");
        Stack<String>stack=new Stack<String>();
     // Go through all the words
     		for(int i=0;i<words.length;i++){
     			String word=words[i];
     			Node node;
     			if(word.equals(")")){ // Pop operation
     				word = stack.pop();
     				LinkedList<Node>children = new LinkedList<Node>();
     				while(!word.equals("(")){
     					children.addFirst(getFromTopicTree(word));
     					word=stack.pop();
     				}
     				Node root = getFromTopicTree(stack.peek());
     				root.children=children;
     			}
     			else{
     				stack.push(word);
     				if(!word.equals("(")){
     					node = new Node(word, null);
     					putInTopicTree(word, node);
     				}
     			}
     		}
	}
	
	public void parseInputQueries(String query){
		
		String input[] = query.split(": ");
		String topic = input[0];
		String question = input[1];
		boolean topicIsCapital = (topic.charAt(0)>=65 && topic.charAt(0)<=90)?true:false;
		Trie curr=trie;
		int val;
		for(int i=0;i<question.length();i++){
			int c = question.charAt(i);
			curr.ref = (curr.ref==null)?new Trie[256]:curr.ref;
			curr.ref[c] = (curr.ref[c]==null)?new Trie():curr.ref[c];
			curr=curr.ref[c];
			if(topicIsCapital){
				val=(curr.AToZ.containsKey(topic))?curr.AToZ.get(topic):0;
				curr.AToZ.put(topic, ++val);
			}
			else{
				val=(curr.aToZ.containsKey(topic))?curr.aToZ.get(topic):0;
				curr.aToZ.put(topic, ++val);
			}
		}
	}
	
	public int getCountFromSubTree(Node node,String question,Trie tr){
		
		String topic=node.key;
		HashMap<String,Integer> map = (topic.charAt(0)>=65 && topic.charAt(0)<=90)?tr.AToZ:tr.aToZ;
		int count=(map.containsKey(topic))?map.get(topic):0;
		if(node.children!=null){
    		for(int j=0;j<node.children.size();j++){
    			count+=getCountFromSubTree(node.children.get(j), question,tr);
    		}
    	}
		return count;
	}
	
	public int getCount(String prefix){
		
		int index = prefix.indexOf(" ");
		int count=0;
        int i=0;
        String topic = prefix.substring(0, index);
        String question = prefix.substring(index+1, prefix.length());
        Trie curr=trie;
        while(curr!=null && i<question.length()){
        	if(curr.ref==null){
        		break;
        	}
        	curr=curr.ref[question.charAt(i)];
        	i++;
        }
        if(curr!=null && i==question.length()){
        	HashMap<String,Integer> map = (topic.charAt(0)>=65 && topic.charAt(0)<=90)?curr.AToZ:curr.aToZ;
        	count=(map.containsKey(topic))?map.get(topic):0;
        	Node node=getFromTopicTree(topic);
        	if(node.children!=null){
        		for(int j=0;j<node.children.size();j++){
        			count+=getCountFromSubTree(node.children.get(j), question,curr);
        		}
        	}
        }
		return count;
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			Ontology ont = new Ontology();
			
			// Read number of topics
			int N = Integer.parseInt(br.readLine());
			String tree = br.readLine();
			ont.parseTree(tree);
			
			int M = Integer.parseInt(br.readLine()); // input queries
			for(int t=1;t<=M;t++){
				ont.parseInputQueries(br.readLine());
			}
			
			int K=Integer.parseInt(br.readLine());
			for(int k=1;k<=K;k++){
				System.out.println(ont.getCount(br.readLine()));
			}
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
}