/*
We want to split a group of n people (labeled from 1 to n) into two groups of any size. Each person may dislike some other people, and they should not go into the same group.

Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that the person labeled ai does not like the person labeled bi, return true if it is possible to split everyone into two groups in this way.

 

Example 1:

Input: n = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4] and group2 [2,3].
Example 2:

Input: n = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false
Example 3:

Input: n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
Output: false
 

Constraints:

1 <= n <= 2000
0 <= dislikes.length <= 104
dislikes[i].length == 2
1 <= dislikes[i][j] <= n
ai < bi
All the pairs of dislikes are unique.

*/

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        if(dislikes == null || dislikes.length == 0)
            return true;
        int len = dislikes.length;
        
      
        int[] color = new int[n+1];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        for(int[] e : dislikes)
        {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        for(int i = 1 ; i <= n; i++)
        {
            if(color[i] != 0)
                continue;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            color[i] = 1;
            while(!q.isEmpty())
            {
                int cur = q.remove();
                for(int next : graph.get(cur))
                {
                    if(color[next] == 0)
                    {
                        color[next] = -color[cur];
                        q.add(next);
                    }
                    else
                    {
                         if(color[next] != -color[cur])
                            return false;
                    }
                }
            }
        }
        return true;
    }
}
