/*
Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.

If possible, output any possible result.  If not possible, return the empty string.

Example 1:

Input: S = "aab"
Output: "aba"
Example 2:

Input: S = "aaab"
Output: ""
Note:

S will consist of lowercase letters and have length in range [1, 500].
*/
class Solution {
    public String reorganizeString(String S) {
        int len = S.length();
        if(len == 0)
            return "";
        int[] count = new int[26];
        for(int i = 0; i < len; i++)
        {
            count[S.charAt(i) -'a']++;
        }
        int max = 0;
        int letter = 0;
        for(int i = 0; i <26 ; i ++)
        {
            if(count[i] > max)
            {
                max = count[i];
                letter = i;
                
            }
        }
        if(max > (len +1)/2)
            return "";
        char[] result = new char[S.length()];
        int ind = 0;
        while(count[letter] > 0)
        {
            result[ind] = (char)(letter +'a');
            ind += 2;
            count[letter]--;
            
        }
        for(int i = 0; i < 26; i++)
        {
            while(count[i] > 0)
            {
                if(ind >= len)
                    ind = 1;
            
            result[ind] = (char)(i + 'a');
            ind += 2;
            count[i]--;
            }
        }
        return String.valueOf(result);
        
        
    }
}

//TimeComplexity : O(n)
/*
No Sort O(N):

count letter appearance and store in hash[i]
find the letter with largest occurence.
put the letter into even index numbe (0, 2, 4 ...) char array
put the rest into the array
*/

/*********************using priority Queue*********************
    class Solution {
    public String reorganizeString(String s) {
        if(s == null || s.length() == 0)
            return s;
        int[] freq = new int[26];
        int maxFreq = 0;
        
        for(char c : s.toCharArray())
        {
            freq[c-'a'] ++;
            maxFreq = Math.max(maxFreq, freq[c-'a']);
        }
        int len = s.length();   
        if(maxFreq > (len+1)/2)
            return "";
        
        PriorityQueue<Pair<Character, Integer>> pQ = new PriorityQueue<>(len,new Comparator<Pair<Character, Integer>>(){
            public int compare(Pair<Character, Integer> o1, Pair<Character, Integer> o2)
            {
                return o2.getValue()-o1.getValue();
            }
        });
        for(int i = 0; i < 26; i++)
        {
            if(freq[i] > 0)
            {
                pQ.add(new Pair<Character, Integer>((char)(i+'a'), freq[i]));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!pQ.isEmpty())
        {
            var cur = pQ.remove();
            int count = cur.getValue();
            if(sb.isEmpty() || sb.charAt(sb.length()-1) != cur.getKey()){
                sb.append(cur.getKey());
                count--;
                if(count > 0)
                    pQ.add(new Pair<>(cur.getKey(), count));
            }
            else
            {
                if(pQ.isEmpty())
                    return "";
                var second = pQ.remove();
                sb.append(second.getKey());
                
                if((second.getValue()-1) > 0)
                    pQ.add(new Pair<>(second.getKey(), (second.getValue()-1)));
                
                pQ.add(cur);

            }
        }
        return sb.toString();
    }
}
