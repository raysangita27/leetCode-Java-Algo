/*
You are given an undirected weighted graph of n nodes (0-indexed), represented by an edge list where edges[i] = [a, b] is an undirected edge connecting the nodes a and b with a probability of success of traversing that edge succProb[i].

Given two nodes start and end, find the path with the maximum probability of success to go from start to end and return its success probability.

If there is no path from start to end, return 0. Your answer will be accepted if it differs from the correct answer by at most 1e-5.

 

Example 1:



Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2
Output: 0.25000
Explanation: There are two paths from start to end, one having a probability of success = 0.2 and the other has 0.5 * 0.5 = 0.25.
Example 2:



Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.3], start = 0, end = 2
Output: 0.30000
Example 3:



Input: n = 3, edges = [[0,1]], succProb = [0.5], start = 0, end = 2
Output: 0.00000
Explanation: There is no path between 0 and 2.
 

Constraints:

2 <= n <= 10^4
0 <= start, end < n
start != end
0 <= a, b < n
a != b
0 <= succProb.length == edges.length <= 2*10^4
0 <= succProb[i] <= 1
There is at most one edge between every two nodes.

*/

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        HashMap<Integer, List<Pair<Double,Integer>>> graph = new HashMap<>();

        for(int i = 0; i < edges.length; i++)
        {
            if(!graph.containsKey(edges[i][0]))
                graph.put(edges[i][0], new ArrayList<>());
            graph.get(edges[i][0]).add(new Pair<>(succProb[i], edges[i][1]));
            if(!graph.containsKey(edges[i][1]))
                graph.put(edges[i][1], new ArrayList<>());
            graph.get(edges[i][1]).add(new Pair<>(succProb[i], edges[i][0]));
        }

        double[] maxProb = new double[n];
        maxProb[start_node] = 1d;
        PriorityQueue<Pair<Double, Integer>> pQ = new PriorityQueue<>((a,b)-> Double.compare(b.getKey() , a.getKey()));
        pQ.add(new Pair<>(1.0, start_node));
        while(!pQ.isEmpty())
        {
            var cur = pQ.poll();
            double currentProbability = cur.getKey();
            int curNode = cur.getValue();
            if(curNode == end_node)
                return currentProbability;
            for(Pair<Double, Integer> next : graph.getOrDefault(curNode, new ArrayList<>()))
            {
                int nextNode = next.getValue();
                double nextProb = next.getKey();
                if(nextProb * currentProbability > maxProb[nextNode])
                {
                    maxProb[nextNode] = nextProb * currentProbability;
                    pQ.add(new Pair<>(maxProb[nextNode], nextNode));
                }
            }
        }
        return 0d;
    }
}

/*
Time complexity: O(m+n⋅log⁡n)
Dijkstra Algo
*/
