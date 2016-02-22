package Trees;

public class ClosetLeaf {
     
	Node root,X;
	class Node{
		int key;
		Node left;
		Node right;
		
		public Node(int n){
			this.key = n;
		}
	}
	
	public void getClosestDistance(){
		
		root  = new Node(1);
	    root.left  = new Node(12);
	    root.right = new Node(13);
	 
	    root.right.left   = new Node(14);
	    root.right.right  = new Node(15);
	 
	    root.right.left.left   = new Node(21);
	    root.right.left.right  = new Node(22);
	    root.right.right.left  = new Node(23);
	    root.right.right.right = new Node(24);
	 
	    root.right.left.left.left  = new Node(1);
	    root.right.left.left.right = new Node(2);
	    root.right.left.right.left  = new Node(3);
	    root.right.left.right.right = new Node(4);
	    root.right.right.left.left  = new Node(5);
	    root.right.right.left.right = new Node(6);
	    root.right.right.right.left = new Node(7);
	    root.right.right.right.right = new Node(8);
		
		X = root.right;
		System.out.println(Math.min(getMinDistFromX(X), getDistanceFromRoot(root)));
	}
	
	public int getDistanceFromRoot(Node root){
		
		if(root == null)return -1;
		if(root == X){
			return 0;
		}
		
		int left = getDistanceFromRoot(root.left);
		if(left!=-1){
			return 2+getMinDistFromX(root.right);
		}
		
		int right = getDistanceFromRoot(root.right);
		if(right!=-1){
			return 2+getMinDistFromX(root.left);
		}
		return -1;
	}
	
	public int getMinDistFromX(Node node){
		
		int left = 0,right = 0;
		if(node.left==null&&node.right==null)return 0;
		
		if(node.left!=null){
			left = getMinDistFromX(node.left);
		}
		if(node.right!=null){
			right = getMinDistFromX(node.right);
		}
		return 1+Math.min(left,right);
	}
	
	public static void main(String args[]){
		ClosetLeaf obj = new ClosetLeaf();
		obj.getClosestDistance();
	}
}
