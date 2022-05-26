/*
In a gold mine grid of size m x n, each cell in this mine has an integer representing the amount of gold in that cell, 0 if it is empty.

Return the maximum amount of gold you can collect under the conditions:

Every time you are located in a cell you will collect all the gold in that cell.
From your position, you can walk one step to the left, right, up, or down.
You can't visit the same cell more than once.
Never visit a cell with 0 gold.
You can start and stop collecting gold from any position in the grid that has some gold.
 

Example 1:

Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
Output: 24
Explanation:
[[0,6,0],
 [5,8,7],
 [0,9,0]]
Path to get the maximum gold, 9 -> 8 -> 7.
Example 2:

Input: grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
Output: 28
Explanation:
[[1,0,7],
 [2,0,6],
 [3,4,5],
 [0,3,0],
 [9,0,20]]
Path to get the maximum gold, 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 15
0 <= grid[i][j] <= 100
There are at most 25 cells containing gold.

*/
public int getMaximumGold(int[][] grid) 
    {
        
        int maxGold = 0; // Declare a return value - we need two values in order to "hot potato" possible max gold values, this one is the first.
        
        for(int i = 0; i < grid.length; i++) // The nested for loops will search the random spot that we will begin for it.
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] != 0) // Problem description state that we can begin the search at any spot, so we find one that is not empty.
                {
                   maxGold = Math.max(maxGold ,helper(grid, i, j)); // The helper method is the second value in which we will "hot potato" possible max gold values.
                }
            }
        }
        return maxGold; // Returns the final max value.
    }
    
    private int helper(int[][] grid, int x, int y)
    {
        if(x < 0 || grid.length-1 < x || y < 0 || grid[0].length-1 < y || grid[x][y] == 0) // Checks for valid boundris and spots with zero gold.
        {
            return 0;
        }
        
        int temp = grid[x][y]; // Make a copy of a current spot which has gold in it.
		
        grid[x][y] = 0; // Overwrite the current spots value to zero so that we will know that we have been here before. (for the rest of the current iteration).
        
        int up = helper(grid, x-1, y);         // Ways to traversing the matrix.
        int down = helper(grid, x+1, y);
        int left = helper(grid, x, y-1);
        int right = helper(grid, x, y+1);
        
        grid[x][y]= temp; // Overwrite the current spots value back to the original value for the next iteration (we haave changed the value before and we need to "fix" the matrix values back to the original ones).
        
        return  Math.max(Math.max(Math.max(left,right),up),down) + temp; // Return the max sum of gold collected in a single iteration.
        
    }

/*
Time complexity : O(3^k)
*/
