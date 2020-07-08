/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0 ||  matrix[0].length == 0 || matrix == null )
            return false;
        int n = matrix[0].length;
        int start = 0; 
        int end = n-1;
        while(start < m && end >= 0)
        {
            
            if(matrix[start][end] == target)
                return true;
            else if(matrix[start][end] < target )
                start++;
            else if(matrix[start][end] > target )
                end --;
                
        }
        return false;
    }
}
