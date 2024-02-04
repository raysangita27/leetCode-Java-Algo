/*
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

*/

class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        int pMin = nums[0];
        int pMax = nums[0];
        for(int i = 1; i< len; i++)
        {
            int cMin = Math.min(Math.min(pMin * nums[i], pMax * nums[i] ), nums[i] );
            int cMax = Math.max(Math.max(pMin * nums[i], pMax * nums[i] ), nums[i] );
            max = Math.max(cMax, max);
            pMax = cMax;
            pMin = cMin;
        }
        return max;    
    }
}

/***************************************/
class Solution {
    public int maxProduct(int[] nums) {
        int product=Integer.MIN_VALUE;
        int lp=1;
        for(int i=0;i<nums.length;i++){
            lp*=nums[i];
            product=Math.max(lp,product); //calculating product from left side subarray.
            if(lp==0){
                lp=1;
            }
        }
        int rp=1;
        for(int i=nums.length-1;i>=0;i--){
            rp*=nums[i];
            product=Math.max(rp,product); //calculating product from right side subarray.
            if(rp==0){
                rp=1;
            }
        }
        return product;
    }
}
