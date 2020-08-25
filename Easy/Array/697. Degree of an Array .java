/*
Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

 

Example 1:

Input: nums = [1,2,2,3,1]
Output: 2
Explanation: 
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.
Example 2:

Input: nums = [1,2,2,3,1,4,2]
Output: 6
Explanation: 
The degree is 3 because the element 2 is repeated 3 times.
So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.
 

Constraints:

nums.length will be between 1 and 50,000.
nums[i] will be an integer between 0 and 49,999.
*/

class Solution {
    public int findShortestSubArray(int[] nums) {
        int len = nums.length;
        if(len == 0)
            return 0;
        HashMap<Integer, Integer> mapFreq = new HashMap<>();
        HashMap<Integer, Integer> mapFirst = new HashMap<>();
        int freq = 0;
        int res = 0;
        
        for(int i =0; i<len; i++)
        {
            if(!mapFirst.containsKey(nums[i]))
            {
                mapFirst.put(nums[i], i);
                mapFreq.put(nums[i], 1);
                if(freq == 0){
                freq = 1;
                res = 1;
                }
            }
            else
            {
                int count = mapFreq.get(nums[i])+1;
                mapFreq.put(nums[i], count);
                if(count > freq)
                {
                    freq = count;
                    res = i - mapFirst.get(nums[i]) + 1;
                }
                if(count == freq)
                {
                    res = Math.min(res,  i - mapFirst.get(nums[i]) + 1);
                }
            }
        }
        return res;
    }
}

/***************************
We need two HashMap

numToFreq to record frequency of each num
numToFirst to record the index that each num first appears
Traverse the array to update numToFreq and numToFirst. We use freq to record current maximum frequency and result to record the length of shortest subarray:

If the frequency of nums[i] is larger than freq, then update result
If the frequency of nums[i] is equal to freq, compare the length of nums[i] and update result if current length is less than result
*/
