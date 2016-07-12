package leetcode;

public class LIS {

public static int lengthOfLIS(int[] nums) {
        
	    int dp[] = new int[nums.length];

	    for (int i = 0; i < dp.length; i++) {
			dp[i] = 1;
		}
	    
	    for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if(nums[i]>nums[j] && dp[i]<(dp[j]+1)){
					dp[i] = dp[j]+1;
				}
			}
		}
        
	    int max = Integer.MIN_VALUE;
	    for (int i = 0; i < dp.length; i++) {
			max = Math.max(max, dp[i]);
		}
	    
        return max;
    }

public static void main(String[] args) {
	
	int nums1[] = {10, 22, 9, 33, 21, 50, 41, 60};
	System.out.println(lengthOfLIS(nums1));
}
}
