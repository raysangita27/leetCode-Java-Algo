/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:

Input: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
Example 2:

Input: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
Follow up:

A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
*/
/********** constant space impelmentation ************/

class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return ;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRow = false;
        boolean firstCol = false;
        // check whether first row contains zero and set the boolean variable 
        for(int i = 0; i< n; i++)
        {
            if(matrix[0][i] == 0)
            {
                firstRow = true;
                break;
            }
        }
        System.out.println(firstRow);
        // check whether first col contains zero and set the boolean variable 
        for(int i = 0; i< m; i++)
        {
            if(matrix[i][0] == 0)
            {
                firstCol = true;
                break;
            }
        }
        
        // check for rest of the column except first row && first col
        // if a cell has value 0 , set the corresponding 0th row and 0th column as 0
        for(int i = 1; i<m ; i++)
        {
            for(int j = 1; j<n; j++)
            {
                if(matrix[i][j] == 0)
                {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        // based on the set value of 0th row and 0th column set the entire column and row as 0
        
        for(int i = 1; i<m ; i++)
        {
            for(int j = 1; j<n; j++)
            {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) 
                {
                    matrix[i][j] = 0;
                }
            }
        }
        // set the first column 0 if the firsCol var is set
        if(firstCol)
        {
            for(int i = 0; i<m; i++)
                matrix[i][0] = 0;
        }
        // set the first row 0 if the firsRow var is set
        if(firstRow)
        {
            for(int i = 0; i<n; i++)
                matrix[0][i] = 0;
        }
        
    }
}
