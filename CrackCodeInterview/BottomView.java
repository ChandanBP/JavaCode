import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;

public class BottomView {

	HashMap<Integer, LinkedList<Node>>map = new HashMap<>();
	HashMap<Node,Integer>rootHD = new HashMap<>();
	
	
	public void printBottomView(Node root){
	
        Queue<Node>queue = new LinkedList<Node>();
        queue.add(root);
        rootHD.put(root, 0);
		LinkedList<Node>children;
		Node node;
		int level = 0;
		int hd;
		
		
        while(!queue.isEmpty()){
        	
        	children = new LinkedList<Node>();

        	LinkedList<Node>l;
        	boolean first = true;
        	while(!queue.isEmpty()){
        		
        		node = queue.poll();
        		if(node.key==14||node.key==10){
        			System.out.println("");
        		}
        		hd = rootHD.get(node);
        	        		
        		if(map.get(hd)==null){
        			l = new LinkedList<Node>();
        			l.add(node);
        			map.put(hd, l);
        		}
        		else{
        			
        			l = map.get(hd);
        			//l = new LinkedList<Node>();
        			if(first){
        				first =false;
        				l=null;
        				l = new LinkedList<Node>();
        				
        			}
        			l.addFirst(node);
        			map.put(hd, l);
        		}
        		
        		
        		if(node.left!=null){
					children.add(node.left);
					rootHD.put(node.left, rootHD.get(node)-1);
				}
				if(node.right!=null){
					children.add(node.right);
					rootHD.put(node.right, rootHD.get(node)+1);
				}
        	}
        	
        	queue = children;
        	level = level+1;
        }
        
        
        Iterator it = map.entrySet().iterator();
        LinkedList<Node>tl;
        while(it.hasNext()){
        	
        	Map.Entry<Integer, LinkedList<Node>>mapEntry = (Map.Entry<Integer, LinkedList<Node>>)it.next();
        	tl = mapEntry.getValue();
        	ListIterator<Node>ite = tl.listIterator();
        	while(ite.hasNext()){
        		System.out.print(ite.next().key+" ");
        	}
        }
	}
	
	
	
	public static void main(String args[]){
		Node root = new Node(20);
		root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
		
//		root.left = new Node(2);
//		root.left.left = new Node(4);
//		root.left.right = new Node(5);
//		root.left.right.right = new Node(8);
//		
//		root.right = new Node(3);
//		root.right.left = new Node(6);
//		root.right.right = new Node(7);
		
		BottomView obj = new BottomView();
		obj.printBottomView(root);
	}
	
}
