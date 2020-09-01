/*
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
*/

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.length() == 0 || endWord.length() == 0 || wordList.size() == 0)
            return 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(1, beginWord));
        while(!queue.isEmpty())
        {
            var cur = queue.poll();
            Iterator<String> itr = wordList.iterator();
            while(itr.hasNext())
            {
                String temp = itr.next();
                if(checkNext(temp, cur.str))
                {
                    itr.remove();
                    if(temp.equals(endWord))
                        return cur.len+1;
                    else
                        queue.offer(new Pair(cur.len+1, temp));
                }   
            }
        }
         return 0;
    }
    private boolean checkNext(String a, String b)
    {
        int count = 0;
        for(int i = 0 ; i< a.length(); i++)
        {
            if(a.charAt(i) != b.charAt(i))
                count++;
            if(count > 1)
                return false;
        }
        return count >1 ? false : true;
    }
    private class Pair
    {
        int len;
        String str;
        Pair(int len, String str)
        {
            this.len = len;
            this.str = str;
        }
    }
}
