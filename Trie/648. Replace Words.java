/*In English, we have a concept called root, which can be followed by some other word to form another longer word - let's call this word successor. For example, when the root "an" is followed by the successor word "other", we can form a new word "another".

Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces, replace all the successors in the sentence with the root forming it. If a successor can be replaced by more than one root, replace it with the root that has the shortest length.

Return the sentence after the replacement.

 

Example 1:

Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"
Example 2:

Input: dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
Output: "a a b c"
 

Constraints:

1 <= dictionary.length <= 1000
1 <= dictionary[i].length <= 100
dictionary[i] consists of only lower-case letters.
1 <= sentence.length <= 106
sentence consists of only lower-case letters and spaces.
The number of words in sentence is in the range [1, 1000]
The length of each word in sentence is in the range [1, 1000]
Every two consecutive words in sentence will be separated by exactly one space.
sentence does not have leading or trailing spaces.
*/

class Solution {
    TrieNode root ;
    public String replaceWords(List<String> dictionary, String sentence) {
        if(dictionary == null || dictionary.size() == 0) 
            return "";
        root = new TrieNode();
        for(String word : dictionary)
        {
            insertWord(word);
        }
        
        StringBuilder ans = new StringBuilder();
        
        for(String word : sentence.split(" "))
        {
            if(ans.length() > 0)
                ans.append(" ");
            TrieNode node = root;
            for(char c : word.toCharArray())
            {
                if(node.word != null || node.link[c-'a'] == null)
                    break;
                node = node.link[c-'a'];
            }
            ans.append(node.word == null ? word : node.word);
        }
        return ans.toString();
        
    }
    public void insertWord(String word)
    {
        TrieNode node = root;
        for(char c: word.toCharArray())
        {
            if(node.link[c-'a'] == null)
                node.link[c - 'a'] = new TrieNode();
            node = node.link[c-'a'];
        }
        node.word = word;
    }
}
class TrieNode{
    TrieNode[] link = new TrieNode[26];
    String word;
}

/*
Complexity Analysis

Time Complexity: O(N)O(N) where NN is the length of the sentence. Every query of a word is in linear time.

Space Complexity: O(N)O(N), the size of our trie.
*/
