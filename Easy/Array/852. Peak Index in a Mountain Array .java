/*
Let's call an array A a mountain if the following properties hold:

A.length >= 3
There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].

Example 1:

Input: [0,1,0]
Output: 1
Example 2:

Input: [0,2,1,0]
Output: 1
Note:

3 <= A.length <= 10000
0 <= A[i] <= 10^6
A is a mountain, as defined above.
*/

class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int len = A.length;
        if(len == 0)
            return 0;
        return findPeak(A, 0, len-1, len);
    }
    int findPeak(int[] num, int l, int r, int n)
    {
        if(l> r)
            return -1;
     
        if(l == r)
            return l;
        int mid = (l + r)/2;
        if((mid == 0 || num[mid-1] < num[mid] )&& (num[mid]>num[mid+1] || mid == n-1))
            return mid;
        if(num[mid-1] > num[mid])
            return findPeak(num, l, mid-1, n);
        else
            return findPeak(num, mid+1, r, n);
        
    }
}
