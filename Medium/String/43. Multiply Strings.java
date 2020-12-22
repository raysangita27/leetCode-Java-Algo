/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

 

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
 

Constraints:

1 <= num1.length, num2.length <= 200
num1 and num2 consist of digits only.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
*/



class Solution {
    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int[] prod = new int[n1+n2];
        for(int i = n1-1 ; i >= 0; i--)
        {
            for(int j = n2-1; j >= 0; j--)
            {
                prod[i+j+1] += (num1.charAt(i)- '0') * (num2.charAt(j) - '0');
            }
        }
        int len = prod.length;
        int carry = 0;
        
        for(int i = len-1 ; i >= 0; i--)
        {
            int sum = (prod[i] + carry)%10;
            carry = (prod[i] + carry)/10;
            prod[i] = sum;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int n : prod)
            sb.append(n);
        while(sb.length()!= 0 && sb.charAt(0) == '0') 
            sb.deleteCharAt(0);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
