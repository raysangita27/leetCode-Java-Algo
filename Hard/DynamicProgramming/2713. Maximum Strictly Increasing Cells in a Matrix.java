/*
Given a 1-indexed m x n integer matrix mat, you can select any cell in the matrix as your starting cell.

From the starting cell, you can move to any other cell in the same row or column, but only if the value of the destination cell is strictly greater than the value of the current cell. You can repeat this process as many times as possible, moving from cell to cell until you can no longer make any moves.

Your task is to find the maximum number of cells that you can visit in the matrix by starting from some cell.

Return an integer denoting the maximum number of cells that can be visited.

 

Example 1:



Input: mat = [[3,1],[3,4]]
Output: 2
Explanation: The image shows how we can visit 2 cells starting from row 1, column 2. It can be shown that we cannot visit more than 2 cells no matter where we start from, so the answer is 2. 
Example 2:



Input: mat = [[1,1],[1,1]]
Output: 1
Explanation: Since the cells must be strictly increasing, we can only visit one cell in this example. 
Example 3:



Input: mat = [[3,1,6],[-9,5,7]]
Output: 4
Explanation: The image above shows how we can visit 4 cells starting from row 2, column 1. It can be shown that we cannot visit more than 4 cells no matter where we start from, so the answer is 4. 
 

Constraints:

m == mat.length 
n == mat[i].length 
1 <= m, n <= 105
1 <= m * n <= 105
-105 <= mat[i][j] <= 105
*/

class Solution {
    public int maxIncreasingCells(int[][] mat) {
        if(mat == null  || mat.length == 0)
            return 0;
        TreeMap<Integer,List<int[]>> map = new TreeMap<>();
        for(int i = 0; i < mat.length; i++)
        {
            for(int j = 0; j < mat[0].length; j++)
            {
                if(!map.containsKey(mat[i][j]))
                    map.put(mat[i][j], new ArrayList<>());
                map.get(mat[i][j]).add(new int[]{i, j});
            }
        }  
        int level = 0;
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][n];
        int[] res = new int[m+n];
        for(int a : map.keySet())
        {
            for(int[] pos : map.get(a))
            {
                int i = pos[0];
                int j = pos[1];
                dp[i][j] = Math.max(res[i], res[j+m]) +1;
            }
            for(int[] pos : map.get(a))
            {
                int i = pos[0];
                int j = pos[1];
                res[i] = Math.max(res[i], dp[i][j]);
                res[j+m] = Math.max(res[j+m], dp[i][j]);
            }
        }

        for(int x : res)
            level = Math.max(level, x);
        return level;

    }
}
/*
Sort pairs [i, j] by value of M[i][j],
and then iterate cells in increasing order.

For each M[i][j],
find out the current maximum steps in the same row and col,
dp[i][j] = max(max steps in row, max steps in col) + 1.

To make this process efficient,
we use res[i] to record the maximum step for row i,
we use res[m + j] to record the maximum step for col j.

Repeat this process until we find the steps for all cells,
return the maximum one.

*/
