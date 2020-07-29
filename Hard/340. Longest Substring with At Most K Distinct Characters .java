/*
Given a string, find the length of the longest substring T that contains at most k distinct characters.

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: T is "ece" which its length is 3.
Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: T is "aa" which its length is 2.
*/

class Solution {
    final int MAX = 255;
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int len = s.length();
        if(len == 0)
            return 0;
        int[] set = new int[MAX];
        int start = 0;
        int end = 0;
        int result = 0;
        int counter = 0;
        while(end < len)
        {
            if(set[s.charAt(end)] == 0)
                counter++;
            set[s.charAt(end)]++;
            while(counter > k)
            {
                set[s.charAt(start)]--;
                if(set[s.charAt(start)] == 0)
                    counter --;
                start++;
            }
           
            end++;
           
            result = Math.max(result, end - start);
             
        }
        return result;
    }
}
