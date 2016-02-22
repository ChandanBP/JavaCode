package Trees;


public class DeepestNode {

	Node root;
	Node maxNode;
	int maxLevel;
	class Node{
		int key;
		Node left;
		Node right;
		
		public Node(int n){
			this.key = n;
		}
	}
	
	class Ret{
		int level;
		Node node;
		public Ret(int level,Node node){
			this.level=level;
			this.node = node;
		}
	}
	
	public Ret solution2(Node root,int level){
		
		Ret node=new Ret(-1,null);
		
		Ret left,right;
		if(root==null)return node;
		
		left=solution2(root.left,level+1);
		right=solution2(root.right,level+1);
		
		if(left.level>right.level){
			node.level = left.level;
			node.node = left.node;
		}
		else{
			node.level = right.level;
			node.node = right.node;
		}
		
		if(node.level>level){
			return node;
		}
		else{
			node.level = level;
			node.node = root;
			return node;
		}
	}	
	// Solution 1 using global variables
    public void solution1(Node root,int level,int maxLevel){
		
		if(root==null)return;
		
		if(maxLevel<level){
			this.maxLevel=level;
			maxNode = root;
		}
		
		solution1(root.left,level+1,this.maxLevel);
		solution1(root.right,level+1,this.maxLevel);
	}
	
	public void buildTree(){
		
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.right.right = new Node(8);
		solution1(root, 1, 0);
		System.out.println(maxNode.key);
        System.out.println(solution2(root, 0).node.key);
	}
	
	public static void main(String args[]){
		
		DeepestNode obj = new DeepestNode();
		obj.buildTree();
	}
}
