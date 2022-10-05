/*
Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.

A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.

 

Example 1:

Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
Output: [15]
Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column.
Example 2:

Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
Output: [12]
Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
Example 3:

Input: matrix = [[7,8],[1,2]]
Output: [7]
Explanation: 7 is the only lucky number since it is the minimum in its row and the maximum in its column.
 

Constraints:

m == mat.length
n == mat[i].length
1 <= n, m <= 50
1 <= matrix[i][j] <= 105.
All elements in the matrix are distinct.

*/

class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0)
            return result;
        int m = matrix.length;
        int n = matrix[0].length;
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        
        for(int j = 0; j < n; j++)
        {
            max = Integer.MIN_VALUE;
            for(int i = 0; i < m; i++)
            {
                max = Math.max(max, matrix[i][j]);
            }
            set.add(max);
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < m; i++)
        {
            min = Integer.MAX_VALUE;
            for(int j = 0; j < n; j++)
            {
                min = Math.min(min, matrix[i][j]);
            }
            if(set.contains(min))
            {
                result.add(min);
            }
        }
        return result;
    }
}
