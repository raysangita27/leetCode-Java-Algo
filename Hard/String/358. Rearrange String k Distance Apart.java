/*
Given a string s and an integer k, rearrange s such that the same characters are at least distance k from each other. If it is not possible to rearrange the string, return an empty string "".

 

Example 1:

Input: s = "aabbcc", k = 3
Output: "abcabc"
Explanation: The same letters are at least a distance of 3 from each other.
Example 2:

Input: s = "aaabc", k = 3
Output: ""
Explanation: It is not possible to rearrange the string.
Example 3:

Input: s = "aaadbbcc", k = 2
Output: "abacabcd"
Explanation: The same letters are at least a distance of 2 from each other.
 

Constraints:

1 <= s.length <= 3 * 105
s consists of only lowercase English letters.
0 <= k <= s.length

*/

class Solution {
    public String rearrangeString(String s, int k) {
        if(s == null || s.length() == 0 || k == 0)
            return s;    
        
        HashMap<Character, Integer> charFreq = new HashMap<>();

        for(char c : s.toCharArray())
            charFreq.put(c, charFreq.getOrDefault(c, 0)+1);
        

        PriorityQueue<Map.Entry<Character, Integer>> charHeap = new PriorityQueue<>(
         new Comparator<Map.Entry<Character, Integer>>(){
            public int compare(Map.Entry<Character, Integer> item1, Map.Entry<Character, Integer> item2)
            {
                return item2.getValue() - item1.getValue();
            }
        });

        charHeap.addAll(charFreq.entrySet());
        Queue<Map.Entry<Character, Integer>> waitQueue = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        while(!charHeap.isEmpty())
        {
            var item = charHeap.poll();
            sb.append(item.getKey());
            item.setValue(item.getValue()-1);
            waitQueue.add(item);
            if(waitQueue.size() < k)
                continue;
            
            var nextItem = waitQueue.poll();
            if(nextItem.getValue() > 0)
                charHeap.add(nextItem);
        }
        return sb.length() == s.length() ? sb.toString() : "";
    }
}


/*
TimeComplexity : O(n(log(n))
*/
