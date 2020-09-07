/*
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

 

Constraints:

haystack and needle consist only of lowercase English characters.
*/

class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null)
            return -1;
        int L1 = haystack.length();
        int L2 = needle.length();
        if(L2 > L1)
            return -1;
        
        for(int i = 0; i<L1-L2+1; i++)
        {
            int count = 0;
            while(count < L2 && haystack.charAt(i+ count) == needle.charAt(count))
                count++;
            if(count == L2)
                return i;
        }
        return -1;
    }
}
