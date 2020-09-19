/*
You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

Example: 

Given the 2D grid:

INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:

  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
*/

class Solution {
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 )
            return;
        int m = rooms.length;
        int n = rooms[0].length;
        for(int i = 0; i<m; i++ )
        {
            for(int j = 0; j< n; j++)
            {
                if(rooms[i][j] == 0)
                //starts from a gate and go backward . 4th argument denotes the distance from gate 
                    dfs(rooms, i, j, 0);
            }
        }
    }
    private void dfs(int[][] rooms, int i, int j, int d)
    {
        if(i < 0 || i >= rooms.length || j <0 || j >= rooms[0].length || rooms[i][j] < d)
            return;
        rooms[i][j] = d;
        dfs(rooms, i , j+1, d+1);
        dfs(rooms, i , j-1, d+1);
        dfs(rooms, i+1, j , d+1);
        dfs(rooms, i-1, j , d+1);
            
    }
}
