/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
Example 2:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 3:

Input: nums = [1,2,3]
Output: 3
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 1000
*/

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return Math.max(nums[0], nums[1]);
        
        int maxIncludeStart = findRobAmt(nums, 0, nums.length-2); //either we can take 1st item or last item . so here we are calculating for item 1 to 2nd last
        int maxIncludeLast = findRobAmt(nums, 1, nums.length-1); // here we are calculating for 2 to last item
        return Math.max(maxIncludeLast, maxIncludeStart);
        
    }
    public int findRobAmt(int[] nums, int start, int end)
    {
        int inc = nums[start];
        int exc = Math.max(nums[start], nums[start+1]);
        for(int i = start+2; i <= end; i++)
        {
            int newExc = Math.max(inc + nums[i], exc);
            inc = exc;
            exc = newExc;
        }
        return Math.max(inc, exc);
    }
}

