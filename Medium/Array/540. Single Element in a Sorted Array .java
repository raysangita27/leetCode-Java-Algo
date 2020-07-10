/*
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.

Follow up: Your solution should run in O(log n) time and O(1) space.

 

Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10
 

Constraints:

1 <= nums.length <= 10^5
0 <= nums[i] <= 10^5
*/
class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 0)
            return -1;
        return binarySearchEle(nums, 0, nums.length-1,nums.length-1);
    }
    int binarySearchEle(int[] nums, int l, int r, int n)
    {
        if( l> r)
            return -1;
        int mid = (l+r)/2;
        if((mid == 0 || nums[mid-1]<nums[mid])&&(mid == n ||nums[mid]<nums[mid+1]) )
            return nums[mid];
        int left = binarySearchEle(nums, l, mid-1, n);
        if(left == -1)
            return binarySearchEle(nums, mid+1, r, n);
        else
            return left;
    }
}
