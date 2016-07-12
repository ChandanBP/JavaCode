package leetcode;
public class HouseRobber {

	TreeNode root;
	class TreeNode {
	      
	      int val;
	      int maxVal;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { 
	          val = x; 
	          maxVal = x;
	      }
	      
	  }
	
   public int rob(TreeNode root) {
        
        if(root==null)return 0;
        if(root.left==null && root.right==null)return root.maxVal;
        
        int leftIncl=0,rightIncl=0;
        
        // Excluding the root
        int exclRoot = rob(root.left)+rob(root.right);
        
        // Including the root
        if(root.left!=null){
            leftIncl = rob(root.left.left)+rob(root.left.right);
        }
        if(root.right!=null){
            rightIncl = rob(root.right.left)+rob(root.right.right);
        }
        root.maxVal = Math.max(exclRoot,leftIncl+rightIncl+root.val);
        
        return root.maxVal;
    }
   
   public void buildTree(){
		
	root     	= new TreeNode(3);
   	root.left            	= new TreeNode(2);
   	root.left.right     	= new TreeNode(3);
   	root.right           	= new TreeNode(3);
   	root.right.right    	= new TreeNode(1);
	System.out.println(rob(root));
	}
   
   public static void main(String[] args) {
	
	   HouseRobber obj = new HouseRobber();
	   obj.buildTree();
	   
   }
	
}
