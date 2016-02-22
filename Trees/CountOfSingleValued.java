package Trees;


public class CountOfSingleValued {

	Node root;
	class Node{
		int key;
		Node left;
		Node right;
		
		public Node(int n){
			this.key = n;
		}
	}
	
	public int getSingleValuedCount(Node root){
		
		int left,right;
		int count=0;
		
		if(root == null) return 0;
		if(root.left==null && root.right == null)return 1;
		
		left = getSingleValuedCount(root.left);
		right = getSingleValuedCount(root.right);
		count = left+right;
		
		if(left==1 && right==1){
			if((root.key == root.left.key) &&(root.key == root.right.key)){
				count++;
			}
		}
		else if(left==0){
			if(root.key == root.right.key){
				count++;
			}
		}
		else if(right == 0){
			if(root.key == root.left.key){
				count++;
			}
		}
		
		return count;
	}
	
	public void getCount(){
		
		root        = new Node(5);
	    root.left        = new Node(4);
	    root.right       = new Node(5);
	    root.left.left  = new Node(4);
	    root.left.right = new Node(4);
	    root.right.right = new Node(5);
	    
	    System.out.println(getSingleValuedCount(root));
	}
	
	public static void main(String args[]){
		
		CountOfSingleValued count = new CountOfSingleValued();
		count.getCount();
	}
	
}
