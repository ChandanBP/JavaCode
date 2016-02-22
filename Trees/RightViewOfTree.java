
package Trees;

import java.util.Queue;
import java.util.LinkedList;

public class RightViewOfTree {

	Node root;
	int maxLevel;
	class Node{
		int key;
		Node left;
		Node right;
		
		public Node(int n){
			this.key = n;
		}
	}
	
	public void rightView(Node root){
		if(root==null)return;
		
		Queue<Node>queue = new LinkedList<Node>();
		
		queue.add(root);
		Node node;
		
		while(!queue.isEmpty()){
			
			int n = queue.size();
			while(n>0){
				if(n==1){
					System.out.print(queue.peek().key+" ");
				}
				node = queue.poll();
				if(node.left!=null){
					queue.add(node.left);
				}
				if(node.right!=null){
					queue.add(node.right);
				}
				n--;
			}
		}
	}
	
	public void printRightView(){
		
		root = new Node(1);
	    root.left = new Node(2);
	    root.right = new Node(3);
	    root.left.left = new Node(4);
	    root.left.right = new Node(5);
	    root.right.left = new Node(6);
	    root.right.right = new Node(7);
	    root.right.left.right = new Node(8);
	    rightView(root);
	}
	
	public static void main(String args[]){
	
		RightViewOfTree obj = new RightViewOfTree();
		obj.printRightView();
	}
}
