/*
Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3
Example 2:

Input: [3,4,-1,1]
Output: 2
Example 3:

Input: [7,8,9,11,12]
Output: 1
Note:

Your algorithm should run in O(n) time and uses constant extra space.
*/
class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        if(len == 0)
            return 1;
        HashSet<Integer> set = new HashSet<>();
        for(int a : nums)
            set.add(a);
        for(int i = 1; i<=len; i++)
        {
            if(!set.contains(i) )
                return i;
        }
        return len+1;
    }
}
/* TimeComplexity - O(n) SpaceComplexity - O(n) */
/*=======================================================================================================================================================*/
/* Inplace algo */
class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length ;
        int i = 0;
        while(i < len)
        {
            if(nums[i] <=0 || nums[i] >= len || nums[i] == i +1)
                i++;
            else if(nums[nums[i]-1] != nums[i])
                swap(nums, i, nums[i]-1);
        }
         i =0;
        while(i < len && nums[i] == i+1)
            i++;
        return i+1;
        
    }
    void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        
    }
}
