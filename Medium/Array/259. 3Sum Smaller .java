/*
Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

Example:

Input: nums = [-2,0,1,3], and target = 2
Output: 2 
Explanation: Because there are two triplets which sums are less than 2:
             [-2,0,1]
             [-2,0,3]
Follow up: Could you solve it in O(n2) runtime?
*/
class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int len = nums.length;
        if(len == 0)
            return 0;
        int res = 0;
        Arrays.sort(nums);
        for(int i = 0; i< len -2; i++)
        {
            res += findsumLessthanTarget(nums, i+1, target - nums[i]);
        }
        return res;
    }
    int findsumLessthanTarget(int[] nums, int startInd, int target )
    {
        int res = 0;
        int left = startInd;
        int right = nums.length-1;
        while( left < right)
        {
            if(nums[left] + nums[right] >= target)
                right--;
            else if(nums[left] + nums[right] < target)
            {
                res += right -left ;
                left++;
            }   
        }
        return res;
    }
}
