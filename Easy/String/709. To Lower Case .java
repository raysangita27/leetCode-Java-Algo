/*
Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.

 

Example 1:

Input: "Hello"
Output: "hello"
Example 2:

Input: "here"
Output: "here"
Example 3:

Input: "LOVELY"
Output: "lovely"
*/

class Solution {
    public String toLowerCase(String str) {
        int len = str.length();
        String result = "";
        for(int i = 0; i< len; i++)
        {
            if('A'<= str.charAt(i) && str.charAt(i)<='Z')
            {
                char temp = (char) (str.charAt(i) +32);
                result += temp;
            }
            else
                result += str.charAt(i);
        }
        return result;
    }
}
