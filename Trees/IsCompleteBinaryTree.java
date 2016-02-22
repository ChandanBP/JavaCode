package Trees;

import java.util.Queue;
import java.util.LinkedList;

public class IsCompleteBinaryTree {

	Node root;
	class Node{
		int key;
		Node left;
		Node right;
		
		public Node(int n){
			this.key = n;
		}
	}
	
	public boolean isComplete(){
		
		  root  = new Node(1);
		  root.left = new Node(2);
		  root.right = new Node(3);
		  root.left.left = new Node(4);
		  root.left.right = new Node(5);
		  root.right.right = new Node(6);
		 
		  Queue<Node> queue = new LinkedList<Node>();
		  
		  queue.add(root);
		  int count=0;
		  boolean first = true;
		  
		  while(!queue.isEmpty()){
			  
			  Node node;
			  LinkedList<Node>children = new LinkedList<Node>(); 
			  
			 while(!queue.isEmpty()){
				 
				 node = queue.poll();
				 if(node.left!=null){
					 children.add(node.left);
					
					 if(node.left.left==null && node.left.right==null){
						  if(first){
							 first = false;
							 count++;
						  }
						  else{
							  return false;
						  }
					 }
				 }
				 if(node.right!=null){
					 children.add(node.right);
					 if(node.right.left==null && node.right.right==null){
						    if(first){
						    	return false;
						    }
						    else{
						    	count++;
						    }
				     }
				 }
				 
				 if(count==2){
					 first = true;
					 count = 0;
				 }
			 }
			  queue = children;
		  }
		  
		return false;
	}
	
	public static void main(String args[]){
		
		IsCompleteBinaryTree is = new IsCompleteBinaryTree();
	    System.out.println(is.isComplete());	
	}
}
