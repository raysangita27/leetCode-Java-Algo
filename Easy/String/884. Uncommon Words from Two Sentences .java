/*
We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)

A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.

Return a list of all uncommon words. 

You may return the list in any order.

 

Example 1:

Input: A = "this apple is sweet", B = "this apple is sour"
Output: ["sweet","sour"]
Example 2:

Input: A = "apple apple", B = "banana"
Output: ["banana"]
 

Note:

0 <= A.length <= 200
0 <= B.length <= 200
A and B both contain only spaces and lowercase letters.
*/
class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        if(A.length()== 0)
            return B.split(" ");
        if(B.length()== 0)
            return A.split(" ");
        HashMap<String, Integer> map = new  HashMap<String, Integer>();
        List<String> result = new ArrayList<String>();
        for(String s : A.split(" ") )
        {
            if(map.containsKey(s))
                map.put(s, map.get(s)+1 );
            else
                map.put(s,1);
        }
        for(String s : B.split(" ") )
        {
            if(map.containsKey(s))
                map.put(s, map.get(s)+1 );
            else
                map.put(s,1);
        }
        for(String k : map.keySet())
        {
            if(map.get(k)==1)
                result.add(k);
        }
        String[] uncommon = new String[result.size()];
        int i = 0;
        for(String x: result)
        {
            uncommon[i++] = x;
        }
        return uncommon;
    }
}
