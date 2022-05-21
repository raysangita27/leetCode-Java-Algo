/*
You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph.

Return the number of connected components in the graph.

 

Example 1:


Input: n = 5, edges = [[0,1],[1,2],[3,4]]
Output: 2
Example 2:


Input: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
Output: 1
 

Constraints:

1 <= n <= 2000
1 <= edges.length <= 5000
edges[i].length == 2
0 <= ai <= bi < n
ai != bi
There are no repeated edges.
*/

//==========================================DFS Implementation=======================================

class Solution {
    public int countComponents(int n, int[][] edges) {
       
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i < n; i++)
        {
            graph.add(new ArrayList<Integer>());
        }
        for(int [] e : edges)
        {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[n];
        int compCount = 0;
        
        for(int i = 0; i < n; i++)
        {
            if(visited[i] == false)
            {
                compCount++;
                dfs(visited, i, graph);
            }
        }
        return compCount;
    }
    
    public void dfs(boolean[] visited, int vertex, ArrayList<ArrayList<Integer>> graph )
    {
        visited[vertex] = true;
        for(int node : graph.get(vertex))
        {
            if(visited[node] == false)
                dfs(visited, node, graph);
        }
    }
}
/*
Time Complexity : O(E+V)
Space Complexity: O(E+V)

