/*
Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made.

It is guaranteed that the answer is unique.

 

Example 1:

Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.
Example 2:

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation: 
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
Example 3:

Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"
 

Constraints:

1 <= s.length <= 10^5
2 <= k <= 10^4
s only contains lower case English letters.
*/
class Solution {
    public String removeDuplicates(String s, int k) {
        LinkedList<Node> stack = new LinkedList<Node>();
        for(char p : s.toCharArray())
        {
            if(!stack.isEmpty() && stack.peek().c == p)
                stack.peek().freq++;
            else
            {
                stack.push(new Node(1,p));
            }
            if(stack.peek().freq == k)
                stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(stack.size()>0)
        {
            var item = stack.removeLast();
            for(int i = 0; i< item.freq; i++)
                sb.append(item.c);
        }
        return sb.toString();
    }
}
class Node{
    int freq;
    char c;
    Node(int freq, char c)
    {
        this.freq = freq;
        this.c = c;
    }
}

/****** using stringbuilder as stack and counter array to many frequency*****/

class Solution {
    public String removeDuplicates(String s, int k) {
        if(s == null || s.length() == 0)
            return "";
        
        int[] count = new int[s.length()];
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray())
        {
            sb.append(c);
            int last = sb.length()-1;
            if(last > 0 && sb.charAt(last) == sb.charAt(last-1))
                count[last] = count[last-1]+1;
            else    
                count[last] = 1;
            if(count[last] >= k)
                sb.delete(sb.length()-k, sb.length());
        }

        return sb.toString();
    }
}
