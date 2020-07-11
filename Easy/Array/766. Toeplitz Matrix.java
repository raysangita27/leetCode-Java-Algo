/*
A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.

Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 

Example 1:

Input:
matrix = [
  [1,2,3,4],
  [5,1,2,3],
  [9,5,1,2]
]
Output: True
Explanation:
In the above grid, the diagonals are:
"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
In each diagonal all elements are the same, so the answer is True.
Example 2:

Input:
matrix = [
  [1,2],
  [2,2]
]
Output: False
Explanation:
The diagonal "[1, 2]" has different elements.

Note:

matrix will be a 2D array of integers.
matrix will have a number of rows and columns in range [1, 20].
matrix[i][j] will be integers in range [0, 99].

*/
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        if(m == 0)
            return false;
        int n = matrix[0].length;
        boolean  row = false;
        boolean  col = false;
        for(int i = 0; i<m; i++)
            if(!validateDiagonal(matrix, i,0 ))
                return false;
        for(int i = 0; i<n; i++)
            if(!validateDiagonal(matrix, 0, i))
                return false;
        return true;
       
    }
    boolean validateDiagonal(int[][] matrix, int i , int j){
        int val = matrix[i][j];
        while(++i< matrix.length && ++j < matrix[0].length)
        {
            if(matrix[i][j] != val)
                return false;
        }
        return true;
    }
}
