// Minimum number of swaps required to convert binary tree to BST

package geeksforgeeks;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class BinaryToBST {
	
	int res[];
	int index;
	
	class Pair{
		int pos;
		int ele;
	}
	
	public BinaryToBST(int length){
		res = new int[length];
		index=0;
	}
	
	public void inorder(int arr[],int currNode){
		
		if(arr==null)return;
		if(arr.length==0)return;
		if(currNode<0 || currNode>=arr.length)return;
		
		inorder(arr, 2*currNode+1);
		res[index++]=arr[currNode];
		inorder(arr, 2*currNode+2);
	}
	
	public int minSwaps(){
		
		List<Pair>pairs = new LinkedList<Pair>();
		
		for(int i=0;i<res.length;i++){
			Pair pair = new Pair();
			pair.ele = res[i];
			pair.pos=i;
			pairs.add(pair);
		}
		
		Arrays.sort(res);
		
		Collections.sort(pairs,new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.ele-o2.ele;
			}
		});
		
		int visited[] = new int[res.length];
		int ans=0;
		for(int i=0;i<res.length;i++){
			
			if(visited[i]==0 || pairs.get(i).pos==i){
				continue;
			}
			
			int cycleSize = 0;
			int j=i;
			while (visited[j]==0)
            {
				visited[j] = 1;
 
                // move to next node
                j = pairs.get(j).pos;
                cycleSize++;
            }
 
            // Update answer by adding current cycle.
            ans += (cycleSize - 1);
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		
		int arr[] = {5,6,7,8,9,10,11};
		BinaryToBST binToBst = new BinaryToBST(arr.length);
		
		binToBst.inorder(arr,0);
		System.out.println(binToBst.minSwaps());
	}
}
