/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Note: m and n will be at most 100.

Example 1:

Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

*/

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if(m == 0)
            return 0;
        int n = obstacleGrid[0].length;
        if ( obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1 )
            return 0;
        int[][] path = new int[m][n];
        path[0][0] =1 ;
        for(int i = 1; i< n; i++)
        {
            if(obstacleGrid[0][i] == 1)
                path[0][i] = 0;
            else
                path[0][i] = path[0][i-1];
        }
         for(int i = 1; i< m; i++)
        {
            if(obstacleGrid[i][0]== 1)
                path[i][0] = 0;
            else
                path[i][0] = path[i-1][0];
        }
        
        for(int i = 1; i< m; i++)
        {
            for(int j = 1; j<n; j++)
            {
                if(obstacleGrid[i][j] != 1)
                    path[i][j] = path[i-1][j] + path[i][j-1];
                else
                    path[i][j] = 0;
              
            }
        }
        return path[m-1][n-1];
    }
}
