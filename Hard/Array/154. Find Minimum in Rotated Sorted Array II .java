/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

The array may contain duplicates.

Example 1:

Input: [1,3,5]
Output: 1
Example 2:

Input: [2,2,2,0,1]
Output: 0
Note:

This is a follow up problem to Find Minimum in Rotated Sorted Array.
Would allow duplicates affect the run-time complexity? How and why?
*/

class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        if(len == 0)
            return -1;
        if(len == 1)
            return nums[0];
        int j = 0;
        // removing duplicate elements
        for(int i = 0; i<len-1; i++)
        {
            if(nums[i] != nums[i+1])
                nums[j++] = nums[i];
        }
         nums[j++] = nums[len-1];
        if(j == 1)
            return nums[0];
        if( j == 2)
            return Math.min(nums[0], nums[1]);
        
       
        System.out.println(j);
        int start = 0;
        int end = j-1;
        for(int i = 0; i<j; i++)
            System.out.print(nums[i] + " ");
        System.out.println(" ");
        if(nums[start] < nums[end])
            return nums[start];
        while(start < end)
        {
            int mid = (start +end)/2;
            if(nums[mid]> nums[mid+1])
                return nums[mid+1];
            if(nums[mid-1] > nums[mid])
                return nums[mid];
            if(nums[0] < nums[mid])
                start = mid+1;
            else
                end = mid-1;
        }
        return -1;
    }
}

// TimeComplexity O(n)
