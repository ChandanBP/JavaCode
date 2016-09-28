// Largest bst from binary tree
public class LargestBST {

	int max;
	Node root;
	
	class Result{
		
		boolean isBST;
		int min;
		int max;
		int size;
		
		public Result(){
			isBST=true;
			max=Integer.MIN_VALUE;
			min=Integer.MAX_VALUE;
			size=0;
		}
	}
	
	public void buildTree(){
		
		root=new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);
        
        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        
        
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);
	}
	
	public Result getResultNode(boolean isBST,int size,int min,int max){
		Result result=new Result();
		result.size=size;
		result.max=max;
		result.min=min;
		result.isBST=isBST;
		return result;
	}
	
	public Result large(Node root){
		
		if(root==null)return new Result();
		if(root.left==null&&root.right==null){
			return getResultNode(true, 1, root.key, root.key);
		}
		
		Result left,right;
		left=large(root.left);
		right=large(root.right);
		
		if(left.isBST && right.isBST && root.key>=left.max && root.key<right.min){
			max=Math.max(max, left.size+right.size+1);
			return getResultNode(true, left.size+right.size+1, left.min, right.max);
		}
		else{
			return getResultNode(false, 1, 0, 0);
		}
	}
	
	public static void main(String[] args) {
		
		LargestBST tree=new LargestBST();
		tree.buildTree();
		tree.large(tree.root);
		System.out.println(tree.max);
	}
}
