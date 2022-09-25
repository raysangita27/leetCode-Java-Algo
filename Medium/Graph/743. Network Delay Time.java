/*
You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.

 

Example 1:


Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2
Example 2:

Input: times = [[1,2,1]], n = 2, k = 1
Output: 1
Example 3:

Input: times = [[1,2,1]], n = 2, k = 2
Output: -1
 

Constraints:

1 <= k <= n <= 100
1 <= times.length <= 6000
times[i].length == 3
1 <= ui, vi <= n
ui != vi
0 <= wi <= 100
All the pairs (ui, vi) are unique. (i.e., no multiple edges.)
*/
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<Pair<Integer,Integer>>> map = new HashMap<>();
        int[] arrivalTime = new int[n+1];
        Arrays.fill(arrivalTime, Integer.MAX_VALUE);
        
        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        arrivalTime[k] = 0;
        
        for(int[] time : times)
        {
            if(!map.containsKey(time[0]))
                map.put(time[0], new ArrayList<>());
            map.get(time[0]).add(new Pair<>(time[1],time[2]));
        }
        
        while(!q.isEmpty())
        {
            int curnode = q.remove();
            if(!map.containsKey(curnode))
                continue;
            for(Pair<Integer,Integer> neighbour : map.get(curnode))
            {
                int dest = neighbour.getKey();
                int time = arrivalTime[curnode]  + neighbour.getValue();
                if(time < arrivalTime[dest] ){
                    arrivalTime[dest] = time;
                    q.add(dest);
                }
            }
        }
         int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, arrivalTime[i]);
        }
        return  answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
