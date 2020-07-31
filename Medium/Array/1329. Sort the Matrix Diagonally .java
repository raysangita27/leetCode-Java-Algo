/*
Given a m * n matrix mat of integers, sort it diagonally in ascending order from the top-left to the bottom-right then return the sorted array.

 

![Example](https://github.com/raysangita27/leetCode-Java-Algo/blob/master/images/matrixDiagonalSort.png)


Input: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
Output: [[1,1,1,1],[1,2,2,2],[1,2,3,3]]
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 100
1 <= mat[i][j] <= 100
*/
class Solution {
     PriorityQueue<Integer> pQ = new PriorityQueue<>();
    public int[][] diagonalSort(int[][] mat) {
        if(mat.length == 0)
            return mat;
        int[][] seen = new int[mat.length][mat[0].length];
        for(int i = 0; i< mat.length; i++)
        {
            for(int j = 0; j< mat[0].length; j++)
            {
                if(seen[i][j] != 1)
                {
                    loadQueue(mat, i, j);
                    loadDiagonalElement(mat, i, j, seen);
                }
            }
        }
        return mat;
    }
    void loadQueue(int[][] mat, int i, int j)
    {
        if(i < 0 || i >= mat.length || j >= mat[0].length || j<0)
            return;
        pQ.add(mat[i][j]);
        loadQueue(mat, i+1, j+1);
    }
    void loadDiagonalElement(int[][] mat, int i, int j, int[][] seen)
    {
        if(i < 0 || i >= mat.length || j >= mat[0].length || j<0 || pQ.isEmpty())
            return;
        mat[i][j] = pQ.poll();
        seen[i][j] =1;
        loadDiagonalElement(mat, i+1, j+1, seen);
    }
}
