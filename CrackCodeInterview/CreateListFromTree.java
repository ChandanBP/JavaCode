import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// This code constructs linked list for each depth in binary tree


public class CreateListFromTree {

	ArrayList<LinkedList<Node>>arrayList = new ArrayList<LinkedList<Node>>();
	Queue<Node>queue = new LinkedList<Node>();
	
	
	public void createList(Node root){
		
		if(root == null){
			return;
		}
		
		queue.add(root);
		LinkedList<Node>list;
		list = new LinkedList<Node>(); 
		list.add(root);
		
		arrayList.add(list);
		
		Node node;
		Queue<Node>children;
		while(!queue.isEmpty()){
			
			children = new LinkedList<Node>();
			list = new LinkedList<Node>();
			
			while(!queue.isEmpty()){
				node = queue.poll();
				if(node.left!=null){
					list.add(node.left);
					children.add(node.left);
				}
				if(node.right!=null){
					list.add(node.right);
					children.add(node.right);
				}
			}
			arrayList.add(list);
			queue = children;
		}
	}
	
	public void printList(){
		
		LinkedList<Node>l;
		for (int i = 0; i < arrayList.size(); i++) {
			
			l = arrayList.get(i);
			for (int j = 0; j < l.size(); j++) {
				System.out.print(l.get(j).key+" ");
			}
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(4);
		root.left.left = new Node(3);
		root.right.right = new Node(6);
		root.right.left = new Node(5);
		
	    CreateListFromTree obj = new CreateListFromTree();
	    obj.createList(root);
	    obj.printList();
	}
	
}
