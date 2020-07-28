/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
Note:
You may assume both s and t have the same length.
*/

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int len = s.length();
        String encodeKey = findEncoding(s);
        if(len == t.length() && encodeKey.equals(findEncoding(t)))
            return true;
        else
            return false;
    }
    String findEncoding(String s)
    {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        for(char c : s.toCharArray())
        {
            if(!map.containsKey(c))
                map.put(c,i++);
        }
        String temp = "";
        for(int k = 0; k< s.length(); k++)
        {
            temp += map.get(s.charAt(k));
        }
        return temp;
    }
}
