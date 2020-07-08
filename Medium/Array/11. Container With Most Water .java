/*
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

 



The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

 

Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49
*/
class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        if(len == 0)
            return 0;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = height[0];
        right[len-1] = height[len-1];
        for(int i = 1; i<len; i++)
            left[i] = Math.max(height[i], left[i-1]);
        for(int i = len-2; i>=0; i--)
            right[i] = Math.max(height[i], right[i+1]);
        
        int l = 0;
        int r = len-1;
        int waterAmt = Integer.MIN_VALUE;
        while(l <=r)
        {
            waterAmt = Math.max(waterAmt, Math.min(left[l],right[r])*(r-l) );
            if(left[l] < right[r])
                l++;
            else
                r--;
        }
        return waterAmt;
    }
}
