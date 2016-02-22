// To convert tree to Doubly linked list in place

package Trees;


public class TreeToDLL {

	Node root;
	Node head,last;
	class Node{
		int key;
		Node left;
		Node right;
		
		public Node(int n){
			this.key = n;
		}
	}

	public void convertToDLL(Node root){
		
		if(root==null)return;
		convertToDLL(root.left);
		if(head==null){
			head = root;
			last = root;
		}
		else{
			last.right = root;
			root.left = last;
			last=root;
		}
		convertToDLL(root.right);
	}
	
	public void printList(){
		
		Node curr;
		curr = head;
		while(curr!=null){
			System.out.print(curr.key+" ");
			curr = curr.right;
		}
	}
	
	public void buildTree(){
		
		root = new Node(10);
	    root.left        = new Node(12);
	    root.right       = new Node(15);
	    root.left.left  = new Node(25);
	    root.left.right = new Node(30);
	    root.right.left = new Node(36);
	    convertToDLL(root);
	    printList();
	}
	
	public static void main(String args[]){
		
		TreeToDLL treeToDLL = new TreeToDLL();
		treeToDLL.buildTree();
	}
}
