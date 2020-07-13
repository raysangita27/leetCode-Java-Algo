/*
Given a m * n matrix grid which is sorted in non-increasing order both row-wise and column-wise. 

Return the number of negative numbers in grid.

 

Example 1:

Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.
Example 2:

Input: grid = [[3,2],[1,0]]
Output: 0
Example 3:

Input: grid = [[1,-1],[-1,-1]]
Output: 3
Example 4:

Input: grid = [[-1]]
Output: 1
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 100
-100 <= grid[i][j] <= 100
*/
class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        if(m == 0)
            return 0;
        int n = grid[0].length;
        int count = 0;
        for(int i = 0; i<m; i++)
        {
            int ind = findCountColumnWise(grid[i],0,n-1,n);
            
            if(ind != -1)
                count += (n - ind);
            
        }
        return count;
    }
    int findCountColumnWise(int[] a, int left, int right, int n)
    {
        if(left > right || a[n-1] >0)
            return -1;
        if(left == right && a[left]< 0)
            return left;
        int mid =(left + right)/2;
        if((mid == 0 || a[mid-1]>= 0) && a[mid]<0 )
            return mid;
        if(a[mid] >= 0)
            return findCountColumnWise(a, mid+1, right, n);
        else
            return findCountColumnWise(a, left, mid-1, n);
    }
}
