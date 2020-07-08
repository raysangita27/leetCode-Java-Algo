/*
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

 

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 

Constraints:

3 <= nums.length <= 10^3
-10^3 <= nums[i] <= 10^3
-10^4 <= target <= 10^4
*/

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int result = 0;
        for(int i = 0; i<nums.length-2; i++)
        {
            int j = i+1;
            int k = nums.length-1;
            while(j < k)
            {
                int sum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(sum - target);
                if(diff <min ){
                    min = diff;
                    result = sum;
                }
                else if(sum > target)
                    k--;
                else if(sum <= target)
                    j++;
            }
        }
        
        return result;    
    }
}
