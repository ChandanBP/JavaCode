package Trees;

import java.util.Stack;

public class IsPreOrderOfBST {
   
	
	public boolean isPreOrderTraversal(int a[],int low,int high){
		
		int root = a[low];
		int j=low;
		boolean val1=true,val2,val3;
		
		if(low>high){
			return true;
		}
		
		for (int i = low; i <=high; i++) {
			if(a[i]>root){
				break;
			}
			j++;
		}
		
		for(int i=j+1;i<=high;i++){
			if(a[i]<root){
				val1 = false;
			}
		}
		
		val2 = isPreOrderTraversal(a, low+1, j-1);
		val3 = isPreOrderTraversal(a, j+1, high-1);
		
		return val1&&val2&&val3;
	}
	
	public boolean isPreOrderOfBST(int a[]){
		
		return isPreOrderTraversal(a,0,a.length-1);
	}
	
	public boolean optimalSolution(int a[]){
		
		Stack<Integer> s = new Stack<Integer>();
		 
        int root = Integer.MIN_VALUE;
 
        for (int i = 0; i < a.length; i++) {
            if (a[i] < root) {
                return false;
            }
 
            while (!s.empty() && s.peek() < a[i]) {
                root = s.peek();
                s.pop();
            }
 
            s.push(a[i]);
        }
        return true;
	}
	
	
	public static void main(String args[]){
		
		int a[] = {40, 30, 35, 20, 80, 100};
		
		IsPreOrderOfBST isPreOrder = new IsPreOrderOfBST();
		//System.out.println(isPreOrder.isPreOrderOfBST(a));
		isPreOrder.optimalSolution(a);
	}
	
}
