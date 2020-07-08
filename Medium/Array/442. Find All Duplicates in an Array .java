/*
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
*/
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if(nums.length == 0)
            return result;
        int len =  nums.length;
        for(int i = 0; i < len; i++)
            nums[i] -=1;
        for(int i = 0; i < len; i++)
        {
            int index = nums[i] % len;
            nums[index] += len;
        }
        
        for(int i = 0; i < len; i++)
        {
            if(nums[i]/len == 2)
                result.add(i+1);
        }
        return result;
    }
}
