import java.util.ArrayList;


public class SetOfStacks {

	int CAPACITY = 5;
	int top = -1;
	int index = 0;
	ArrayList<Integer[]>list = new ArrayList<>();
	
	
	public void push(int element){
		
		Integer[] i;
		
		// Called first time when stack is initialized
		if(top==-1){
		    
			i = new Integer[CAPACITY];
			list.add(index, i);
		}
		
		if(top==(CAPACITY-1)){
			index+=1;
		    i = new Integer[CAPACITY];
		    list.add(index, i);
		    top=-1;
		}
	    list.get(index)[++top]=element;
	}
	
	public int pop(){
		
		if(top==-1&&index==0){
			System.out.println("Stack is empty");
			return -1;
		}
		if(top==-1&&index>0){
			index-=1;
			top=CAPACITY-1;
			System.out.println("Previous Stack");
		}
		
		return list.get(index)[top--];
	}
	
	public static void main(String args[]){
		
		
		SetOfStacks setStacks = new SetOfStacks();
		setStacks.push(1);
		setStacks.push(2);
		setStacks.push(3);
		setStacks.push(4);
		setStacks.push(5);
		setStacks.push(6);
		setStacks.push(7);
		System.out.println("Element deleted is"+setStacks.pop());
		System.out.println("Element deleted is"+setStacks.pop());
		System.out.println("Element deleted is"+setStacks.pop());
		System.out.println("Element deleted is"+setStacks.pop());
		System.out.println("Element deleted is"+setStacks.pop());
		System.out.println("Element deleted is"+setStacks.pop());
		System.out.println("Element deleted is"+setStacks.pop());
		
	}
	
}
