/*
Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/

class Solution {
    public int[][] generateMatrix(int n) {
        int m = n;
        int l = 0;
        int k = 0;
        int [][] mat = new int[m][n];
        int val = 1;
        while(l < m && k < n)
        {
            for(int i = k; i<n; i++)
                mat[l][i] = val ++;
            l++;
            for(int i = l; i<m; i++)
                mat[i][n-1] = val ++;
            n--;
            if(l < m)
            {
                for(int i = n-1; i >= k; i--)
                    mat[m-1][i] = val ++;
                m--;
            }
            if(k < n)
            {
                for(int i = m-1 ; i>=l; i--)
                mat[i][k] = val ++;
                k++;
            }
        }
        return mat;
    }
}
