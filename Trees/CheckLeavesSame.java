package Trees;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class CheckLeavesSame {

	Node t1,t2;
	class Node{
		int key;
		Node left;
		Node right;
		
		public Node(int n){
			this.key = n;
		}
	}
	
	
	public LinkedList<Node> getLeaves(Node root){
		
		Queue<Node> q;
		q = new LinkedList<Node>();
		LinkedList<Node>leaves = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()){
			
			Node node;
			LinkedList<Node>children = new LinkedList<Node>();
			
			while(!q.isEmpty()){
				node =  q.poll();
				if(node.left==null&&node.right==null){
					leaves.add(node);
				}
				if(node.left!=null){
					children.add(node.left);
				}
				if(node.right!=null){
					children.add(node.right);
				}
			}
			q = children;
		}
		
		return leaves;
	}
	
	public void isLeaveSame(Node t1,Node t2){
		
		t1 = new Node(1);
		t1.left = new Node(2);
		t1.left.left = new Node(4);
		
		t1.right = new Node(3);
		t1.right.right = new Node(7);
		t1.right.left = new Node(6);
		
		t2 = new Node(0);
		t2.left = new Node(5);
		t2.left.right = new Node(4);
		
		t2.right = new Node(8);
		t2.right.right = new Node(7);
		t2.right.left = new Node(6);
		
		LinkedList<Node> leaves1 = getLeaves(t1);
		LinkedList<Node> leaves2 = getLeaves(t2);
		
		if(leaves1.isEmpty()||leaves2.isEmpty()){
			System.out.println("Leaves not same");
		}
		else if(leaves1.size()!=leaves2.size()){
			System.out.println("Leavse not same");
		}
		else{
			Iterator<Node> ite1 = leaves1.iterator();
			Iterator<Node> ite2 = leaves1.iterator();
			Node node1,node2;
			while(ite1.hasNext()){
				node1 = ite1.next();
				node2 = ite2.next();
				if(node1.key!=node2.key){
					System.out.println("Leaves not same");
					return;
				}
			}
			System.out.println("Leaves same");
		}
	}
	
	public static void main(String args[]){
		CheckLeavesSame obj = new CheckLeavesSame();
		obj.isLeaveSame(obj.t1,obj.t2);
	}
}
