package Trees;

public class MaxPathSum {

	Node root;
	class Node{
		int key;
		Node left;
		Node right;
		
		public Node(int n){
			this.key = n;
		}
	}
	
	public int getMaxPathSum(Node root){
		
		if(root==null)return 0;
		
		int leftMax = getMaxPathSum(root.left);
		int rightMax = getMaxPathSum(root.right);
		
		int max1 = Math.max(Math.max(leftMax, rightMax), root.key);
		int max2 = Math.max(max1, leftMax+rightMax+root.key);
		return Math.max(max1, max2);
		
	}
	
	public void getMaxSum(){
		
		root = new Node(10);
	    root.left        = new Node(2);
	    root.right       = new Node(10);
	    root.left.left  = new Node(20);
	    root.left.right = new Node(1);
	    root.right.right = new Node(-25);
	    root.right.right.left   = new Node(3);
	    root.right.right.right  = new Node(4);
	    
	    System.out.println(getMaxPathSum(root));
		
	}
	
	public static void main(String args[]){
		MaxPathSum maxSum = new MaxPathSum();
		maxSum.getMaxSum();
	}
	
}
