/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
*/

class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len == 0)
            return 0;
        int[] LIS = new int[len];
        Arrays.fill(LIS,1);
        for(int i = 1; i<len; i++)
        {
            for(int j = 0; j<i ; j++)
            {
                if(nums[j] <nums[i])
                    LIS[i] = Math.max(LIS[i], LIS[j] +1);
            }
        }
        int max = 0;
        for(int i = 0; i<len; i++)
            max = Math.max(max, LIS[i]);
        return max;
    }
}
