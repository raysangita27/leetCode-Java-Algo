/*
Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 

Example:

Input: 
board = [
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
words = ["oath","pea","eat","rain"]

Output: ["eat","oath"]
 

Note:

All inputs are consist of lowercase letters a-z.
The values of words are distinct.
*/

class Solution {
    List<String> result;
    public List<String> findWords(char[][] board, String[] words) {
        result = new ArrayList<>();
        TrieNode root = new TrieNode();
        if(board == null || board.length == 0)
            return result;
        for(String word : words)
        {
            insert(word, root);
        }
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                dfs(board, i, j, root);
            }
        }
        return result;
    }
    public void dfs(char[][] board, int i, int j , TrieNode node)
    {
        char c = board[i][j];
        if(c == '#' || node.link[c - 'a'] == null)
            return;
        node = node.link[c-'a'];
        if(node.word != null)
        {
            result.add(node.word);
            node.word =null;
        }
        board[i][j] = '#';
        if(i > 0)
            dfs(board, i -1, j, node);
        if(j > 0)
            dfs(board, i, j-1, node);
        if(i < board.length-1)
            dfs(board, i+1, j, node);
        if(j < board[0].length-1)
            dfs(board, i, j+1, node);
        
        board[i][j] = c;
        
        
    }
    public void insert(String word, TrieNode node)
    {
        for(int i = 0; i < word.length(); i++)
        {
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
