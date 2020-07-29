/*
Given an array nums sorted in non-decreasing order, and a number target, return True if and only if target is a majority element.

A majority element is an element that appears more than N/2 times in an array of length N.

 

Example 1:

Input: nums = [2,4,5,5,5,5,5,6,6], target = 5
Output: true
Explanation: 
The value 5 appears 5 times and the length of the array is 9.
Thus, 5 is a majority element because 5 > 9/2 is true.
Example 2:

Input: nums = [10,100,101,101], target = 101
Output: false
Explanation: 
The value 101 appears 2 times and the length of the array is 4.
Thus, 101 is not a majority element because 2 > 4/2 is false.
 

Constraints:

1 <= nums.length <= 1000
1 <= nums[i] <= 10^9
1 <= target <= 10^9
*/

class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int len = nums.length;
        int index = findTarget(nums, 0, len-1, target);
        if(index == -1)
            return false;
        if(len == 1)
            return true;
        int i = index-1 ;
        int j = index+1 ;
        int count = 1;
        while(i >0 && nums[i] == target)
        {
            i--;
            count++;
        }
        while(j < len && nums[j] == target)
        {
            j++;
            count++;
        }
        
        return (count)>len/2 ? true : false;
            
    }
    
    int findTarget(int[] nums, int left, int right, int target)
    {
        if(left > right)
            return -1;
        int mid = (left + right)/2;
        if(nums[mid] == target)
            return mid;
        if(nums[mid] < target)
            return findTarget(nums, mid+1, right, target);
        else
            return findTarget(nums, left, mid-1, target);
    }
}
