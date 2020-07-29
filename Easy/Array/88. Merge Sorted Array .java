/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
*/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0){
            for(int i = 0; i<n; i++)
                nums1[i] = nums2[i];
            return;
        }
        if(n == 0)
            return;
        int i = 0;
        int j = 0;
        List<Integer> result = new ArrayList<>();
        while(i < m && j < n)
        {
            if(nums1[i] <= nums2[j])
            {
                result.add(nums1[i]);
                i++;
            }
            else{
                result.add(nums2[j]);
                j++;
            }
                
        }
        while(i <m)
        {
            result.add(nums1[i]);
            i++;
        }
        while(j <n)
        {
            result.add(nums2[j]);
            j++;
        }
        int k = 0;
        for(int a : result)
            nums1[k++] =a ;
                
    }
}
