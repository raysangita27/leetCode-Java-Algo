/*
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Note:

Each element in the result must be unique.
The result can be in any order.
*/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0)
            return new int[]{};
        HashSet<Integer> set = new HashSet<Integer>();
        int m = nums1.length;
        int n = nums2.length;
        for(int k : nums1)
            set.add(k);
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i<n; i++)
        {
            if(set.contains(nums2[i]))
            {
                if(!result.contains(nums2[i]))
                    result.add(nums2[i]);
            }
        }
        int[] val = new int[result.size()];
        for(int i = 0; i< result.size(); i++ )
            val[i] = result.get(i);
        return val;
    }
}
