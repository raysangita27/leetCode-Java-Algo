/*
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:

Input:nums = [1,1,1], k = 2
Output: 2
 

Constraints:

The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;
        int sum = 0;
        for(int i = 0; i< len; i++)
        {
            sum += nums[i];
            if(map.containsKey(sum-k))
                count+= map.get(sum-k);
             
            if(map.containsKey(sum))
                map.put(sum, map.get(sum)+1);
            else
                map.put(sum, 1);
        }
        return count;
    }
}
