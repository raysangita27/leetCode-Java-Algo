/*
A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.

Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).

Return a list of all MHTs' root labels. You can return the answer in any order.

The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.

 

Example 1:


Input: n = 4, edges = [[1,0],[1,2],[1,3]]
Output: [1]
Explanation: As shown, the height of the tree is 1 when the root is the node with label 1 which is the only MHT.
Example 2:


Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
Output: [3,4]
 

Constraints:

1 <= n <= 2 * 104
edges.length == n - 1
0 <= ai, bi < n
ai != bi
All the pairs (ai, bi) are distinct.
The given input is guaranteed to be a tree and there will be no repeated edges.

*/

class Solution {
    
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<Integer>();
        if(n < 2)
        {
            for(int i = 0; i < n; i++)
                result.add(i);
            return result;
        }
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        
        for(int[] e: edges)
        {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        ArrayList<Integer> q = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            if(graph.get(i).size() == 1)
                q.add(i);
        }
        int remainingsize = n;
        while(remainingsize > 2)
        {
            remainingsize -= q.size();
            ArrayList<Integer> newQ = new ArrayList<>();
            for(var node : q)
            {
               Integer neighbour = graph.get(node).iterator().next();
                graph.get(neighbour).remove(node);
                if(graph.get(neighbour).size() == 1)
                    newQ.add(neighbour);
            }
            q = newQ;
        }
        return q;
    }
}
/*
Complexity Analysis

Let |V|∣V∣ be the number of nodes in the graph, then the number of edges would be |V| - 1∣V∣−1 as specified in the problem.

Time Complexity: \mathcal{O}(|V|)O(∣V∣)

First, it takes |V|-1∣V∣−1 iterations for us to construct a graph, given the edges.

With the constructed graph, we retrieve the initial leaf nodes, which takes |V|∣V∣ steps.

During the BFS trimming process, we will trim out almost all the nodes (|V|∣V∣) and edges (|V|-1∣V∣−1) from the edges. Therefore, it would take us around |V| + |V| - 1∣V∣+∣V∣−1 operations to reach the centroids.

To sum up, the overall time complexity of the algorithm is \mathcal{O}(|V|)O(∣V∣).

Space Complexity: \mathcal{O}(|V|)O(∣V∣)

We construct the graph with adjacency list, which has |V|∣V∣ nodes and |V|-1∣V∣−1 edges. Therefore, we would need |V| + |V|-1∣V∣+∣V∣−1 space for the representation of the graph.

In addition, we use a queue to keep track of the leaf nodes. In the worst case, the nodes form a star shape, with one centroid and the rest of the nodes as leaf nodes. In this case, we would need |V|-1∣V∣−1 space for the queue.

To sum up, the overall space complexity of the algorithm is also \mathcal{O}(|V|)O(∣V∣).
*/
