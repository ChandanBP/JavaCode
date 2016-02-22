// To reverse alternate levels of perfect binary tree

package Trees;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class ReverLevels {

	Node root;
	Stack<Node>s = new Stack();
	class Node{

		char key;
		Node left;
		Node right;
		
		public Node(char n){
			this.key = n;
		}
	}
	
	public void solution2(Node root,int level){
		
		if(root==null)return;
	    solution2(root.left,level+1);
	    if(level%2!=0){
	    	s.push(root);
	    }
	    solution2(root.right,level+1);
	}
	
   public void print(Node root,int level){
		
		if(root==null)return;
	    print(root.left,level+1);
	    if(level%2!=0){
	    	root.key = s.pop().key;
	    }
	    print(root.right,level+1);
	}
	
	
	public void reverseLevels(){
		root = new Node('a');
	    root.left = new Node('b');
	    root.right = new Node('c');
	    root.left.left = new Node('d');
	    root.left.right = new Node('e');
	    root.right.left = new Node('f');
	    root.right.right = new Node('g');
	    root.left.left.left = new Node('h');
	    root.left.left.right = new Node('i');
	    root.left.right.left = new Node('j');
	    root.left.right.right = new Node('k');
	    root.right.left.left = new Node('l');
	    root.right.left.right = new Node('m');
	    root.right.right.left = new Node('n');
	    root.right.right.right = new Node('o');
	    
	    Queue<Node>queue = new LinkedList<Node>();
	    queue.add(root);
	    
	    int level = 0;
	    int n;
	    char children[];
	    Node node;
	    int index=0;
	    Stack<Node>stack;
	    Node stackNode;
	    
	    System.out.println("Solution2");
	    inOrder(root);
	    System.out.println();
	    solution2(root,0);
	    print(root,0);
	    inOrder(root);
	    System.out.println();
	    
	    while(!queue.isEmpty()){
	    	
	    	n = queue.size();
    		stack = new Stack<Node>();
    		children = new char[queue.size()*2];
    		while(n>0){
	    		
	    		node = queue.poll();
	    		if(node.left!=null){
	    			queue.add(node.left);
	    			if(level==0){
	    				children[index++] = node.left.key;
                        stack.push(node.left);
	    			}
    			}

	    		if(node.right!=null){
	    			queue.add(node.right);
	    			if(level==0){
	    				children[index++] = node.right.key;
	    				stack.push(node.right);
	    			}
	    		}
	    		n--;
	    	}
    		
	    	if(level==0){
    			for(int j=0;j<children.length;j++){
	    			stackNode = stack.pop();
	    			stackNode.key = children[j];
	    		}
    		}
	    	index = 0;
	    	level = 1-level;
	    }
	    inOrder(root);
	}
	
	public void inOrder(Node root){
		if(root==null)return;
		inOrder(root.left);
		System.out.print(root.key+" ");
		inOrder(root.right);
	}
	
	public static void main(String args[]){
		
		ReverLevels obj = new ReverLevels();
		obj.reverseLevels();
	}
}
