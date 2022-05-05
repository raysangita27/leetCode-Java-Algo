/*
Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 

Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
 

Constraints:

1 <= word.length <= 25
word in addWord consists of lowercase English letters.
word in search consist of '.' or lowercase English letters.
There will be at most 3 dots in word for search queries.
At most 104 calls will be made to addWord and search.

*/

class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray())
        {
            if(node.link[c - 'a'] == null)
                node.link[c - 'a'] = new TrieNode();
            node = node.link[c-'a'];
        }
        node.word = true;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        char[] ch = word.toCharArray();
        return searchInNode(ch, 0, node);
        
    }
    public boolean searchInNode(char[] ch, int ind, TrieNode node)
    {
        if(ind == ch.length)
            return node.word;
        if(ch[ind] != '.' )
        {
            if(node.link[ch[ind]-'a'] != null)
                return searchInNode(ch, ind+1, (node.link[ch[ind]-'a'] ));
            else
                return false;
        }
        else
        {
            for(int i = 0; i < node.link.length ; i++)
            {
                if(node.link[i] != null)
                {
                    if(searchInNode(ch, ind+1, node.link[i]))
                        return true;
                }
            }
        }
        return false;
    }
}
class TrieNode{
    TrieNode[] link = new TrieNode[26];
    boolean word = false;
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
/*
Time Complexity:
addWord() - O(n), n = length of the new word
search() - Worst case: O(m), m = the total number of characters in the Trie
*/
