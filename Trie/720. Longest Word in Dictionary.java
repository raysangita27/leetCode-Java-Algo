/*
Given an array of strings words representing an English Dictionary, return the longest word in words that can be built one character at a time by other words in words.

If there is more than one possible answer, return the longest word with the smallest lexicographical order. If there is no answer, return the empty string.

 

Example 1:

Input: words = ["w","wo","wor","worl","world"]
Output: "world"
Explanation: The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
Example 2:

Input: words = ["a","banana","app","appl","ap","apply","apple"]
Output: "apple"
Explanation: Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
 

Constraints:

1 <= words.length <= 1000
1 <= words[i].length <= 30
words[i] consists of lowercase English letters.
*/

class Solution {
    String result = "";
    public String longestWord(String[] words) {
        if(words == null || words.length == 0)
            return "";
        TrieNode root = new TrieNode();
        for(String word : words)
            insert(word, root);
        dfs(root);
        return result;
    }
    public void dfs(TrieNode node )
    {
        if(node == null)
            return;
        if(node.word != null)
        {
            if(node.word.length() > result.length())
                result = node.word;
            else if(node.word.length() == result.length() && node.word.compareTo(result) < 0)
            {
                result = node.word;
            }
        }
        
        for(var child : node.link)
        {
            if(child != null && child.word != null)
                dfs(child);
        }
    }
    public void insert(String word, TrieNode node)
    {
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(node.link[c - 'a'] == null)
                node.link[c - 'a'] = new TrieNode();
            node = node.link[c - 'a'];
        }
        node.word = word;
    }
    
}
class TrieNode{
    TrieNode[] link = new TrieNode[26];
    String word;
    TrieNode(){};
}
