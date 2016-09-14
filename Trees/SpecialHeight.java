
public class SpecialHeight {

	static Node root;
	
	public static int height(Node node){
		if(node==null)return 0;
		if(node.left.right==node)return 1;
		
		int left=height(node.left);
		int right=height(node.right);
		return Math.max(left, right)+1;
	}
	
	public static void main(String[] args) {
		
		root=new Node(1);
		root.left = new Node(2);
	    root.right = new Node(3);
	    root.left.left = new Node(4);
	    root.left.right = new Node(5);
	    root.left.left.left = new Node(6);
	    
	    Node L1 = root.left.left.left;
	    Node L2 = root.left.right;
	    Node L3 = root.right;
	    
	    L1.right = L2; L2.right = L3; L3.right = L1;
	    
	    // set prev pointer of linked list
	    L3.left = L2; L2.left = L1; L1.left = L3;
	    
	    System.out.println(height(root));
	    
	}
}
