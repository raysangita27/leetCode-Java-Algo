/*
Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

Note:
The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.

Example 1:

Input: nums = [1, -1, 5, -2, 3], k = 3
Output: 4 
Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
Example 2:

Input: nums = [-2, -1, 2, 1], k = 1
Output: 2 
Explanation: The subarray [-1, 2] sums to 1 and is the longest.
Follow Up:
Can you do it in O(n) time?
*/

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int len = nums.length;
        if(len == 0)
            return 0;
        int maxLen =0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i = 0; i< len; i++)
        {
            sum += nums[i];
            if(sum == k)
                maxLen = i+1;
            else if(map.containsKey(sum -k))
                maxLen = Math.max(maxLen , i- map.get(sum -k));
            if(!map.containsKey(sum))
                map.put(sum, i);
        }
        return maxLen;
    }
}

