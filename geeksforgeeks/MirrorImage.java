package geeksforgeeks;


public class MirrorImage {

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
		root.left = new Node(3);
		root.right = new Node(2);
		
		root.right.left = new Node(5);
		root.right.right = new Node(4);
	}
	
	public Node getMirrorImage(Node root){
		
		if(root==null)return null;
		
		Node left = getMirrorImage(root.left);
		Node right = getMirrorImage(root.right);
		root.left=right;
		root.right=left;
		
		return root;
	}
	
	public void print(Node root){
		
		if(root==null)return;
		System.out.print(root.key+" ");
		print(root.left);
		print(root.right);
	}
	
	public static void main(String[] args) {
		
		MirrorImage image = new MirrorImage();
		image.buildTree();
		image.print(image.root);
		image.getMirrorImage(image.root);
		System.out.println();
		image.print(image.root);
	}
}
