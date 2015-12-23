
public class PrintPath {

	int pathSumVal = 23;
	
	public void printPath(Node node,int sum,String path){
		
		if(node==null){
			return;
		}
		
		path = path + " "+node.key;
		if((node.key+sum)==pathSumVal)
			System.out.println(path);
		
		printPath(node.left, node.key+sum,path);
		printPath(node.right, node.key+sum,path);
		printPath(node.left, 0,"");
		printPath(node.right, 0,"");
	}
	
	public static void main(String[] args) {
		
		
		Node root = new Node(10);
		root.left        = new Node(8);
		root.right       = new Node(2);
		root.left.left  = new Node(3);
		root.left.right = new Node(5);
		root.right.left = new Node(2);
		
		PrintPath obj = new PrintPath();
		obj.printPath(root,0,"");
	}
	
}
	
