/*
Given two equal-size strings s and t. In one step you can choose any character of t and replace it with another character.

Return the minimum number of steps to make t an anagram of s.

An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.

 

Example 1:

Input: s = "bab", t = "aba"
Output: 1
Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.
Example 2:

Input: s = "leetcode", t = "practice"
Output: 5
Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from t with proper characters to make t anagram of s.
Example 3:

Input: s = "anagram", t = "mangaar"
Output: 0
Explanation: "anagram" and "mangaar" are anagrams. 
Example 4:

Input: s = "xxyyzz", t = "xxyyzz"
Output: 0
Example 5:

Input: s = "friend", t = "family"
Output: 4
 

Constraints:

1 <= s.length <= 50000
s.length == t.length
s and t contain lower-case English letters only.
*/

class Solution {
    public int minSteps(String s, String t) {
        HashMap<Character, Integer> counter = new HashMap<>();
        for(char c : s.toCharArray())
        {
            counter.put(c, counter.getOrDefault(c, 0)+1);
        }    

        int steps = 0;

        for(int i = 0; i < t.length(); i++)
        {
            char c = t.charAt(i);
            if(counter.containsKey(c))
            {
                counter.put(c, counter.get(c)-1);
                if(counter.get(c) == 0)
                    counter.remove(c);
            }
            else //if character is not present in the string
                steps++;
        }
        return steps;
    }
}
/****************************/

class Solution {
    public int minSteps(String s, String t) {
        if(s == null || s.length() == 0)
            return t.length();

        int[] counter = new int[26];
        for(int i = 0; i < s.length(); i++)
        {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        int maxStep = 0;
         // Adding the difference where string t has more instances than s.
        // Ignoring where t has fewer instances as they are redundant and
        // can be covered by the first case.
        for(int i = 0; i < 26; i++)
            maxStep += Math.max(0, counter[i]);
        return maxStep;
    }
}
