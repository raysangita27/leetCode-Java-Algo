/*
A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5 
Explanation: Your function can return either index number 1 where the peak element is 2, 
             or index number 5 where the peak element is 6.
Follow up: Your solution should be in logarithmic complexity.
*/

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 0)
            return -1;
        return searchPeakHelper(nums, 0, n-1, n);
        
    }
    int searchPeakHelper(int[] nums, int l, int r, int n)
    {
        if(l > r)
            return -1;
        int mid =l+ (r-l)/2;
        if(( mid== 0 || nums[mid-1]<= nums[mid])&& (mid== n-1 || nums[mid+1] <= nums[mid]))
            return mid;
        if( mid > 0 && nums[mid-1] > nums[mid])
            return searchPeakHelper(nums, l, mid-1, n);
            
        else 
            return searchPeakHelper(nums, mid+1, r, n);
    }
}
