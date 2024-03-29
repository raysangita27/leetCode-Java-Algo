/*
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Example 1:

Input: [1,3,4,2,2]
Output: 2
Example 2:

Input: [3,1,3,4,2]
Output: 3
Note:

You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
*/
class Solution {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        if(len == 0)
            return -1;
        for(int i = 0; i< len ; i++)
        {
            nums[i] = nums[i]-1;
        }
        for(int i = 0; i< len ; i++)
        {
            int index = nums[i] % len;
            nums[index] += len;
        }
        for(int i = 0; i< len ; i++)
        {
           if(nums[i]/len > 1)
               return i+1;
        }
        return -1;
    }
}

/**************************************/
class Solution {
    public int findDuplicate(int[] nums) {
        int duplicate = -1;
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.abs(nums[i]);
            if (nums[cur] < 0) {
                duplicate = cur;
                break;
            }
            nums[cur] *= -1;
        }
        
        // Restore numbers
        for (int i = 0; i < nums.length; i++)
            nums[i] = Math.abs(nums[i]);

        return duplicate;
    }

}
