/*
Given an array A of positive integers, let S be the sum of the digits of the minimal element of A.

Return 0 if S is odd, otherwise return 1.

 

Example 1:

Input: [34,23,1,24,75,33,54,8]
Output: 0
Explanation: 
The minimal element is 1, and the sum of those digits is S = 1 which is odd, so the answer is 0.
Example 2:

Input: [99,77,33,66,55]
Output: 1
Explanation: 
The minimal element is 33, and the sum of those digits is S = 3 + 3 = 6 which is even, so the answer is 1.
 

Constraints:

1 <= A.length <= 100
1 <= A[i] <= 100
*/

class Solution {
    public int sumOfDigits(int[] A) {
        if(A.length == 0)
            return 1;
        int min = A[0];
        for(int i = 1; i <A.length; i++)
        {
            min = Math.min(min, A[i]);
        }
        int digitSum = 0;
        while(min > 0)
        {
            digitSum += (min % 10);
            min = min/10;
        }
        if(digitSum %2 == 0)
            return 1;
        else
            return 0;
    }
}
