/*
Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

 

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 100
*/
class Solution {
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0)
            return false;
        
        int sum = 0;
        for(int n : nums)
            sum += n;
        
        if(sum % 2 != 0)
            return false;
        
        int targetSum = sum /2;

        boolean[][] dp = new boolean[nums.length+1][targetSum+1];
        dp[0][0] = true;
        for(int i = 1; i <= nums.length; i++)
        {
            int cur = nums[i-1];
            for(int j = 1; j <= targetSum; j++)
            {
                if(j >= cur)
                {
                    dp[i][j] =   dp[i-1][j] || dp[i-1][j-cur];
                }
                else
                    dp[i][j] = dp[i-1][j] ;
            }
        }
        return dp[nums.length][targetSum];
    }
}
