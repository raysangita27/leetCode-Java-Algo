/*
Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

Example 1:

Input: 123
Output: "One Hundred Twenty Three"
Example 2:

Input: 12345
Output: "Twelve Thousand Three Hundred Forty Five"
Example 3:

Input: 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
Example 4:

Input: 1234567891
Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
*/

class Solution {
    String[] LESSTHAN_TWENTY = {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    String[] LESSTHAN_HUNDRED = {
        "Twenty", "Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"
    };
    String[] THOUSAND_ABOVE ={"","Thousand","Million","Billion","Trillion"};
    public String numberToWords(int num) {
        if(num == 0)
            return "Zero";
        String ans ="";
        int index = 0;
        while(num > 0)
        {
            if(num%1000 > 0)
            {
            ans = processThreeDigit(num%1000) + THOUSAND_ABOVE[index] + " " + ans;
            }
            num /= 1000;
            index ++;
        }
        return ans.trim();
    }
    String processThreeDigit(int num)
    {
        if(num == 0)
            return "";
        else if(num < 20)
            return LESSTHAN_TWENTY[num-1] + " ";
        else  if(num >= 20 && num < 100)
            return LESSTHAN_HUNDRED[num/10-2] + " " + processThreeDigit(num% 10);
        else 
            return LESSTHAN_TWENTY[num/100 -1] + " "  + "Hundred"+" "+ processThreeDigit(num% 100);
        
    }
}
/*
How we count number like 123456789?
        We break into 3 digits like 123,456,789. Then starts with 789 -> Seven Hundred Eighty Nine + ""
        Then 456 --> Four Hundred Fifty Six + Thousand
        Then 123 --> One Hundred Twenty Three + Million.
        So we can solve this problem by converting every 3 digits and adding ", thousand, million, etc
        Using %1000, we can get last 3 digit, and call convert func then append above thousand string, and we need to append these in front of our string because we are working from the end of the number to higher digits.
        If any time num%1000 == 0, we don't add anything. For example 1,000,456 -> One Million Four Hundred Fifty Six. There is no Thousand at all.
        Converting 3 digits can be done recursively, if 0 or <20, base case.
        Between 20 - 99, we append LESSTHANHUNDRED string and we need to convert the last digit as well which we can call convert(num%10)
        Similar process for 100-999. Don't forget the spaces we need to add during converting.
        Time complexity: O(N) - N is the number of digits
 */
