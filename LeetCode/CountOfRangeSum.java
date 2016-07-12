package leetcode;

public class CountOfRangeSum {

    public int countRangeSum(int[] nums, int lower, int upper) {

    	int sum=0;
    	int count=0;
    	int val;
    	
    	if(upper<lower)return count;
    	
    	
    	for(int i=0;i<nums.length;i++){
    	    sum=nums[i];
    	    if(nums[i]>=lower && nums[i]<=upper){
    	        count++;
    	    }
    	    for(int j=i+1;j<nums.length;j++){
    	        sum+=nums[j];
    	        if(sum>=lower&&sum<=upper)count++;
    	    }
    	}
    	return count;
    
    }
    
    public static void main(String[] args) {
		
    	CountOfRangeSum obj = new CountOfRangeSum();
		
		int nums1[] = {Integer.MAX_VALUE,Integer.MIN_VALUE,-1,0};
		System.out.println(obj.countRangeSum(nums1, -1, 0));
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
	}
}
