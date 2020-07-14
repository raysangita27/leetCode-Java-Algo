/*
Your are given an array of positive integers nums.

Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.

Example 1:
Input: nums = [10, 5, 2, 6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
Note:

0 < nums.length <= 50000.
0 < nums[i] < 1000.
0 <= k < 10^6.
*/

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int len = nums.length;
        int start = 0; 
        int end = 0;
        int product = 1;
        int res = 0;
        for(end = 0; end< len ; end++)
        {
            product *= nums[end];
            while(start < end && product >= k)
            {
                product = product/nums[start++];
            }
            if(product < k)
            {
                int window = end - start +1;
                res += window;
               
            }
        }
        return res;
    }
}
