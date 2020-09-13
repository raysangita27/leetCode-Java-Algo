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

public List<String> findWords(char[][] board, String[] words) {
	List<String> res = new ArrayList<>();

	for (String word : words) {
		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0) && exist(board, visited, i, j, word, 0)) {
					if (!res.contains(word))
						res.add(word);
				}
			}
		}
	}
	return res;
}

private boolean exist(char[][] board, boolean[][] visited, int i, int j, String s, int index) {
	if (index == s.length())
		return true;
	//false case
	if (i < 0 || i >= board.length || j < 0 || 
		j >= board[0].length || visited[i][j] || board[i][j] != s.charAt(index)) {
		return false;
	}

	visited[i][j] = true;
	if (exist(board, visited, i + 1, j, s, index + 1) ||
		exist(board, visited, i - 1, j, s, index + 1) ||
		exist(board, visited, i, j + 1, s, index + 1) ||
		exist(board, visited, i, j - 1, s, index + 1)) {
		return true;
	}
	visited[i][j] = false;

	return false;
}
