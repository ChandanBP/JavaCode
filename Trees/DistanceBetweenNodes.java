package Trees;

public class DistanceBetweenNodes {

	Node root;
	int n1=3;
	int n2=4;
	class Node{
		int key;
		Node left;
		Node right;
		
		public Node(int n){
			this.key = n;
		}
	}

	public int distance(Node root){
		
		int left,right;
		if(root==null)return -1;
		if(root.key==n1||root.key==n2)return 0;
		
		left = distance(root.left);
		right = distance(root.right);
		
		
		if(left!=-1&&right!=-1){
			return left+right-2;
		}
		if(left!=-1){
			return 1+left;
		}
		else if(right!=-1){
			return 1+right;
		}
		else{
			return -1;
		}
	}
	
	public void getDistance(){
		
		root = new Node(1);
	    root.left = new Node(2);
	    root.right = new Node(3);
	    root.left.left = new Node(4);
	    root.left.right = new Node(5);
	    root.right.left = new Node(6);
	    root.right.right = new Node(7);
	    root.right.left.right = new Node(8);
	    System.out.println(distance(root));
	}
	
	public static void main(String args[]){
		
		DistanceBetweenNodes obj = new DistanceBetweenNodes();
		obj.getDistance();
	}
	
}
