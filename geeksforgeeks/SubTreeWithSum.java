package geeksforgeeks;

public class SubTreeWithSum{

  class Node{
   int key;
   Node left;
   Node right;

   public Node(int key){
     this.key=key;
   }
 }

 Node root;

 public void buildTree(){

   root = new Node(8);
   root.left = new Node(5);
   root.right = new Node(4);

   root.left.left = new Node(9);
   root.left.right = new Node(7);
   root.left.right.left = new Node(1);
   root.left.right.right = new Node(12);
   root.left.right.right.left = new Node(2);

   root.right.right = new Node(11);
   root.right.right.left = new Node(3);
 }

 public int checkSum(Node root){

   if(root==null)return 0;

   int left = checkSum(root.left);
   int right = checkSum(root.right);

   if(left==Integer.MAX_VALUE||right==Integer.MAX_VALUE){
     return Integer.MAX_VALUE;
   }

   if(left+right+root.key==15){
     System.out.println("Yes");
     return Integer.MAX_VALUE;
   }

   return left+right+root.key;
 }

 public void isSum(Node root){

   if(checkSum(root)!=Integer.MAX_VALUE){
     System.out.println("No");
   }

 }

   public static void main(String[] args) {
     SubTreeWithSum sub = new SubTreeWithSum();
     sub.buildTree();
     sub.isSum(sub.root);

   }
}
