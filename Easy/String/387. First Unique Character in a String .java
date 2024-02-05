/*
Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode"
return 2.
 

Note: You may assume the string contains only lowercase English letters.
*/
class Solution {
    public int firstUniqChar(String s) {
        int len = s.length();
        if(len == 0)
            return -1;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < len; i++)
        {
            if(map.containsKey(s.charAt(i) ) )
                map.put(s.charAt(i), map.get(s.charAt(i))+1 );
            else
                map.put(s.charAt(i), 1);
        }
        for(int i = 0; i < len; i++)
        {
            if(map.get(s.charAt(i) ) == 1)
                return i;
        }
        return -1;
    }
}

/********************** **************/
/*
Implementation without additional memory. 
*/

class Solution {
     public int firstUniqChar(String s) {
        // Stores lowest index / first index
        int ans = Integer.MAX_VALUE;
        // Iterate from a to z which is 26 which makes it constant
        for(char c='a'; c<='z';c++){
            // indexOf will return first index of alphabet and lastIndexOf will return last index
            // if both are equal then it has occured only once.
            // through this we will get all index's which are occured once
            // but our answer is lowest index
            int index = s.indexOf(c);
            if(index!=-1&&index==s.lastIndexOf(c)){
                ans = Math.min(ans,index);
            }
        }

        // If ans remain's Integer.MAX_VALUE then their is no unique character
        return ans==Integer.MAX_VALUE?-1:ans;
    }   
}
