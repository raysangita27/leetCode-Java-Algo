/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 

Constraints:

board and word consists only of lowercase and uppercase English letters.
1 <= board.length <= 200
1 <= board[i].length <= 200
1 <= word.length <= 10^3
*/

class Solution {
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0)
            return false;
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
                if(word.charAt(0) == board[i][j] && search(board,word,i,j,0))
                    return true;
            }
        }
        return false;
    }
    boolean search(char[][] board, String word, int i, int j, int ind)
    {
        if(ind == word.length())
            return true;
        if(i <0 || j <0 ||i >= board.length|| j >=board[0].length || visited[i][j] || word.charAt(ind) != board[i][j] )
            return false;
        visited[i][j] = true;
        if(search(board, word, i, j+1, ind+1) || search(board, word, i, j-1, ind+1) || search(board, word, i+1, j, ind+1) || search(board, word, i-1, j, ind+1))
            return true;
        visited[i][j] = false;
        return false;
    }
}
