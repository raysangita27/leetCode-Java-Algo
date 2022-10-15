/*
You are given a directed graph of n nodes numbered from 0 to n - 1, where each node has at most one outgoing edge.

The graph is represented with a given 0-indexed array edges of size n, indicating that there is a directed edge from node i to node edges[i]. If there is no outgoing edge from node i, then edges[i] == -1.

Return the length of the longest cycle in the graph. If no cycle exists, return -1.

A cycle is a path that starts and ends at the same node.

 

Example 1:


Input: edges = [3,3,4,2,3]
Output: 3
Explanation: The longest cycle in the graph is the cycle: 2 -> 4 -> 3 -> 2.
The length of this cycle is 3, so 3 is returned.
Example 2:


Input: edges = [2,-1,3,1]
Output: -1
Explanation: There are no cycles in this graph.
 

Constraints:

n == edges.length
2 <= n <= 105
-1 <= edges[i] < n
edges[i] != i
*/

class Solution {
    public int longestCycle(int[] edges) {
        if(edges == null || edges.length == 0)
            return 0;
        List<List<Integer>> graph = new ArrayList<>();
        int n = edges.length;
        int[] indegree = new int[n];
        
        for(int i = 0; i < n; i++)
        {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < n; i++){
             if(edges[i] != -1){
                graph.get(i).add(edges[i]);
                indegree[edges[i]]++;
             }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++)
        {
            if(indegree[i] == 0)
                q.add(i);
        }
        while(!q.isEmpty())
        {
            int cur = q.poll();
            for(var next : graph.get(cur))
            {
                indegree[next]--;
                if(indegree[next] == 0)
                    q.add(next);
            }
        }
        int maxLen  = -1;
        for(int i = 0; i < edges.length; i++)
        {
            if(indegree[i] != 0)
            {
                maxLen = Math.max(maxLen, findLength(indegree, i, edges));
            }
        }
        return maxLen;
    }
    public int findLength(int[] indegree, int current, int[]edges)
    {
        int length = 0;
        while(indegree[current] != 0)
        {
            indegree[current]--;
            current = edges[current];
            length++;
        }
        return length;
    }
}

