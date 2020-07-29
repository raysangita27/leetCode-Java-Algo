/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
*/

class Solution {
    final int MAX = 256;
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        int N = s.length();
        int k = p.length();
        if(N == 0 || k> N)
            return result;
        char[] countp = new char[MAX];
        char[] counts = new char[MAX];
        for(int i= 0; i<k ; i++)
        {
            countp[p.charAt(i)]++;
            counts[s.charAt(i)]++;
        }
        if(checkAnagrams(countp, counts))
            result.add(0);
        
        for(int i = k; i<N; i++)
        {
            counts[s.charAt(i)]++;
            counts[s.charAt(i-k)]--;
            if(checkAnagrams(countp, counts))
                result.add(i-k+1);
        }
        return result;
        
    }
    boolean checkAnagrams(char[] countp, char[] counts)
    {
        for(int i = 0; i< MAX; i++)
        {
            if(countp[i] != counts[i])
                return false;
        }
        return true;
    }
}
