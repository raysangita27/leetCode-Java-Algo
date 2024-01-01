/*
Design an algorithm that accepts a stream of characters and checks if a suffix of these characters is a string of a given array of strings words.

For example, if words = ["abc", "xyz"] and the stream added the four characters (one by one) 'a', 'x', 'y', and 'z', your algorithm should detect that the suffix "xyz" of the characters "axyz" matches "xyz" from words.

Implement the StreamChecker class:

StreamChecker(String[] words) Initializes the object with the strings array words.
boolean query(char letter) Accepts a new character from the stream and returns true if any non-empty suffix from the stream forms a word that is in words.
 

Example 1:

Input
["StreamChecker", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query"]
[[["cd", "f", "kl"]], ["a"], ["b"], ["c"], ["d"], ["e"], ["f"], ["g"], ["h"], ["i"], ["j"], ["k"], ["l"]]
Output
[null, false, false, false, true, false, true, false, false, false, false, false, true]

Explanation
StreamChecker streamChecker = new StreamChecker(["cd", "f", "kl"]);
streamChecker.query("a"); // return False
streamChecker.query("b"); // return False
streamChecker.query("c"); // return False
streamChecker.query("d"); // return True, because 'cd' is in the wordlist
streamChecker.query("e"); // return False
streamChecker.query("f"); // return True, because 'f' is in the wordlist
streamChecker.query("g"); // return False
streamChecker.query("h"); // return False
streamChecker.query("i"); // return False
streamChecker.query("j"); // return False
streamChecker.query("k"); // return False
streamChecker.query("l"); // return True, because 'kl' is in the wordlist
 

Constraints:

1 <= words.length <= 2000
1 <= words[i].length <= 200
words[i] consists of lowercase English letters.
letter is a lowercase English letter.
At most 4 * 104 calls will be made to query.

*/

class StreamChecker {
    TrieNode root;
    Deque<Character> stream;
    public StreamChecker(String[] words) {
        root = new TrieNode();
        stream = new ArrayDeque<>();
        for(String word : words)
        {
            insertTrie(word, root);
        }
    }
    
    private void insertTrie(String word, TrieNode root)
    {
        TrieNode current = root;
        for(int i = word.length()-1; i >= 0; i--)  // storing the word reverse order.
        {
            if(!current.link.containsKey(word.charAt(i)))
            {
                current.link.put(word.charAt(i), new TrieNode());
            }
            current = current.link.get(word.charAt(i));
        }
        current.isEndWord = true;
    }

    public boolean query(char letter) {
        stream.addFirst(letter); // processing streaming character in reverse order.
        TrieNode node = root;
        for(char c : stream)
        {
            if(node.isEndWord)
                return true;
            if(!node.link.containsKey(c))
                return false;
            node = node.link.get(c);
        }
        return node.isEndWord;
    }
}

class TrieNode{
    HashMap<Character, TrieNode> link;
    boolean isEndWord;
    TrieNode()
    {
        link = new HashMap<>();
        isEndWord = false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
/*
Storing the words in reverse order in trie
Processing incoming stream in reverse order
*/
