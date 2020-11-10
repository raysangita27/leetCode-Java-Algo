/*
Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

 

Example 1:


Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.
Example 2:

Input: matrix = []
Output: 0
Example 3:

Input: matrix = [["0"]]
Output: 0
Example 4:

Input: matrix = [["1"]]
Output: 1
Example 5:

Input: matrix = [["0","0"]]
Output: 0
 

Constraints:

rows == matrix.length
cols == matrix.length
0 <= row, cols <= 200
matrix[i][j] is '0' or '1'.
*/

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] height = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left,0);
        Arrays.fill(right, n);
        int maxArea = 0;
        for(int i = 0; i< m; i++)
        {
            int curLeft = 0;
        int curRight = n;
            for(int j = 0; j<n; j++)
            {
                if(matrix[i][j] == '1')
                    height[j] ++;
                else
                    height[j] = 0;
            }
            
            for(int j = 0; j <n; j++)
            {
                if(matrix[i][j] == '1')
                    left[j] = Math.max(left[j],curLeft);
                else
                {
                    left[j] = 0;
                    curLeft = j+1;
                }
            }
            
            for(int j = n-1; j >= 0 ; j--)
            {
                if(matrix[i][j] == '1')
                    right[j] = Math.min(right[j],curRight);
                else
                {
                    right[j] = n;
                    curRight = j;
                }
            }
            for(int j = 0; j<n; j++)
                maxArea= Math.max(maxArea, (right[j]-left[j])*height[j]);
        }
        return maxArea;
    }
}


/*
If you think this algorithm is not easy to understand, you can try this example:

0 0 0 1 0 0 0 
0 0 1 1 1 0 0 
0 1 1 1 1 1 0
The vector "left" and "right" from row 0 to row 2 are as follows

row 0:

l: 0 0 0 3 0 0 0
r: 7 7 7 4 7 7 7
row 1:

l: 0 0 2 3 2 0 0
r: 7 7 5 4 5 7 7 
row 2:

l: 0 1 2 3 2 1 0
r: 7 6 5 4 5 6 7
The vector "left" is computing the left boundary. Take (i,j)=(1,3) for example. On current row 1, the left boundary is at j=2. However, because matrix[1][3] is 1, you need to consider the left boundary on previous row as well, which is 3. So the real left boundary at (1,3) is 3.
*/
/**************************************Other Approach******************************************/
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if(m == 0)
            return 0;
        int n = matrix[0].length;
        int maxArea = 0;
        int[] height = new int[n];
        for(int i = 0; i <m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(matrix[i][j] == '1')
                    height[j]++;
                else
                    height[j] = 0;
                
            }
            maxArea = Math.max(maxArea, getArea(height));
            
        }
        return maxArea;
    }
    public int getArea(int[] height)
    {
        int len = height.length;
        int area = 0;
        if(len == 0)
            return 0;
        for(int i = 0; i < len; i ++)
        {
            int left = i;
            int right = i;
            while(left >= 0 && height[left] >= height[i])
                left--;
            while(right < len && height[right] >= height[i])
                right++;
            area = Math.max(area, (right-1 -(left+1)+1)*height[i]);
        }
        return area;
    }
}
