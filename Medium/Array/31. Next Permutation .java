/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/

class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if(len == 0 || len <= 1)
            return ;
        int i = len -1;
        while(i > 0 && nums[i-1]>= nums[i])
            i--;
        if(i <= 0)
        {
            reverse(nums, 0);
            return;
        }
        int j = len-1;
        while(j >= 0 && nums[j]<= nums[i-1])
            j--;
        swap(nums, i-1, j);
        reverse(nums, i);
    }
    void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    void reverse(int[] nums, int start)
    {
        int end = nums.length - 1;
        while(start < end)
        {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }
}

/*
