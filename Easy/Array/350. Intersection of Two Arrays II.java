/*
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Note:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
*/

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0 )
            return new int[]{};
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i< nums1.length; i++)
        {
            if(map.containsKey(nums1[i]) )
                map.put(nums1[i], map.get(nums1[i])+1);
            else
                map.put(nums1[i],1);
        }
        for(int i = 0; i< nums2.length; i++)
        {
            if(map.containsKey(nums2[i]))
            {
                if(map.get(nums2[i])> 0)
                {
                     result.add(nums2[i]);
                    map.put(nums2[i], map.get(nums2[i])-1);
                }     
            }
        }
        int[] ans = new int[result.size()];
        for(int i = 0; i < result.size(); i++ )
            ans[i] = result.get(i);
        return ans;
        
    }
}
