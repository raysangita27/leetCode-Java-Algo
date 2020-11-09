/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

 


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

 


The largest rectangle is shown in the shaded area, which has area = 10 unit.

 

Example:

Input: [2,1,5,6,2,3]
Output: 10
*/

class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if(len == 0)
            return 0;
        int maxArea = 0;
        for(int i = 0; i < len; i++)
        {
            int left = i;
            int right = i;
            while(left >= 0 && heights[left] >= heights[i])
                left--;
            while(right <len && heights[right] >= heights[i])
                right++;
            maxArea = Math.max(maxArea, (right-1 - (left+1)+1)* heights[i]);
        }
        return maxArea;
    }
}
// TimeComplexity : O(n)
// SpaceComplexity: O(1)
