/*
Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,3,2]
Output: 3
Example 2:

Input: [0,1,0,1,0,1,99]
Output: 99
*/
class Solution {
    public int singleNumber(int[] nums) {
        int freqOne = 0;
        int freqTwo = 0;
        for(int n : nums)
        {
            freqOne = ~ freqTwo &(freqOne ^ n);
            freqTwo = ~ freqOne &(freqTwo ^ n);
        }
        return freqOne;
    }
}


/********bit manipulation*************

    class Solution {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;
        int target = 0;
        for(int index = 0; index < 32; index++)
        {
            int bitSum = 0;
            for(int num : nums)
            {
                bitSum += (num >> index) & 1;
            }
            int targetbit = bitSum % 3;
            target = targetbit << index | target;
        }    
        return target;
    }
}
