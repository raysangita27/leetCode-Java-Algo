/*
Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the time.

Return that integer.

 

Example 1:

Input: arr = [1,2,2,6,6,6,6,7,10]
Output: 6
 

Constraints:

1 <= arr.length <= 10^4
0 <= arr[i] <= 10^5
*/

class Solution {
    public int findSpecialInteger(int[] arr) {
        int len = arr.length;
        if(len == 1)
            return arr[0];
        int  target = len /4;
        int count = 1;
        for(int i =1; i<len; i++)
        {
            if(arr[i] == arr[i-1])
                count++;
            else
                count= 1;
            if(count > target)
                return arr[i];
        }
        return -1;
    }
}
