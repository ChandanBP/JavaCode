import java.util.LinkedList;
import java.util.Queue;

public class BoundaryOfBinaryTree {

	Node root;
	Queue<Node>Q = new LinkedList<Node>();
	
	class Node{
		int key;
		
		public Node(int key){
			this.key = key;
		}
		Node left;
		Node right;
	}
	
	public void printBoundary(){
		
		root = new Node(1);
		
		root.left = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(4);
		root.left.left.left = new Node(5);
		root.left.left.right = new Node(6);
		root.left.right.left = new Node(8);
		root.left.right.right = new Node(7);
		
		root.right = new Node(9);
		root.right.left = new Node(10);
		root.right.right = new Node(11);
		root.right.left.left = new Node(12);
		root.right.left.right = new Node(13);
		root.right.right.left = new Node(14);
		root.right.right.right = new Node(15);
		
		
		Node node = root;
		System.out.print(node.key+" ");
		printLeftBoundary(root.left);
		printLeaf(root);
		printRightBoundary(node.right);
		
	}
	
	public void printRightBoundary(Node root){
		if(root!=null){
			if(root.right!=null){
				printRightBoundary(root.right);
				System.out.print(root.key+" ");
			}
			else if(root.left!=null){
				printRightBoundary(root.right);
				System.out.print(root.key+" ");
			}
		}
	}
	
	public void printLeftBoundary(Node root){
		if(root!=null){
			if(root.left!=null){
				System.out.print(root.key+" ");
				printLeftBoundary(root.left);
			}
			else if(root.right!=null){
				System.out.print(root.key+" ");
				printLeftBoundary(root.left);
			}
		}
	}
	
	public void printLeaf(Node root){
		
		if(root==null)return;
		printLeaf(root.left);
		if(root.left==null&&root.right==null){
			System.out.print(root.key+" ");
		}
		printLeaf(root.right);
	}
	
	public static void main(String args[]){
		
		BoundaryOfBinaryTree boundary = new BoundaryOfBinaryTree();
		boundary.printBoundary();
	}
	
}
