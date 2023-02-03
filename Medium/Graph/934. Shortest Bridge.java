/*
You are given an n x n binary matrix grid where 1 represents land and 0 represents water.

An island is a 4-directionally connected group of 1's not connected to any other 1's. There are exactly two islands in grid.

You may change 0's to 1's to connect the two islands to form one island.

Return the smallest number of 0's you must flip to connect the two islands.

 

Example 1:

Input: grid = [[0,1],[1,0]]
Output: 1
Example 2:

Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
Output: 2
Example 3:

Input: grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
Output: 1
 

Constraints:

n == grid.length == grid[i].length
2 <= n <= 100
grid[i][j] is either 0 or 1.
There are exactly two islands in grid.
*/

class Solution {
    public int shortestBridge(int[][] A) {
        int m = A.length, n = A[0].length;
        boolean found = false;
        Queue<int[]> queue = new LinkedList<>();
        int level = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(A[i][j] == 1 && !found) {
                    dfs(A, i, j, m, n);
                    found = true;
                }
                if(found && A[i][j] == 1) {
                    queue.add(new int[] {i, j});
                }
            }
        }
        int[][] d = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int s = 0; s < size; s++) {
                int[] pos = queue.poll();
                for(int i = 0; i < 4; i++) {
                    int x = pos[0] + d[i][0];
                    int y = pos[1] + d[i][1];
                    if(x < 0 || x >= m || y < 0 || y >= n) continue;
                    if(A[x][y] == 2) return level;
                    else if(A[x][y] == 1) continue;
                    else if(A[x][y] == 0) {
                        A[x][y] = 1;
                        queue.add(new int[]{x, y});
                    }
                }
            }
            level++;
        }
        return -1;
        
    }
    
    public void dfs(int[][] A, int i, int j, int m, int n) {
        A[i][j] = 2;
        if(i - 1 >= 0 && A[i-1][j] == 1) dfs(A, i - 1, j, m, n);
        if(i + 1 < m && A[i+1][j] == 1) dfs(A, i + 1, j, m, n);
        if(j - 1 >= 0 && A[i][j - 1] == 1) dfs(A, i, j - 1, m, n);
        if(j + 1 < n && A[i][j + 1] == 1) dfs(A, i, j + 1, m, n);
    }
}
