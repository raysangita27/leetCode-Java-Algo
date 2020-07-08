/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
*/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        int m = matrix.length;
        if(m == 0)
            return result;
        int n = matrix[0].length;
        int l = 0; 
        int k = 0;
        while(l <m && k < n)
        {
            for(int i = k; i< n; i++ )
                result.add(matrix[l][i]);
            l++;
            
            for(int i = l; i< m; i++)
                result.add(matrix[i][n-1]);
            n--;
            
            if(l < m)
            {
                for(int i = n-1; i>= k; i--)
                    result.add(matrix[m-1][i]);
                m--;
            }
            
            if(k < n)
            {
                for(int i = m-1; i>= l; i--)
                    result.add(matrix[i][k]);
                k++;
            }
        }
        return result;
    }
}
