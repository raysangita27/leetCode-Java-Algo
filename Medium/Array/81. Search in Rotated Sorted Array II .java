/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
Follow up:

This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
Would this affect the run-time complexity? How and why?
*/
class Solution {
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        if(len == 0)
            return false;
        int j = 0;
        // remove duplicate elmenets
        for(int i = 0; i < len-1; i++)
        {
            if(nums[i] != nums[i+1])
                nums[j++] = nums[i];
        }
        nums[j++]= nums[len-1];
        if(j == 0)
            return false;
        if(j == 1)
            return nums[0] == target;
        System.out.println(j);
        return binarySearch(nums, 0, j-1, target);
    }
    boolean binarySearch(int[] nums, int l, int r, int target)
    {
        if(l > r)
            return false;
        int mid =l + ( r-l)/2;
        if(nums[mid] == target)
            return true;
        if(nums[l] <= nums[mid])
        {
            if(nums[l] <= target && nums[mid] >= target)
                return binarySearch(nums,l,mid-1,target);
            else
                return binarySearch(nums,mid+1,r, target);
        }
        if(target >= nums[mid] && target <= nums[r])
             return binarySearch(nums,mid+1,r, target);
        else
             return binarySearch(nums,l,mid-1,target);

    }
}
