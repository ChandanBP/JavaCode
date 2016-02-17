public class CloneLinkedList {

	private class Node{
		int key;
		Node next;
		Node random;		
		public Node(int k){
			key = k;
		}
	}
	
	
	public Node cloneList(Node l1){
		
		Node head1 = l1;
		while(head1!=null){
			System.out.print(head1.key+" ");
			if(head1.random!=null)System.out.println(head1.random.key);
			head1 = head1.next;
		}
		
		head1=l1;
	    Node head2=null;
		while(head1!=null){
			head2 = new Node(head1.key);
			head2.next = head1.next;
			head1.next = head2;
			head1 = head1.next.next;
		}
		
		
		// adjust the random pointers
		head1 = l1;
		while(head1!=null){
			if(head1.random!=null){
			   head1.next.random = head1.random.next;
			}
			head1.next = head1.next.next;
			head1 = head1.next;
			head1.next.next = head1.next;
		}
		
		return head2;
	}
	
	public void originalList(){
		
		Node node = new Node(1);
		node.next = new Node(2);
		node.next.next = new Node(3);
		node.next.next.next = new Node(4);
		node.next.next.next.next = new Node(5);
		node.next.next.next.next.next = new Node(6);
		node.next.next.next.next.next.next = new Node(7);
		
		node.next.next.next.next.next.next.random = node;
		node.next.random = node.next.next.next; 
		Node l2 = cloneList(node);
		System.out.println("After clone");
		while(l2!=null){
			System.out.println(l2.key+" "+l2.random.key);
			l2 = l2.next;
		}
	}
	
	public static void main(String args[]){
		
		CloneLinkedList clone = new CloneLinkedList();
		clone.originalList();
	}
}
