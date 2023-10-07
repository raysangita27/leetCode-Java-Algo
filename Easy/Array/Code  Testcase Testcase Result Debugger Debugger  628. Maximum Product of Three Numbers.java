/*
Given an integer array nums, find three numbers whose product is maximum and return the maximum product.

 

Example 1:

Input: nums = [1,2,3]
Output: 6
Example 2:

Input: nums = [1,2,3,4]
Output: 24
Example 3:

Input: nums = [-1,-2,-3]
Output: -6
 

Constraints:

3 <= nums.length <= 104
-1000 <= nums[i] <= 1000

*/

class Solution {
    public int maximumProduct(int[] nums) {
        if(nums  == null || nums.length < 3)
            return 0;
        
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] >= max1)
            {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            }
            else if(nums[i] >= max2 && nums[i] < max1)
            {
                max3 = max2;
                max2 = nums[i];
            }
            else if(nums[i] >= max3 && nums[i] < max2)
                max3 = nums[i];
            if(nums[i] <= min1)
            {
                min2 = min1;
                min1 = nums[i];
            }
            else if(nums[i] > min1 && nums[i] <= min2)
            {
                min2 = nums[i];
            }
        }
        return Math.max((max1 * max2* max3) , (max1 * min1* min2));

    }
}

/********* Time complexity O(n) as traversing entire array only once*********
