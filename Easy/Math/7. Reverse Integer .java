/*
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
*/

class Solution {
    public int reverse(int x) {
        int index = 0;
        int result = 0; 
        int num = Math.abs(x);
        while(num >0)
        {
            int digit=  (num % 10);
            num /= 10;
            if(result > Integer.MAX_VALUE/10  || (result == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE%10 ))
               {
                   //result =  x < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                   return 0;
               }
               result = result * 10 + digit;
                
        }
               
        return x > 0 ? result : -result;
        
    }
}
