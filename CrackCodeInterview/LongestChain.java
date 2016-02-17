
public class LongestChain {

	int max = Integer.MIN_VALUE;
	
	private class Chain{
		int leftChain;
		int rightChain;
		
		public Chain(int leftChain,int rightChain){
			this.leftChain = leftChain;
			this.rightChain = rightChain;
		}
	}
	
	public Chain findLongestChain(Node root){
		if(root==null)return new Chain(0, 0);
		Chain chain;
		int left,right,chainLength;
		left = findLongestChain(root.left).leftChain;
		right = findLongestChain(root.right).rightChain;
		chainLength = (left==0&&right==0)?0:left+right+1;
		if(chainLength>max)max = chainLength;
		return new Chain(left+1, right+1);
	}
	
	public static void main(String args[]){
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		LongestChain longChain = new LongestChain();
		longChain.findLongestChain(root);
		System.out.println("Maximum chain length "+longChain.max);
	}

}
