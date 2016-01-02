import java.util.LinkedList;


public class AnimalShelter {

	static int TIME=0;
	
	private class Node{
		int animal; // 0 for dog and 1 for cat
		int time;
		Node next;
	}
	
	LinkedList<Node>[] queue = new LinkedList[2];
	
	public void enqueue(int anim){
		
		LinkedList<Node>list = queue[anim];
		
		if(list==null){
			list = new LinkedList<Node>();
			queue[anim]=list;
		}
		Node node = new Node();
		node.animal = anim;
		node.time = ++TIME;
		list.add(node);
	}
	
	public Node dequeueAny(){
		
		if(queue[0].isEmpty() && !queue[1].isEmpty()){
			return queue[1].getFirst();
		}
		if(!queue[0].isEmpty() && queue[1].isEmpty()){
			return queue[0].getFirst();
		}
		if(queue[0].isEmpty() && queue[1].isEmpty()){
			System.out.println("Queue Empty");
			return null;
		}
		
		return (queue[0].peek().time<queue[1].peek().time)?queue[0].pollFirst():queue[1].pollFirst();
	}
	
    public Node dequeueCat(){
    	return (!queue[1].isEmpty())?queue[1].pollFirst():null;
   	}
    
    public Node dequeueDog(){
    	return (!queue[0].isEmpty())?queue[0].pollFirst():null;
	}
	
	public static void main(String args[]){
		
		AnimalShelter animShelter = new AnimalShelter();
		Node item;
		animShelter.enqueue(0);
		animShelter.enqueue(1);
		animShelter.enqueue(1);
		animShelter.enqueue(0);
		
		item = animShelter.dequeueAny();
		System.out.println((item!=null)?item.animal:"Queue Empty");
		item = animShelter.dequeueAny();
		System.out.println((item!=null)?item.animal:"Queue Empty");
		item = animShelter.dequeueCat();
		System.out.println((item!=null)?item.animal:"Queue Empty");
		animShelter.enqueue(0);
		animShelter.enqueue(0);
	
	}
}
