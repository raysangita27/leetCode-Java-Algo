/*
Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.

 

Example 1:


Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,4,7,5,3,6,8,9]
Example 2:

Input: mat = [[1,2],[3,4]]
Output: [1,2,3,4]
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
-105 <= mat[i][j] <= 105
*/

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if(mat == null || mat.length == 0)
            return new int[]{};
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m*n];
        int dir = 1;
        int r = 0;
        int c = 0;
        int i = 0;
        while(r < m && c < n)
        {
            result[i++] = mat[r][c];
            int row =  r + (dir == 1 ? -1 : 1);
            int col =  c + (dir == 1 ? 1 : -1);
            if(row < 0 || col < 0 || row == m || col == n)
            {
                if(dir == 1)
                {
                    r = r + (c == n-1 ? 1 : 0);
                    c = c + (c < n -1 ? 1 : 0);
                }
                else
                {
                     c = c +  (r == m-1 ? 1 : 0);
                    r = r +  (r < m -1 ? 1 : 0);
                }
                dir = 1 - dir;
            }
            else
            {
                r = row;
                c = col;
            }
        }
        return result;
    }
}
