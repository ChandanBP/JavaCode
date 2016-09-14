import java.util.LinkedList;
import java.util.Queue;

public class MirrorTrees {

	Node root1;
	Node root2;
	
	public static void main(String[] args) {
		
		MirrorTrees mirror=new MirrorTrees();
	
		mirror.root1=new Node(1);
		mirror.root1.left=new Node(3);
		mirror.root1.right=new Node(2);
		mirror.root1.right.left=new Node(5);
		mirror.root1.right.right=new Node(5);
		
		mirror.root2=new Node(1);
		mirror.root2.left=new Node(2);
		mirror.root2.right=new Node(3);
		mirror.root2.left.right=new Node(5);
		mirror.root1.left.left=new Node(4);
		
		Queue<Node>queue1=new LinkedList<>();
		Queue<Node>queue2=new LinkedList<>();
		
		queue1.add(mirror.root1);
		queue2.add(mirror.root2);
		
		while(!queue1.isEmpty() && !queue2.isEmpty()){
			
			
			Queue<Node> children1=new LinkedList<>();
			Queue<Node> children2=new LinkedList<>(); 
			
			while(!queue1.isEmpty() && !queue2.isEmpty()){
				
				Node node1=queue1.poll();
				Node node2=queue2.poll();
				
				if(node1.key!=node2.key){
					System.out.println("Not mirror");
					return;
				}
				
				if(node1.left!=null){
					children1.add(node1.left);
				}
				if(node1.right!=null){
					children1.add(node1.right);
				}
				
				if(node2.right!=null){
					children2.add(node2.right);
				}
				if(node2.left!=null){
					children2.add(node2.left);
				}
			}
		}
		System.out.println("Mirros trees");
	}
}
