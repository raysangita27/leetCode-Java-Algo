/*
Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example 1:

Input: nums = [1, 5, 1, 1, 6, 4]
Output: One possible answer is [1, 4, 1, 5, 1, 6].
Example 2:

Input: nums = [1, 3, 2, 2, 3, 1]
Output: One possible answer is [2, 3, 1, 3, 1, 2].
Note:
You may assume all input has valid answer.

Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?
*/

class Solution {
    public void wiggleSort(int[] nums) {
        int len = nums.length;
        if(len == 0)
            return ;
        int[] value = Arrays.copyOf(nums, len);
        Arrays.sort(value);
        int  index = len-1;
        for(int i = 1;i<len ; i+=2)
            nums[i] = value[index--];
        for(int i = 0;i<len ; i+=2)
            nums[i] = value[index--] ;                
    }
}
