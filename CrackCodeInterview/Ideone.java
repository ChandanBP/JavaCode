/* package whatever; // don't place package name! */



/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	
	private class Node{
		int key;
		Node left;
		Node right;
		
		public Node(int k){
			this.key = k;
		}
	}
	
	Node root;
	
	public void buildTree(){
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.left.left.left = new Node(7);
		
		Node parent = findCommonAncestor(root.left.left,root.left.right);
		if(parent!=null){
			System.out.println(parent.key);
		}
		else{
			System.out.println("Not present");
		}
	}
	
	public Node getParent(Node root,Node n1,Node n2){
		
		if(root==null)return null;
		if(root==n1||root==n2)return root;
		
		
		Node left,right;
		left = getParent(root.left,n1,n2);
		right = getParent(root.right,n1,n2);
		
		if(left!=null&&right!=null)return root;
		
	   return (left!=null)?left:right;	
	}
	
	public Node findCommonAncestor(Node n1,Node n2){
		
		if(n1==null && n2==null)return null;
		if(root==null)return null;
		
		Node ancestor = getParent(root,n1,n2);
		return ancestor;
	}
	
		
	public static void main (String[] args) throws java.lang.Exception
	{
		Ideone obj = new Ideone();
		obj.buildTree();
	}
}