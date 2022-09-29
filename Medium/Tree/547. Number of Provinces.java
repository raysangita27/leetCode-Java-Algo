/*
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.

 

Example 1:


Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
Example 2:


Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
 

Constraints:

1 <= n <= 200
n == isConnected.length
n == isConnected[i].length
isConnected[i][j] is 1 or 0.
isConnected[i][i] == 1
isConnected[i][j] == isConnected[j][i]

*/
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] parent = new int[n];
        int[] rank = new int[n];
        for(int i = 0; i < n; i++)
        {
            parent[i] = -1;
            rank[i] = -1;
        }
        int connected = n;
        for(int i = 0; i < isConnected.length; i++)
        {
            for(int j = 0; j < isConnected[0].length; j++)
            {
                if(isConnected[i][j] == 1 && i != j)
                {
                    int start = find(i, parent);
                    int end = find(j, parent);
                    if(start != end)
                        connected -= union(start, end, parent, rank);
                }
            }
        }
        // int count = 0;
        // for(int i= 0; i < n; i++)
        // {
        //     if(parent[i] == -1)
        //         count++;
        // }
        // return count;
        return  connected;
    }
    private int find(int i, int[] parent)
    {
        if(parent[i] == -1)
            return i;
        return find(parent[i], parent);
    }
    public int union(int start, int end, int[] parent, int[] rank)
    {
        if(rank[start] > rank[end])
        {
            parent[end] = start;
            rank[start] += rank[end];
        }
        else
        {
            parent[start] = end;
            rank[end] += rank[start];
        }
        return 1;
    }
}
