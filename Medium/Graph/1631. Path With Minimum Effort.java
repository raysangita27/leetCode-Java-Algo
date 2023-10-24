/*
You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.

A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.

Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

 

Example 1:



Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
Output: 2
Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.
Example 2:



Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
Output: 1
Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better than route [1,3,5,3,5].
Example 3:


Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
Output: 0
Explanation: This route does not require any effort.
 

Constraints:

rows == heights.length
columns == heights[i].length
1 <= rows, columns <= 100
1 <= heights[i][j] <= 106
*/

class Solution {
    public int minimumEffortPath(int[][] heights) {
        if(heights == null || heights.length == 0)
            return 0;
        int m = heights.length;
        int n = heights[0].length;
        int[][] maxDiff = new int[m][n];
        for(int[] maxD : maxDiff)
        {
            Arrays.fill(maxD, Integer.MAX_VALUE);
        }
        maxDiff[0][0] = 0;

        PriorityQueue<Cell> pQ = new PriorityQueue<Cell>(new Comparator<Cell>(){
            public int compare(Cell c1 , Cell c2)
            {
                return c1.diff - c2.diff;
            }
        });

        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0 , -1}};
        pQ.add(new Cell(0, 0, 0));
        while(!pQ.isEmpty())
        {
            Cell current = pQ.remove();
            visited[current.row][current.col] = true;
            if(current.row == m-1 && current.col == n-1)
                return current.diff;
            for(int[] dir : dirs)
            {
                int nextX = current.row + dir[0];
                int nextY = current.col + dir[1];
                if(valid(heights, nextX, nextY))
                {
                    if(!visited[nextX][nextY])
                    {
                        int curDiff = Math.abs(heights[nextX][nextY] - heights[current.row][current.col]); // calculating current diff
                        int max = Math.max(curDiff, maxDiff[current.row][current.col]); // getting maxdiff b/w current and next cell
                        if(maxDiff[nextX][nextY] > max)  // if max diff is less that current value we will take that path.
                        {
                            maxDiff[nextX][nextY] = max;
                            pQ.add(new Cell(nextX, nextY, max));
                            
                        }
                    }
                }
            }
        }
        return -1;

    }
    public boolean valid(int[][] heights, int i, int j)
    {
        if(i >= 0 && j >= 0 && i < heights.length && j < heights[0].length)
            return true;
        return false;
    }
}
class Cell{
    int row;
    int col;
    int diff;
    public Cell(int r, int c, int d)
    {
        row = r;
        col = c;
        diff = d;
    }
}

/**********TimeComplexity : O(m*nlog(mn))
  
