/*
You are given a string s that consists of lower case English letters and brackets. 

Reverse the strings in each pair of matching parentheses, starting from the innermost one.

Your result should not contain any brackets.

 

Example 1:

Input: s = "(abcd)"
Output: "dcba"
Example 2:

Input: s = "(u(love)i)"
Output: "iloveu"
Explanation: The substring "love" is reversed first, then the whole string is reversed.
Example 3:

Input: s = "(ed(et(oc))el)"
Output: "leetcode"
Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.
Example 4:

Input: s = "a(bcdefghijkl(mno)p)q"
Output: "apmnolkjihgfedcbq"
 

Constraints:

0 <= s.length <= 2000
s only contains lower case English characters and parentheses.
It's guaranteed that all parentheses are balanced.
*/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length  == 0)
            return nums;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int a : nums)
        {
            if(map.containsKey(a) )
                map.put(a, map.get(a)+1 );
            else
                map.put(a, 1);
        }
        List<Map.Entry<Integer,Integer>> list = new  ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer,Integer>>(){
            public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2){
                if(o1.getValue() == o2.getValue())
                    return o2.getKey() - o2.getKey();
                else 
                    return o2.getValue() - o1.getValue();
            }
        } );
        
        int i = 0;
        int[] result = new int[k];
        for(var l : list)
        {
            if(i == k)
                break;
            result[i++] = l.getKey();
            
        }
        return result;
    }
}
