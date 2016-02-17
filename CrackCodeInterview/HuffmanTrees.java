import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;


public class HuffmanTrees {
	
	static Node root = new Node();
	static HashMap<Integer, String>map = new HashMap<>();
	
	static class Node implements Comparable<Node>{
		int key;
		int frequency;
		Node left;
		Node right;
		
		public Node(){
			
		}
		
		public Node(int key,int freq){
			this.key = key;
			frequency = freq;
			left = null;
			right = null;
		}

		@Override
		public int compareTo(Node o) {
			
				return this.frequency-o.frequency;
		}
	}
	
	public static String constructTree(String input1){
		int []count = new int[26];
		String split[] = input1.split("");
		int index;
		for (int i = 1; i < split.length; i++) {
			index = split[i].charAt(0);
			index = index-97;
			count[index]++;
		}
		
		PriorityQueue<Node>queue = new PriorityQueue<Node>();
		Node node;
		for (int i = 0; i <count.length; i++) {
			if(count[i]!=0){
				node = new Node(i, count[i]);
	            queue.add(node);
			}
		}
		
		Node qNode1;
		Node qNode2;
		Node treeNode;
		
		if(queue.size()==1){
			input1="0";
		}
		else{
		while(queue.size()>1){
			
			qNode1 = queue.poll();
			qNode2 = queue.poll();
			
			treeNode = new Node();
			
			treeNode.frequency = qNode1.frequency+qNode2.frequency;
			
		//	if(qNode1.frequency==qNode2.frequency){
				treeNode.left = (qNode1.key<qNode2.key)?qNode1:qNode2;
				treeNode.right = (qNode1.key>qNode2.key)?qNode1:qNode2;
//			}
//			else{
//				treeNode.left = qNode1;
//				treeNode.right = qNode2;
//			}
			root = treeNode;
			queue.add(treeNode);
		}
		
		buildSequence(root,"");
		input1="";
		for (int i = 1; i < split.length; i++) {
			index = split[i].charAt(0);
			index = index-97;
			input1 = input1+map.get(index);
			System.out.print(map.get(index));
		}
		}
		
	//	System.out.print(input1);
		return input1;
	}
	
	public static void buildSequence(Node root,String sb){
		
		if(root==null)return;
		if(root.left==null&&root.right==null){
			if(map.get(root.key)==null){
				map.put(root.key, sb);
			}
		}
		else{
		buildSequence(root.left, sb+"0");
		buildSequence(root.right, sb+"1");
		}
	}
	

	public static void main(String args[]){
		
		constructTree("abbbcd");
	}
	
}
