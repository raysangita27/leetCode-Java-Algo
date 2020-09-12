/*
Let's call any (contiguous) subarray B (of A) a mountain if the following properties hold:

B.length >= 3
There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
(Note that B could be any subarray of A, including the entire array A.)

Given an array A of integers, return the length of the longest mountain. 

Return 0 if there is no mountain.

Example 1:

Input: [2,1,4,7,3,2,5]
Output: 5
Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
Example 2:

Input: [2,2,2]
Output: 0
Explanation: There is no mountain.
Note:

0 <= A.length <= 10000
0 <= A[i] <= 10000
Follow up:

Can you solve it using only one pass?
Can you solve it in O(1) space?
*/

class Solution {
    public int longestMountain(int[] A) {
        int len = A.length;
        if(len == 0)
            return 0;
        if(len < 3)
            return 0;
        int[] up = new int[len];
        int[] down = new int[len];
        for(int i = len-2 ; i >= 0; i--)
        {
            if(A[i] > A[i+1])
                down[i] = down[i+1]+1;
        }
        for(int i = 0; i<len; i++)
        {
            if(i > 0 && A[i] > A[i-1])
                up[i] = up[i-1]+1;
        }
        int maxLen = 0;
        for(int i = 0; i<len; i++)
        {
            if(down[i] > 0 && up[i] > 0)
                maxLen = Math.max(maxLen, up[i]+down[i]+1);
        }
        return maxLen;
    }
}
