/*
Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.

 

Example 1:

Input: arr = [3,1,2,4]
Output: 17
Explanation: 
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.
Example 2:

Input: arr = [11,81,94,43,3]
Output: 444
 

Constraints:

1 <= arr.length <= 3 * 104
1 <= arr[i] <= 3 * 104

*/

class Solution {
    public int sumSubarrayMins(int[] arr) {
        if(arr == null || arr.length == 0)
            return 0;

        long maxSum = 0;
        Stack<Integer> stk = new Stack<>();

        for(int i = 0; i <= arr.length; i++)
        {
            while(!stk.isEmpty() && (i == arr.length || arr[stk.peek()] >= arr[i]))
            {
                int mid = stk.pop();
                int leftMin = stk.isEmpty() ? -1 : stk.peek();
                int rightMin= i;
                long count =  (mid-leftMin)* (rightMin-mid)% 1000000007;
                maxSum += (arr[mid] * count) % 1000000007;
                maxSum = maxSum % 1000000007;
            }
            stk.push(i);
        } 
        return (int)maxSum;   
    }
}
