/*
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

Example:

Input:  [1,2,1,3,2,5]
Output: [3,5]
Note:

The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
*/

class Solution {
    public int[] singleNumber(int[] nums) {
        int len = nums.length;
        if(len == 0)
            return new int[]{};
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums)
        {
            if(map.containsKey(n))
                map.put(n, map.get(n) +1 );
            else
                map.put(n,1);
        }
        int[] result = new int[2];
        int i = 0;
        for(int n : nums)
        {
            if(map.get(n) ==1)
                result[i++] = n;
        }
        return result;
    }
}
/* Space Complexity O(n) */
/* =========================================================================================================================================*/
/* Constant Space Complexity*/

