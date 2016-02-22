package Trees;


public class SumOfAllLeftLeaves {

	Node root;
	class Node{
		int key;
		Node left;
		Node right;
		
		public Node(int n){
			this.key = n;
		}
	}
	
	public int getLeftSum(Node root){
		
		int res = 0;
		if(root==null)return res;
		
		if(root.left!=null){
			if(root.left.left==null && root.left.right==null){
				res+=root.left.key;
			}
			else{
				res+=getLeftSum(root.left);
			}
		}
		res+=getLeftSum(root.right);
		return res;
	}
	
	
	public void getSum(){
		
		root         = new Node(20);
	    root.left                = new Node(9);
	    root.right               = new Node(49);
	    root.right.left         = new Node(23);
	    root.right.right        = new Node(52);
	    root.right.right.left  = new Node(50);
	    root.left.left          = new Node(5);
	    root.left.right         = new Node(12);
	    root.left.right.right  = new Node(12);
	    
	    System.out.println(getLeftSum(root));
	}
	
	
	public static void main(String args[]){
		SumOfAllLeftLeaves obj = new SumOfAllLeftLeaves();
		obj.getSum();
	}
	
}
