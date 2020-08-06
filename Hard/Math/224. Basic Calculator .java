/*
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

Example 1:

Input: "1 + 1"
Output: 2
Example 2:

Input: " 2-1 + 2 "
Output: 3
Example 3:

Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23
Note:
You may assume that the given expression is always valid.
Do not use the eval built-in library function.
*/

class Solution {
    // Time O(N) Space O(N) for recursive or stack
    int i = 0;
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        int tmp = 0, sign = 1, result = 0;
        while (i < s.length()) {
            char c = s.charAt(i++);
            if (Character.isDigit(c)) {
                tmp = tmp * 10 + c - '0';
            } else if (c == '(') {
                tmp = calculate(s);
            } else if (c == ')') {
                break;
            } else if (c == '+' || c == '-') {
                result += sign * tmp;
                tmp = 0;
                sign = (c == '+')? 1 : -1;
            }
        }
        result += sign * tmp;
        return result;
    }
}
