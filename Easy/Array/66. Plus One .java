/*
Given a non-empty array of digits representing a non-negative integer, increment one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
*/
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int carry = 1;
        List<Integer> result = new ArrayList<Integer>();
        for(int i = n-1; i>= 0; i--)
        {
            int sum = digits[i] + carry;
            result.add(sum%10);
            carry = sum/10;
        }
        if(carry > 0)
            result.add(carry);
        int[] sumResult = new int[result.size()];
        int i = result.size()-1;
        int k = 0;
        for(; i>=0; i--)
            sumResult[k++] = result.get(i);
       return sumResult;     
    }
    
}
