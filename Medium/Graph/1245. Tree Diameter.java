/*
The diameter of a tree is the number of edges in the longest path in that tree.

There is an undirected tree of n nodes labeled from 0 to n - 1. You are given a 2D array edges where edges.length == n - 1 and edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the tree.

Return the diameter of the tree.

 

Example 1:


Input: edges = [[0,1],[0,2]]
Output: 2
Explanation: The longest path of the tree is the path 1 - 0 - 2.
Example 2:


Input: edges = [[0,1],[1,2],[2,3],[1,4],[4,5]]
Output: 4
Explanation: The longest path of the tree is the path 3 - 2 - 1 - 4 - 5.
 

Constraints:

n == edges.length + 1
1 <= n <= 104
0 <= ai, bi < n
ai != bi
*/

class Solution {
    public int treeDiameter(int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < edges.length +1; i++)
            graph.add(new ArrayList<>());
        
        for(int[] e : edges)
        {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        int[] nodeDist = bfs(0, graph);
        nodeDist =  bfs(nodeDist[0], graph);
        return nodeDist[1];
        
    }
    private int[] bfs(int start, List<List<Integer>> graph)
    {
        boolean[] visited = new boolean[graph.size()];
        visited[start] = true;
        int distance = -1;
        int lastNode = start;
        
        LinkedList<Integer> q = new LinkedList<>();
        q.addLast(start);
        while(q.size() > 0)
        {
            LinkedList<Integer> newQ = new LinkedList<>();
            while(q.size() > 0)
            {
                int nextNode = q.removeFirst();
                for(var n : graph.get(nextNode))
                {
                    if(!visited[n] ){
                    visited[n] = true;
                    newQ.addLast(n);
                    lastNode = n;
                    }
                }
            }
            q = newQ;
            distance += 1;
        }
        return new int[]{lastNode , distance};
        
    }
}
/*
Time Complexity: \mathcal{O}(N)O(N)

Space Complexity: \mathcal{O}(N)O(N)

*/
