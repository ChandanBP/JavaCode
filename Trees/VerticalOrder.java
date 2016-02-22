package Trees;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class VerticalOrder {

	Node root;
	HashMap<Integer,LinkedList<Node>>map = new HashMap<Integer,LinkedList<Node>>();
	
	class Node{
		int key;
		Node left;
		Node right;
		
		public Node(int n){
			this.key = n;
		}
	}
	
	public void printVerticalNodes(Node root,int distance){
		
		if(root==null)return;
		LinkedList<Node>list;
		if(map.get(distance)==null){
			list = new LinkedList<Node>();
		}
		else{
			list = map.get(distance);
		}
		
		list.add(root);
		map.put(distance, list);
		
		printVerticalNodes(root.left, distance-1);
		printVerticalNodes(root.right, distance+1);
	}
	
	public void print(){
		
		Iterator<Map.Entry<Integer,LinkedList<Node>>>ite = map.entrySet().iterator();
		LinkedList<Node>list;
		
		while(ite.hasNext()){
			list = ite.next().getValue();
			for(int i=0;i<list.size();i++){
				System.out.print(list.get(i).key+" ");
			}
			System.out.println();
		}
		
	}
	
	public void printVertical(){
		
		root = new Node(1);
	    root.left = new Node(2);
	    root.right = new Node(3);
	    root.left.left = new Node(4);
	    root.left.right = new Node(5);
	    root.right.left = new Node(6);
	    root.right.right = new Node(7);
	    root.right.left.right = new Node(8);
	    root.right.right.right = new Node(9);
	    printVerticalNodes(root,0);
	    print();
	}
	
	public static void main(String args[]){
		VerticalOrder obj = new VerticalOrder();
		obj.printVertical();
	}
	
}
