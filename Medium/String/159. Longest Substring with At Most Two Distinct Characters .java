/*
Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.

Example 1:

Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.
Example 2:

Input: "ccaabbb"
Output: 5
Explanation: t is "aabbb" which its length is 5.
*/

class Solution {
    final int MAX = 256;
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int len = s.length();
        if(len == 0 || len == 1)
            return len;
        int start = 0;
        int end = 0;
        int counter = 0;
        int[] set = new int[MAX];
        int res = 0;
        while(end < len)
        {
            if(set[s.charAt(end)]== 0)
                counter++;
            set[s.charAt(end)] ++;
            while(counter > 2)
            {
                set[s.charAt(start)]--;  
                if(set[s.charAt(start)] == 0)
                    counter--;
                start++;
            }
            end++;
            res = Math.max(res, end - start);
        }
        return res;
    }
}
