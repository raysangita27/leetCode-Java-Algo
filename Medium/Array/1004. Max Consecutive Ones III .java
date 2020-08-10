/*
Given an array A of 0s and 1s, we may change up to K values from 0 to 1.

Return the length of the longest (contiguous) subarray that contains only 1s. 

 

Example 1:

Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
Output: 6
Explanation: 
[1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
Example 2:

Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
Output: 10
Explanation: 
[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
*/

class Solution {
    public int longestOnes(int[] A, int K) {
        int len = A.length;
        if(len == 0)
            return 0;
        int start = 0;
        int index = 0;
        while(index < len )
        {
            if(A[index] == 0)
            {
                K--;
            }
            if(K < 0)
            {
               
                if(A[start++] == 0)
                    K++;
            }
            
            index++;
        }
        return index-start;
    }
}
