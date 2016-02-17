
public class SumTree {

	Node root;
	class Node{
		int key;
		Node left;
		Node right;
		public Node(int k){
			key = k;
		}
	}
	
	int getSumTree(Node root){
		
		int val = 0;
		if(root==null)return val;
		else if(root.left==null && root.right==null){
			val = root.key;
			root.key = 0;
			return val;
		}
		else{
			int left = getSumTree(root.left);
			int right = getSumTree(root.right);
			root.key = left+right;
			return root.key;
		}
	}
	
	void getSum(){
		root = new Node(1);
		
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		root.right = new Node(3);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		getSumTree(root);
	}
	
	void preOrder(Node root){
		if(root==null)return;
		System.out.println(root.key);
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		SumTree obj = new SumTree();
		obj.getSum();
		obj.preOrder(obj.root);
	}
	
}
