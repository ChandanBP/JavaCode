package Trees;

public class RemoveHalfNodes {
	
	Node root;
	class Node{
		int key;
		Node left;
		Node right;
		public Node(int k){
			this.key = k;
		}
	}

    public Node removeHalfNodes(Node root){
		
    	if(root==null) return null;
		if(root.left==null && root.right==null)return root;
        
		root.left = removeHalfNodes(root.left);
		root.right = removeHalfNodes(root.right);
		
		if(root.left!=null&&root.right!=null)return root;
		
		return (root.left==null)?root.right:root.left;
	}
    
    public void remove(){
		
    	root = new Node(2);
    	root.left        = new Node(7);
    	root.right       = new Node(5);
    	root.left.right = new Node(6);
    	root.left.right.left=new Node(1);
    	root.left.right.right=new Node(11);
    	root.right.right=new Node(9);
    	root.right.right.left=new Node(4);
		
		inOrder(removeHalfNodes(root));
	}

    public void inOrder(Node root){
    	
    	if(root==null)return;
    	inOrder(root.left);
    	System.out.print(root.key+" ");
    	inOrder(root.right);
    }
    
	public static void main(String args[]){
		RemoveHalfNodes remove = new RemoveHalfNodes();
		remove.remove();
	}
}
