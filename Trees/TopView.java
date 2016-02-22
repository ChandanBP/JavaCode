package Trees;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TopView {

	Node root;
	HashMap<Integer,Node>map = new HashMap<Integer,Node>();
	
	class Node{
		int key;
		Node left;
		Node right;
		
		public Node(int n){
			this.key = n;
		}
	}
	
	
    public void printTopNodes(Node root,int distance){
		
		if(root==null)return;
		printTopNodes(root.left, distance-1);
		map.put(distance, root);
		printTopNodes(root.right, distance+1);
		
	}
	
   public void print(){
		
		Iterator<Map.Entry<Integer,Node>>ite = map.entrySet().iterator();
		Node node;
		while(ite.hasNext()){
			node = ite.next().getValue();
				System.out.print(node.key+" ");
		}
	} 
    
   public void printTopView(){
		
	   root = new Node(1);
       root.left = new Node(2);
       root.right = new Node(3);
       root.left.right = new Node(4);
       root.left.right.right = new Node(5);
       root.left.right.right.right = new Node(6);
	    printTopNodes(root,0);
	    print();
	}
	
	public static void main(String args[]){
		TopView obj = new TopView();
		obj.printTopView();
	}
}
