
public class BSTFromSortedArray {

   int A[] = {1,2,3,4,5,6,7,8,9,10};
	
   
   public Node constructBST(int A[],int low,int high){ 
	  
	   int mid;

	   if(low>high)return null;
	   mid = (low+high)/2;
	   Node node = new Node();
	   node.key = A[mid];
		   
	   node.left = constructBST(A, low, mid-1);
	   node.right = constructBST(A, mid+1, high);
		   
	   return node;
   }
	
   // To check if its BST
   public void printBST(Node node){
	   
	   if(node == null)return;
	   printBST(node.left);
	   System.out.println(node.key);
	   printBST(node.right);
	   
   }
	
   public static void main(String[] args) {
	
	   BSTFromSortedArray obj = new BSTFromSortedArray();
	   Node node = obj.constructBST(obj.A,0, obj.A.length-1);
	   obj.printBST(node);
   }
	
}
