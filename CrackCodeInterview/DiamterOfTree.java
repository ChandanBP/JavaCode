public class DiamterOfTree {

	Node root;
	private class Node{
		int key;
		Node left;
		Node right;		
		public Node(int k){
			key = k;
		}
	}
	
	public int[] getDiameter(Node root){
		
		int d[] = {0,0};
		int left[],right[];
		
		if(root==null){
			return d;
		}
		
		left = getDiameter(root.left);
		right = getDiameter(root.right);
		
		int height = Math.max(left[0], right[0])+1;
		int diam = Math.max(height, Math.max(left[1], right[1]));
		
		d[0] = height;
		d[1] = diam;
		
		return d;
	}
	
	public void printDiameter(){
		
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(6);
		root.left.right.left.right = new Node(7);
		root.left.left.left = new Node(8);
		
		System.out.println(getDiameter(root)[1]);
	}
	
	
	public static void main(String args[]){
		
		DiamterOfTree diam = new DiamterOfTree();
		diam.printDiameter();
	}
	
}
