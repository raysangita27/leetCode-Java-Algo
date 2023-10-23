/*
Given an m x n integer matrix grid, return the maximum score of a path starting at (0, 0) and ending at (m - 1, n - 1) moving in the 4 cardinal directions.

The score of a path is the minimum value in that path.

For example, the score of the path 8 → 4 → 5 → 9 is 4.
 

Example 1:


Input: grid = [[5,4,5],[1,2,6],[7,4,6]]
Output: 4
Explanation: The path with the maximum score is highlighted in yellow. 
Example 2:


Input: grid = [[2,2,1,2,2,2],[1,2,2,2,1,2]]
Output: 2
Example 3:


Input: grid = [[3,4,6,3,4],[0,2,1,1,7],[8,8,3,2,7],[3,2,4,9,8],[4,1,2,0,0],[4,6,5,4,3]]
Output: 3
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 100
0 <= grid[i][j] <= 109

*/

class Solution {
    private int rowCount;
    private int colCount;

    private int[][] dirs = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    
    public int maximumMinimumPath(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;

        int ans  = 0;
        rowCount = grid.length;
        colCount = grid[0].length;
        PriorityQueue<int[]> pQ = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2)
            {
                return grid[o2[0]][o2[1]] - grid[o1[0]][o1[1]];
            }
        }); // need to pick the maximum neighbour . 
        boolean[][] visited = new boolean[rowCount][colCount];
        pQ.add(new int[]{0, 0});
        visited[0][0] = true;
        ans = grid[0][0];
        while(!pQ.isEmpty())
        {
            int[] cur = pQ.remove();
            ans = Math.min(ans , grid[cur[0]][cur[1]]);
            if(cur[0] == rowCount-1 && cur[1] == colCount-1)
                return ans;
            
            for(int[] dir : dirs)
            {
                int nextX = cur[0] + dir[0];
                int nextY = cur[1] + dir[1];
                if(nextX >= 0 && nextX < rowCount && nextY >= 0 && nextY < colCount)
                {
                    if(!visited[nextX][nextY])
                    {
                        pQ.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
        return ans;
    }
}
