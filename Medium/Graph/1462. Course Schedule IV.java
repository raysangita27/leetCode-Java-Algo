/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course ai first if you want to take course bi.

For example, the pair [0, 1] indicates that you have to take course 0 before you can take course 1.
Prerequisites can also be indirect. If course a is a prerequisite of course b, and course b is a prerequisite of course c, then course a is a prerequisite of course c.

You are also given an array queries where queries[j] = [uj, vj]. For the jth query, you should answer whether course uj is a prerequisite of course vj or not.

Return a boolean array answer, where answer[j] is the answer to the jth query.

 

Example 1:


Input: numCourses = 2, prerequisites = [[1,0]], queries = [[0,1],[1,0]]
Output: [false,true]
Explanation: The pair [1, 0] indicates that you have to take course 1 before you can take course 0.
Course 0 is not a prerequisite of course 1, but the opposite is true.
Example 2:

Input: numCourses = 2, prerequisites = [], queries = [[1,0],[0,1]]
Output: [false,false]
Explanation: There are no prerequisites, and each course is independent.
Example 3:


Input: numCourses = 3, prerequisites = [[1,2],[1,0],[2,0]], queries = [[1,0],[1,2]]
Output: [true,true]
 

Constraints:

2 <= numCourses <= 100
0 <= prerequisites.length <= (numCourses * (numCourses - 1) / 2)
prerequisites[i].length == 2
0 <= ai, bi <= n - 1
ai != bi
All the pairs [ai, bi] are unique.
The prerequisites graph has no cycles.
1 <= queries.length <= 104
0 <= ui, vi <= n - 1
ui != vi
*/

class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean>  result = new ArrayList<>();
        if(queries == null || queries.length == 0)
            return result;
        for(int i = 0; i < queries.length; i++)
            result.add(false);
        if(prerequisites == null || prerequisites.length == 0)
            return result;
        
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        HashMap<Integer, Set<Integer>> prereq = new HashMap<>();
        
        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++)
        {
            graph.add(new ArrayList<>());
            prereq.put(i, new HashSet<>());
        }
        
        for(int[]e : prerequisites)
        {
            graph.get(e[0]).add(e[1]);
            indegree[e[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++)
        {
            if(indegree[i] == 0)
            {
                q.add(i);
            }
        }
        
        while(!q.isEmpty())
        {
            int size = q.size();
            while(size > 0)
            {
                int cur = q.remove();
                for(int next : graph.get(cur))
                {
                    indegree[next]--;
                    prereq.get(next).add(cur);
                    prereq.get(next).addAll(prereq.get(cur));
                    if(indegree[next] == 0)
                        q.add(next);
                }
                size--;
            }
        }
        for(int i = 0; i < queries.length; i++)
        {
            Set<Integer> set = prereq.get(queries[i][1]);
            if(set.contains(queries[i][0]))
                result.set(i,true);
        }
        
        return result;
        
    }
}
