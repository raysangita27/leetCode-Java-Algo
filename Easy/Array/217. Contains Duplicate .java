/*
Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

Example 1:

Input: [1,2,3,1]
Output: true
Example 2:

Input: [1,2,3,4]
Output: false
Example 3:

Input: [1,1,1,3,3,4,3,2,4,2]
Output: true
*/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length == 0)
            return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++)
        {
            if(map.containsKey(nums[i]) )
            {
                int count = map.get(nums[i])+1;
                if(count >= 2)
                    return true;
                else
                    map.put(nums[i],count);
            }
            else
            {
                map.put(nums[i],1);
            }
        }
        return false;
    }
}
