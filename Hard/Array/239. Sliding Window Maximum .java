/*
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

Follow up:
Could you solve it in linear time?

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 
Explanation: 

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 

Constraints:

1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4
1 <= k <= nums.length

*/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        if(k ==1)
        {
            return nums;
        }
        int i = 0;
        int start = 0; 
        int end = k-1;
        int next = start;
        int max = nums[k-1];
        int[] result = new int[len-k+1];
        while(end <= len-1)
        {
            if(nums[start] > max){
                max = nums[start];
                
            }
            start++;
            if(start == end && start <len)
            {
                result[i++] = max;
                end ++;
                start = ++next; 
                if(end < len)
                max = nums[end];
            }
            
                
        }
        
        for(int a : list)
            result[i++] = a;
        return result;
    }
}
/* time complexity O(n *k)  space complexity O(1) */

/* =============================================================================================================================*/
/* Linear time implementation */


/
