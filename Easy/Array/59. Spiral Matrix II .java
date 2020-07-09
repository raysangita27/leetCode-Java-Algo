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
        if(n == 0)
            return null;
        int[][] mat = new int[n][n];
        // index for row
        int l = 0;
        // index for column
        int k = 0;
        // end index for row
        int m = n;
        int number = 1;
        while( l < m && k< n)
        {
            for(int i = k; i< n; i++)
                mat[l][i] = number++;
            l++;
             for(int i = l; i< m; i++)
                mat[i][n-1] = number++;
            n--;
            if(l < m)
            {
                for(int i = n-1; i>= k; i--)
                mat[m-1][i] = number++;
                m--;
            }
            if(k < n)
            {
                for(int i = m-1; i>= l; i--)
                mat[i][k] = number++;
                k++;
            }
        }

        return mat;
    }
}
