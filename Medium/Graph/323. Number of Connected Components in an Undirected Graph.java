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

/*******************************************union fold**********************************************************/
class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] represnt = new int[n];
        int[] rank = new int[n];
        for(int i = 0; i < n; i++)
        {
            represnt[i] = i;
            rank[i] = 1;
        }
        int compCount = n;
        for(int[]e : edges)
        {
            compCount -= findComp(represnt, rank, e[0], e[1]);
        }
        return compCount;
    }
    public int findComp(int[] rep, int[] rank, int start, int end)
    {
        int startX = find(rep, start);
        int endX = find(rep, end);
        if(startX == endX)
            return 0;
        else{
        if(rank[startX] < rank[endX])
        {
            rep[startX] = endX;
            rank[endX] += rank[startX];
        }
        else{
             rep[endX] = startX;
            rank[startX] += rank[endX];    
            }
            return 1;
        }
            
        
    }
    public int find(int[] rep, int index){
        if(rep[index] == index)
            return index;
        return find(rep, rep[index]);
    }
}
/*
Here EE = Number of edges, VV = Number of vertices.

Time complexity: O(E\cdotα(n))O(E⋅α(n)).

Iterating over every edge requires O(E)O(E) operations, and for every operation, we are performing the combine method which is O(α(n))O(α(n)), where α(n) is the inverse Ackermann function.

Space complexity: O(V)O(V).

Storing the representative/immediate-parent of each vertex takes O(V)O(V) space. Furthermore, storing the size of components also takes O(V)O(V) space.

*/

