/*
Given an array of strings words, find the longest string in words such that every prefix of it is also in words.

For example, let words = ["a", "app", "ap"]. The string "app" has prefixes "ap" and "a", all of which are in words.
Return the string described above. If there is more than one string with the same length, return the lexicographically smallest one, and if no string exists, return "".

 

Example 1:

Input: words = ["k","ki","kir","kira", "kiran"]
Output: "kiran"
Explanation: "kiran" has prefixes "kira", "kir", "ki", and "k", and all of them appear in words.
Example 2:

Input: words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
Output: "apple"
Explanation: Both "apple" and "apply" have all their prefixes in words.
However, "apple" is lexicographically smaller, so we return that.
Example 3:

Input: words = ["abc", "bc", "ab", "qwe"]
Output: ""
 

Constraints:

1 <= words.length <= 105
1 <= words[i].length <= 105
1 <= sum(words[i].length) <= 105

*/

class Solution {
   String result = "";
    public String longestWord(String[] words) {
             TrieNode root = new TrieNode();
        for(String word : words)
            addWord(word, root);
        for(String word : words)
            searchPrefix(word, root);
        return result;
    }
    
    public void searchPrefix(String word, TrieNode root)
    {
        TrieNode node = root;
        for(char c : word.toCharArray())
        {
            node = node.link[c-'a'];
            if(!node.isWord)
                return ;
        }
        if(word.length() > result.length() || (word.length()== result.length() && result.compareTo(word) > 0))
            result = word;
    }
    public void addWord(String word, TrieNode root)
    {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);
            if(node.link[c-'a'] == null)
                node.link[c-'a'] = new TrieNode();
            node = node.link[c-'a'];
        }
        node.isWord = true;
    }
}
class TrieNode{
    TrieNode[] link = new TrieNode[26];
    boolean isWord = false;
    TrieNode(){
        
    }
}
