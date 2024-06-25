/*
You are given an m x n integer matrix grid where each cell is either 0 (empty) or 1 (obstacle). You can move up, down, left, or right from and to an empty cell in one step.

Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner (m - 1, n - 1) given that you can eliminate at most k obstacles. If it is not possible to find such walk return -1.

 

Example 1:


Input: grid = [[0,0,0],[1,1,0],[0,0,0],[0,1,1],[0,0,0]], k = 1
Output: 6
Explanation: 
The shortest path without eliminating any obstacle is 10.
The shortest path with one obstacle elimination at position (3,2) is 6. Such path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
Example 2:


Input: grid = [[0,1,1],[1,1,1],[1,0,0]], k = 1
Output: -1
Explanation: We need to eliminate at least two obstacles to find such a walk.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 40
1 <= k <= m * n
grid[i][j] is either 0 or 1.
grid[0][0] == grid[m - 1][n - 1] == 0

*/

class Solution {
    public int shortestPath(int[][] grid, int k) {
        if(grid == null || grid.length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0,0, 0});
        boolean[][][] visited = new boolean[m][n][k+1];
        visited[0][0][0] = true;

        int stepCount = 0;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i = 0; i < size; i++)
            {
                int[] currentInfo = queue.remove();

                int curX = currentInfo[0];
                int curY = currentInfo[1];
                int curK = currentInfo[2];
                if(curX == m-1 && curY == n-1)
                    return stepCount;
                
                for(int[] dir : dirs)
                {
                    int nextX = dir[0] + curX;
                    int nextY = dir[1] + curY;
                    int nextK = curK;

                    if(nextX >= 0 && nextY >= 0 && nextX < m && nextY < n)
                    {
                        if(grid[nextX][nextY] == 1)
                        {
                            nextK++;
                        } 
                        if(nextK <= k && !visited[nextX][nextY][nextK])
                        {
                            queue.add(new int[]{nextX, nextY, nextK});
                            visited[nextX][nextY][nextK] = true;
                        }
                        
                    }
                }

            }
            stepCount++;
        }
        return -1;
          
    }
}

// Time Complexity O(m*n*k)
