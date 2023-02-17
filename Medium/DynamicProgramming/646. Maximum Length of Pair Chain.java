/*
You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and lefti < righti.

A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this fashion.

Return the length longest chain which can be formed.

You do not need to use up all the given intervals. You can select pairs in any order.

 

Example 1:

Input: pairs = [[1,2],[2,3],[3,4]]
Output: 2
Explanation: The longest chain is [1,2] -> [3,4].
Example 2:

Input: pairs = [[1,2],[7,8],[4,5]]
Output: 3
Explanation: The longest chain is [1,2] -> [4,5] -> [7,8].
 

Constraints:

n == pairs.length
1 <= n <= 1000
-1000 <= lefti < righti <= 1000

*/

class Solution {
    public int findLongestChain(int[][] pairs) {
        if(pairs == null || pairs.length == 0)
            return 0;
        if(pairs.length == 1)
            return 1;

        Arrays.sort(pairs, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2)
            {
                return o1[1] - o2[1];
            }
        });

        int last = Integer.MIN_VALUE;
        int count = 0;
        for(int i = 0; i < pairs.length; i++)
        {
            if(last < pairs[i][0])
            {
                count++;
                last = pairs[i][1];
            }
        }  
        return count;
    }
}
