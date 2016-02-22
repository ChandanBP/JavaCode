package Trees;

public class LeftView {
	
	
	Node root;
	int maxLevel=0;
	class Node{
		int key;
		Node left;
		Node right;
		
		public Node(int n){
			this.key = n;
		}
	}
	
	
	public void printLeftView(Node root,int level,int maxLevel){
		
		if(root==null)return;
		
		if(maxLevel<level){
			this.maxLevel =level;
			System.out.print(root.key+" ");
		}
		printLeftView(root.left, level+1, this.maxLevel);
		printLeftView(root.right, level+1, this.maxLevel);
	}
	
	public void buildTree(){
		
		root = new Node(12);
	    root.left = new Node(10);
	    root.right = new Node(30);
	    root.right.left = new Node(25);
	    root.right.right = new Node(40);
	    printLeftView(root, 1, 0);
	    
	}

	public static void main(String args[]){
		
		LeftView leftView = new LeftView();
		leftView.buildTree();
	}
	
}
