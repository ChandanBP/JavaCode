package geeksforgeeks;

import java.util.LinkedList;

public class KSumPaths {
	
	class Node{
		int key;
		Node left;
		Node right;
		
		public Node(int key){
			this.key=key;
		}
	}
	
	Node root;
	
	public void buildTree(){
		
		root = new Node(1);
		root.left = new Node(3);
		root.right = new Node(-1);
		
		root.left.left = new Node(2);
		root.left.right = new Node(1);
		root.left.right.left = new Node(1);
		
		root.right.left = new Node(4);
		root.right.right = new Node(5);
		root.right.right.right = new Node(6);
		root.right.left.left = new Node(1);
		root.right.left.right = new Node(2);
	}
	
	public void printPath(Node root,int k,LinkedList<Node>list){
		
		if(root==null)return;
		
		list.add(root);
		
		printPath(root.left, k, list);
		printPath(root.right, k, list);
		
		int sum=0;
		for(int i=list.size()-1;i>=0;i--){
			sum+=list.get(i).key;
			if(sum==k){
				for(int j=i;j<list.size();j++){
					System.out.print(list.get(j).key+" ");
				}
				System.out.println();
			}
		}
		
		list.removeLast();
	}
	
	public void printPaths(Node root,int k){
		
		LinkedList<Node>list=new LinkedList<Node>();
		printPath(root, k, list);
	}
	
	public static void main(String[] args) {
		
		KSumPaths ksum = new KSumPaths();
		ksum.buildTree();
		ksum.printPaths(ksum.root, 5);
	}
}