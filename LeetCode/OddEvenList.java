package leetcode;

public class OddEvenList {

	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
    }
	
    public ListNode oddEvenList(ListNode head) {
        
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        
        ListNode prev,curr;
        ListNode head2;
        prev = head;
        curr = head.next;
        head2 = curr;
        while(curr!=null){
            prev.next = curr.next;
            prev = curr;
            curr = curr.next;
        }
        curr = head;
        while(curr.next!=null){
            curr = curr.next;
        }
        curr.next = head2;
        return head;
    }

}
