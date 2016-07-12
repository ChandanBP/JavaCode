package leetcode;

public class IncreasingTripletSubsequence {

  public static boolean increasingTriplet(int[] nums) {
        
        int length = nums.length;
        
        if(length<3)return false;
        
        int n = nums.length;
        int max = n-1; //Index of maximum element from right side
        int min = 0; //Index of minimum element from left side
        int i;
        int[] smaller = new int[n];
        smaller[0] = -1;  // first entry will always be -1
        for (i = 1; i < n; i++)
        {
            if (nums[i] <= nums[min])
            {
                min = i;
                smaller[i] = -1;
            }
            else
                smaller[i] = min;
        }
        
        int[] greater = new int[n];
        greater[n-1] = -1;  // last entry will always be -1
        for (i = n-2; i >= 0; i--)
        {
            if (nums[i] >= nums[max])
            {
                max = i;
                greater[i] = -1;
            }
            else
                greater[i] = max;
        }
        
        for (int j = 0; j < greater.length; j++) {
        	if(smaller[j]!=-1 && greater[j]!=-1){
				//System.out.println(nums[smaller[j]]+" "+nums[j]+" "+smaller[greater[j]]);
				return true;
			}
		}
        
        return false;
    }
	
	public static void main(String[] args) {
		
		int nums1[] = {12, 11, 10, 5, 6, 2, 30};
		int nums2[] = {1,2,3,4,5};
		int nums3[] = {5,4,3,2,1};
		int nums4[] = {1,2,3,6,5};
		System.out.println(increasingTriplet(nums1));
		System.out.println(increasingTriplet(nums2));
		System.out.println(increasingTriplet(nums3));
		System.out.println(increasingTriplet(nums4));
	}
	
}
