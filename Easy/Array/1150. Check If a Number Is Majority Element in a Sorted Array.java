/*
Given an integer array nums sorted in non-decreasing order and an integer target, return true if target is a majority element, or false otherwise.

A majority element in an array nums is an element that appears more than nums.length / 2 times in the array.

 

Example 1:

Input: nums = [2,4,5,5,5,5,5,6,6], target = 5
Output: true
Explanation: The value 5 appears 5 times and the length of the array is 9.
Thus, 5 is a majority element because 5 > 9/2 is true.
Example 2:

Input: nums = [10,100,101,101], target = 101
Output: false
Explanation: The value 101 appears 2 times and the length of the array is 4.
Thus, 101 is not a majority element because 2 > 4/2 is false.
 

Constraints:

1 <= nums.length <= 1000
1 <= nums[i], target <= 109
nums is sorted in non-decreasing order.

*/

class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return false;
        int n = nums.length;
        int ind = findTarget(nums, 0, n-1, target);
        if(ind == -1)
            return false;
        int s = ind;
        int e = ind;
        while( s >= 0 && nums[s] == target)
            s--;
        while( e < nums.length && nums[e] == target)
            e++;
        int count = e-1 - (s+1)+1;
        return count  >  n /2;
        
    }
    public int findTarget(int[] nums, int l, int r, int target)
    {
        if(l > r)
            return -1;
        int mid = (l + r)/2;
        if(nums[mid] == target)
            return mid;
        if(target< nums[mid])
            return findTarget(nums, l, mid-1, target);
        else 
            return findTarget(nums, mid+1, r, target);
    }
}
