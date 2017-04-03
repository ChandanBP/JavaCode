package geeksforgeeks;

import java.util.HashMap;

// to obtain maximum sum such that no two nodes are adjacent
public class MaxSum{

  class Node{
   int key;
   Node left;
   Node right;

   public Node(int key){
     this.key=key;
   }
 }

 Node root;
 HashMap<Node,Integer>map=new HashMap<>();

 public void buildTree(){

   root = new Node(1);
   root.left = new Node(2);
   root.right = new Node(3);

   root.left.left = new Node(5);

   root.right.left = new Node(4);
   root.right.right = new Node(5);
 }

  public int maxSum(Node root){

    if(root==null)return 0;
    if(root.left==null && root.right==null)return root.key;
    if(map.containsKey(root))return map.get(root);

    // for grandchildren including self
    int leftGrandChild=0;
    if(root.left!=null){
    	leftGrandChild = maxSum(root.left.left)+maxSum(root.left.right);
    }
    int rightGrandChild=0;
    if(root.right!=null){
    	rightGrandChild = maxSum(root.right.left)+maxSum(root.right.right);
    }
    
    // for children excluding self
    int leftChild = maxSum(root.left);
    int rightChild = maxSum(root.right);

    int max = Math.max(leftChild+rightChild,leftGrandChild+rightGrandChild+root.key);
    map.put(root,max);

    return max;
  }

  public static void main(String[] args) {
      MaxSum max = new MaxSum();
      max.buildTree();
      System.out.println(max.maxSum(max.root));
  }
}
