/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
*/
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0)
            return -1;
        return binarySearch(nums, 0, nums.length-1, target);
    }
    public int binarySearch(int[] nums, int l, int r, int key)
    {
        if( l > r)
            return -1;
        int mid = (l + r)/2;
        if(nums[mid] == key)
            return mid;
        if(nums[l] <= nums[mid])
        {
            if(key >= nums[l]  && nums[mid]>= key)
                return binarySearch(nums, l, mid-1, key);
            else
                return binarySearch(nums, mid+1, r, key);
        }
            if(nums[mid] <= key && key <= nums[r])
                return binarySearch(nums, mid+1, r, key);
    
                return binarySearch(nums, l, mid-1, key);
        
    }
}
