package geeksforgeeks;

public class NodesWithKLeaves {

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
		root.left = new Node(2);
		root.right = new Node(4);
		
		root.left.left = new Node(5);
		root.left.right = new Node(6);
		root.left.left.left = new Node(9);
		root.left.left.right = new Node(9);
		
		root.right.left = new Node(7);
		root.right.right = new Node(8);
		root.right.left.left = new Node(11);
		root.right.left.right = new Node(12);
	}
	
	public int printNodes(Node root,int k){
		
		if(root==null)return -1;
		if(root.left==null && root.right==null)return 1;
		
		int left = printNodes(root.left,k);
		int right = printNodes(root.right,k);
		
		if(left+right==k)System.out.println(root.key);
		
		return left+right;
	}
	
	public void findNodes(){
		printNodes(root,1);
	}
	
	public static void main(String[] args) {
		
		NodesWithKLeaves nodes = new NodesWithKLeaves();
		nodes.buildTree();
		nodes.findNodes();
	}
}
