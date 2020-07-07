/*
Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.

 

Example 1:

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Example 2:

Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 

Note:

1 <= A.length <= 10000
-10000 <= A[i] <= 10000
A is sorted in non-decreasing order.
*/

class Solution {
    public int[] sortedSquares(int[] A) {
        int[] result = new int[A.length];
        if(A.length == 0)
            return result;
        int k = A.length-1;
        int i = 0;
        int j = A.length-1;
        while(i<= j)
        {
            if(Math.pow(A[i],2) >= Math.pow(A[j],2) )
            {
                result[k--] =(int) Math.pow(A[i],2);
                i++;
            }
            else if(Math.pow(A[i],2) < Math.pow(A[j],2) )
            {
                result[k--] =(int) Math.pow(A[j],2);
                j--;
            }
        }
        return result;
    }
}
