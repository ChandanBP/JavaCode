package Trees;

public class RemoveNodesLessThanK {

	Node root;
	class Node{
		int key;
		Node left;
		Node right;
		
		public Node(int n){
			this.key = n;
		}
	}
	
	public Node removeNodesLessThanK(Node root,int k){
		
		if(k==0||root==null)return null;
		
		if(root.left==null && root.right==null && k!=1)return null;
			
		root.left = removeNodesLessThanK(root.left, k-1);
		root.right = removeNodesLessThanK(root.right, k-1);

		if(root.left==null && root.right==null && k!=1){
			return null;
		}
		else{
			return root;
		}
	}
	
	public void inOrder(Node root){
		if(root==null)return;
		inOrder(root.left);
		System.out.print(root.key+" ");
		inOrder(root.right);
	}
	
	
	public void removeNodes(){
		root = new Node(1);
	    root.left = new Node(2);
	    root.right = new Node(3);
	    root.left.left = new Node(4);
	    root.left.right = new Node(5);
	    root.left.left.left = new Node(7);
	    root.right.right = new Node(6);
	    root.right.right.left = new Node(8);
	    int k=4;
	    System.out.println("Before removing");
	    inOrder(root);
	    root = removeNodesLessThanK(root,4);
	    System.out.println("\nAfter removing");
	    inOrder(root);
	}
	
	public static void main(String args[]){
		RemoveNodesLessThanK removeObj = new RemoveNodesLessThanK();
		removeObj.removeNodes();
	}
	
}
