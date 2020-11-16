/*
Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
*/

class Trie {
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    public int getIndex(char c)
    {
        return c-'a';
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word == null)
        {
            System.out.println("null can not be inserted");
            return;
        }
        String key = word.toLowerCase();
        TrieNode current = root;
        for(int i = 0; i < key.length(); i++)
        {
            int index = getIndex(key.charAt(i));
            if(current.children[index] == null)
            {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.markAsLeaf();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word == null)
            return false;
        TrieNode current = root;
        int index = 0;
        for(int i = 0; i < word.length(); i++)
        {
            index = getIndex(word.charAt(i));
            if(current.children[index] == null)
                return false;
            current = current.children[index] ;
        }
        return current.isEndWord();        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix == null)
            return false;
        TrieNode current = root;
        int index = 0;
        for(int i = 0; i < prefix.length(); i++)
        {
            index = getIndex(prefix.charAt(i));
            if(current.children[index] == null)
                return false;
            current = current.children[index] ;
        }
        return current != null;
        
    }
}
class TrieNode {
    public TrieNode[] children;
    private final int size = 26;
    private boolean isEndWord;
    
    public TrieNode()
    {
        this.isEndWord = false;
        this.children = new TrieNode[size];
    }
    
    public void markAsLeaf()
    {
        this.isEndWord = true;
        
    }
    public boolean isEndWord()
    {
        return this.isEndWord;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
