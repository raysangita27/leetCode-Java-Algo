/*
In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.

 

Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
Example 3:

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
*/

class Solution {
     HashMap<Character, Integer> map = new HashMap<>();
    public boolean isAlienSorted(String[] words, String order) {
        int len = words.length;
        if(len == 0 || len == 1)
            return true;
       
        for(int i = 0; i< order.length(); i++)
            map.put(order.charAt(i),i);
        for(int i= 0; i< len-1; i++)
        {
            if(!match(words[i],words[i+1]))
                return false;
        }
        return true;
    }
    boolean match(String word1, String word2)
    {
        int len1 = word1.length();
        int len2 = word2.length();
        int i = 0;
        int j = 0;
        while(i < len1 && j < len2)
        {
            if(word1.charAt(i) == word2.charAt(j))
            {
                i++;
                j++;
            }
            else if(map.get(word1.charAt(i))> map.get(word2.charAt(j)))
                return false;
            else
                return true;
        }
        if(len1 > len2)
            return false;
        return true;
    }
}
