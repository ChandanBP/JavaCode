
public class TreeContainsSubTree {

	StringBuilder sInOrderBuilder = new StringBuilder();
	StringBuilder tInOrderBuilder = new StringBuilder();
	StringBuilder sPreOrderBuilder = new StringBuilder();
	StringBuilder tPreOrderBuilder = new StringBuilder();
	
	public void inOrder(Node node,StringBuilder s){
		
		if(node == null){
			s.append("$");
			return;
		}
		inOrder(node.left,s);
		s.append(node.key);
		inOrder(node.right,s);
	}
	
    public void preOrder(Node node,StringBuilder s){
		
		if(node == null){
			s.append("$");
			return;
		}
		s.append(node.key);
		preOrder(node.left,s);
		preOrder(node.right,s);
	}
	
    public boolean isSubTree(Node S,Node T){
    	
    	inOrder(S, sInOrderBuilder);
    	inOrder(T, tInOrderBuilder);
    	
    	if(!tInOrderBuilder.toString().contains(sInOrderBuilder.toString()))return false;
    	
    	preOrder(S, sPreOrderBuilder);
    	preOrder(T, tPreOrderBuilder);
    	

    	if(!tPreOrderBuilder.toString().contains(sPreOrderBuilder.toString()))return false;
    	
    	return true;
    }
    
	public static void main(String[] args) {
		
		Node T = new Node(1);
	    T.left = new Node(2);
	    T.right = new Node(4);
	    T.left.left = new Node(3);
	    T.right.right = new Node(6);
	    T.right.left = new Node(5);
	 
	    Node S = new Node(4);
	    S.left = new Node(5);
	    S.right = new Node(6);
	    S.left.left = new Node(7);
		
	    
	    TreeContainsSubTree obj = new TreeContainsSubTree();
	    if(obj.isSubTree(S,T)){
	    	System.out.println("S is sub tree of T");
	    }
	    else{
	    	System.out.println("S is not sub tree of T");
	    }
	}
	
}
