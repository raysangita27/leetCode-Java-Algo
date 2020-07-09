/*
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
         if(len == 0 || k > len)
            return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);
        int i = 0;
        for(i = 0; i<len; i++)
        {
            pq.add(nums[i]);
            if(pq.size()> k )
                 pq.poll();
        }
        return pq.peek();
    }
}
