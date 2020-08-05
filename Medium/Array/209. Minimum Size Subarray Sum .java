/*
Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example: 

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
Follow up:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 
*/

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        if(len == 0 || s == 0)
            return 0;
        int start = 0;
        int end = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        while(end < len)
        {
            sum += nums[end];
            while(sum >= s)
            {
                if(minLen > end -start +1)
                {
                    minLen = end - start +1;
                }
                sum = sum-nums[start];
                start++;
            }
            end ++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen ;
    }
}
