/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Note: The algorithm should run in linear time and in O(1) space.

Example 1:

Input: [3,2,3]
Output: [3]
Example 2:

Input: [1,1,1,3,3,2,2,2]
Output: [1,2]
*/

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int len = nums.length;
        if(len == 0)
            return result;
        Arrays.sort(nums);
        int count = 1;
        int key = nums[0];
        for(int i = 1; i< len; i++)
        {
            if(nums[i] == key)
                count++;
            else if(count > len/3)
            {
                result.add(key);
                key = nums[i];
                count = 1;
            }
            else
            {
                key = nums[i];
                count = 1;
            }
                
        }
        if(count > len/3)
        {
                result.add(key);
        }
        return result;
        
    }
}
