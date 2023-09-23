/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:

Input: [3,0,1]
Output: 2
Example 2:

Input: [9,6,4,2,3,5,7,0,1]
Output: 8
Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
*/
class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        if(len == 0)
            return -1;
        int x1 = nums[0];
        int x2 = 1;
        for(int i = 1; i<len; i++)
        {
            x1 = x1 ^ nums[i];
        }
        
       for(int i = 2; i<=len; i++)
           x2 = x2^i;
        
        return x1 ^ x2;
    }
}
/**********************************using sum of n consecutive numbers**********************************/
public int missingNumber(int[] nums) {
    
        if(nums == null)
            return 0;
        int len = nums.length;
        int sum = (len*(len+1))/2;
        for(int n : nums)
            sum -= n;
        return sum;
}
