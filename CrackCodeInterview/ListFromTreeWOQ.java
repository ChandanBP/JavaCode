import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ListFromTreeWOQ {

	ArrayList<LinkedList<Node>>lists = new ArrayList<>();
	
	
	public void buildList(Node root,int level){
		
		if(root==null)return;
		
		LinkedList<Node>list;
		if(lists.size()<=level){
			list = new LinkedList<>();
			list.add(root);
			lists.add(level, list);
		}
		else{
			list = lists.get(level);
			list.add(root);
		}
		buildList(root.left, level+1);
		buildList(root.right, level+1);
	}
	
	public void getList(){
		
		Node root = new Node(10);
		root.left = new Node(6);
		root.right = new Node(17);
		root.left.left = new Node(4);
		root.right.left = new Node(14);
		root.right.right = new Node(19);
		
		buildList(root,0);
		
		Iterator<LinkedList<Node>>ite = lists.iterator();
		LinkedList<Node>list;
		while(ite.hasNext()){
			list = ite.next();
			while(!list.isEmpty()){
				System.out.print(list.removeFirst().key+" ");
			}
			System.out.println();
		}
	}
	
	
	public static void main(String args[]){
		
		ListFromTreeWOQ obj = new ListFromTreeWOQ();
		obj.getList();
	}
}
