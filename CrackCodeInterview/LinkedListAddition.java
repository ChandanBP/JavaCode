import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LinkedListAddition {

	Node root;
	ArrayList<Integer>result = new ArrayList<>();
	class Node{
		int key;
		Node next;
		public Node(int val){
			this.key = val;
		}
	}

	public int findSum(Node list1,Node list2){
		
		int len1=0,len2=0;
		
		Node l1=list1,l2=list2;
		while(l1!=null){
			len1++;
			l1=l1.next;
		}
		while(l2!=null){
			len2++;
			l2=l2.next;
		}
		l1=list1;
		l2=list2;
		int diff=0;
		int val=0;
		if(len1!=len2){

			if(len1>len2){
				diff = len1-len2;
				l1 = list1;
				while(diff!=0){
					l1=l1.next;
					diff--;
				}
				val = getSum(l1,l2);
				l1 = list1;
				diff = len1-len2;
			}
			if(len2>len1){
				diff = len2-len1;
				l2 = list2;
				while(diff!=0){
					l2=l2.next;
					diff--;
				}
				val = getSum(l2,l1);
				l1 = list2;
				diff = len2-len1;
			}
			
			return getSumL(l1, val,diff-1);
		}
		else{
			return getSum(l1,l2);
		}
	}
	
	public int getSumL(Node l1,int val,int diff){
		
		int sum;
		if(diff==0){
			//System.out.print((l1.key+val)%10);
			result.add((l1.key+val)%10);
			return (l1.key+val)/10;
		}
		diff = diff-1;
		sum = getSumL(l1.next, val,diff);
		sum+=l1.key;
		result.add(sum%10);
		//System.out.print(sum%10);
		return sum/10;
	}
	
	public int getSum(Node l1,Node l2){
		int val;
		if(l1.next==null&&l2.next==null){
			//System.out.print((l1.key+l2.key)%10);
			result.add((l1.key+l2.key)%10);
			return (l1.key+l2.key)/10;
		}
		val = getSum(l1.next, l2.next);
		val+=l1.key+l2.key;
		//System.out.print(val%10);
		result.add(val%10);
		return val/10;
	}
	
	public void add(){
		
		Node list1;
		Node list2;
		
		list1 = new Node(1);
		list1.next = new Node(1);
		list1.next.next = new Node(1);
		list1.next.next.next = new Node(1);
		
		list2 = new Node(1);
		list2.next = new Node(1);
		list2.next.next = new Node(1);
		list2.next.next.next = new Node(1);
		result.add(findSum(list1, list2));
		Collections.reverse(result);
		
		for(int i=0;i<result.size();i++){
			System.out.print(result.get(i));
		}
	}
	
	public static void main(String args[]){
		
		LinkedListAddition obj = new LinkedListAddition();
		obj.add();
		
		int a[] = {};
	}
	
}
