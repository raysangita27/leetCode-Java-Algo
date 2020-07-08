/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
nums is a non decreasing array.
-10^9 <= target <= 10^9
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if(len == 0)
            return new int[]{-1,-1};
        int first = findFirstPos(nums, target, 0, len-1,  len-1);
        if(first == -1)
            return new int [] {-1, -1};
        int last = findLastPos(nums, target, 0, len-1,  len-1);
        return new int[]{first,last};
    }
    int findLastPos(int[] nums, int target, int l, int r, int n)
    {
        if(l > r)
            return -1;
        int mid = (l + r)/2;
        if((mid == n || nums[mid+1]> nums[mid]) && ( nums[mid] == target ))
            return mid;
        if(target < nums[mid])
            return findLastPos(nums, target, l, mid-1, n);
        else
            return findLastPos(nums, target, mid+1, r, n);
            
    }
    int findFirstPos(int[] nums, int target, int l, int r, int n)
    {
        if(l > r)
            return -1;
        int mid = (l + r)/2;
        if((mid == 0 || nums[mid-1]< nums[mid]) && ( nums[mid] == target ))
            return mid;
        if(target > nums[mid])
            return findFirstPos(nums, target, mid+1, r, n);
        else
            return findFirstPos(nums, target, l, mid-1, n);
            
    }
}
