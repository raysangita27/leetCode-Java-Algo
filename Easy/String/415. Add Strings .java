/*
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/

class Solution {
    public String addStrings(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        if(m == 0)
            return num2;
        if(n == 0)
            return num1;
        num1 = new StringBuffer(num1).reverse().toString();
        num2 = new StringBuffer(num2).reverse().toString();
        System.out.println("num1->" + num1 + " "+ "num2->" + num2);
        //int sum = 0;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int i = 0; int j = 0;
        while(i<m || j<n)
        {
           int sum = carry + ((i >= m) ? 0 : Integer.parseInt(num1.valueOf(num1.charAt(i)))) + ((j >= n) ? 0 : Integer.parseInt(num2.valueOf(num2.charAt(j))));
            
            sb.append(Integer.toString(sum%10));
            carry = sum / 10;
            i++;
            j++;
        }
        if(carry > 0)
            sb.append(Integer.toString(carry));
        return sb.reverse().toString();
    }
}
