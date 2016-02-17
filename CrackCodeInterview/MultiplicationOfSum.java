import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MultiplicationOfSum {

	class Node{
		int key;
		Node left;
		Node right;
		public Node(int key){
			this.key = key;
		}
	}
	
	public void getRes(){
		
		Stack<Node>stack = new Stack<>();
		
		Node root = new Node(2);
	    root.left = new Node(7);
	    root.right = new Node(5);
	    root.left.right = new Node(6);
	    root.left.left = new Node(8);
	    root.left.right.left = new Node(1);
	    root.left.right.right = new Node(11);
	    root.right.right = new Node(9);
	    root.right.right.left = new Node(4);
	    root.right.right.right = new Node(10);
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		int mult=1,sum;
		
		while(!queue.isEmpty()){
			
			
			Node parent;
			LinkedList<Node>children = new LinkedList<Node>();
			sum = 0;
			while(!queue.isEmpty()){
				
				parent = queue.poll();
				
				if(parent.left==null && parent.right==null){
					sum = sum + parent.key;
				}
				if(parent.left!=null){
					children.add(parent.left);
				}
				if(parent.right!=null){
					children.add(parent.right);
				}
			}
			mult=mult*sum;
			System.out.print(sum);
			queue = children;
		}
		//System.out.println(mult);
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		MultiplicationOfSum obj = new MultiplicationOfSum();
		obj.getRes();
	}

}
