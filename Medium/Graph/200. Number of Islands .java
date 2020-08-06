/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
*/

class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)    
            return 0; 
        int m = grid.length;
        int n = grid[0].length;
        int numOfIsland = 0;
        for(int i = 0; i< m; ++i)
        {
            for(int j = 0; j < n; ++j)
            {
                if(grid[i][j] == '1')
                {
                    ++numOfIsland;
                    dfs(grid, i, j);
                }
            }
        }
        return numOfIsland;
    }
    public void dfs(char [][]grid, int r, int c)
    {
        int m = grid.length;
        int n = grid[0].length;
        if(r >=m || c >= n || r< 0|| c< 0 || grid[r][c] == '0')
            return;
        grid[r][c] = '0';
        dfs(grid, r+1, c);
        dfs(grid, r-1, c);
        dfs(grid, r, c-1);
       
        dfs(grid, r , c+ 1);
    }
}
