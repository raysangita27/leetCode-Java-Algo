/*
In this problem, a rooted tree is a directed graph such that, there is exactly one node (the root) for which all other nodes are descendants of this node, plus every node has exactly one parent, except for the root node which has no parents.

The given input is a directed graph that started as a rooted tree with n nodes (with distinct values from 1 to n), with one additional directed edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed.

The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [ui, vi] that represents a directed edge connecting nodes ui and vi, where ui is a parent of child vi.

Return an edge that can be removed so that the resulting graph is a rooted tree of n nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array.

 

Example 1:


Input: edges = [[1,2],[1,3],[2,3]]
Output: [2,3]
Example 2:


Input: edges = [[1,2],[2,3],[3,4],[4,1],[1,5]]
Output: [4,1]
 

Constraints:

n == edges.length
3 <= n <= 1000
edges[i].length == 2
1 <= ui, vi <= n
ui != vi

*/

class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
		if(edges == null || edges.length == 0)
			return new int[]{};
		
		int n =edges.length;
		int[] candidateA = new int[2];
		int[] candidateB = new int[2];
		int[] parent = new int[n+1];

		for(int[]e : edges)
		{
			if(parent[e[1]] == 0)
				parent[e[1]] = e[0];
			else
			{ // if 2 parent exists for a node . we are setting 2 edges as 2 cadidates. and marking second edge as invalid.
				candidateA[0] = parent[e[1]];
				candidateA[1] = e[1];

				candidateB[0] = e[0];
				candidateB[1] = e[1];
				e[1] = 0; //marking second edge as invalid.

			}
		}
// setting up union find algo to check cycle.
			for(int i = 1; i <= n; i++)
			{
				parent[i] = i;
			}

			for(int[] e : edges)
			{
				int start = e[0];
				int end = e[1];

				if(find(start, parent) == end)
				{
					if(candidateA[0] != 0) // if cercle exists , if A is available returning A , else returing the current edge which is causing circle
						return candidateA ;
					return e;
				}
				parent[end] = start;
			}
		
		return candidateB; // if there is no cycle B is the targetted edge.
			
    }
	public int find(int i, int[] parent)
	{
		if(parent[i] == i)
		{
			return i;
		}
		return find(parent[i], parent);
	}
}

/*

There are two cases for the tree structure to be invalid.
1) A node having two parents;
2) A circle exists

validation.
1) Check whether there is a node having two parents. 
    If so, store them as candidates A and B, and set the second edge invalid. 
2) Perform normal union find. 
    If the tree is now valid 
           simply return candidate B
    else if candidates not existing 
           we find a circle, return current edge; 
    else 
           remove candidate A instead of B.
  */
