/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2] 
Output: 1
Example 2:

Input: [4,5,6,7,0,1,2]
Output: 0
*/

class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 0)
            return -1;
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return  Math.min(nums[1], nums[0]);
        int left = 0;
        int right = nums.length -1;
        if(nums[0] < nums[right])
            return nums[0];
        while(left <= right)
        {
            int mid = left + (right - left)/2;
            if(nums[mid + 1] < nums[mid])
                return nums[mid +1];
            if(nums[mid -1] > nums[mid])
                return nums[mid];
            else if(nums[0] < nums[mid])
                left = mid + 1;
            else
                right = mid -1;
                
        }
        return -1;
    }
}
