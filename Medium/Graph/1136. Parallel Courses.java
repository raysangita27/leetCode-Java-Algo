/*
You are given an integer n, which indicates that there are n courses labeled from 1 to n. You are also given an array relations where relations[i] = [prevCoursei, nextCoursei], representing a prerequisite relationship between course prevCoursei and course nextCoursei: course prevCoursei has to be taken before course nextCoursei.

In one semester, you can take any number of courses as long as you have taken all the prerequisites in the previous semester for the courses you are taking.

Return the minimum number of semesters needed to take all courses. If there is no way to take all the courses, return -1.

 

Example 1:


Input: n = 3, relations = [[1,3],[2,3]]
Output: 2
Explanation: The figure above represents the given graph.
In the first semester, you can take courses 1 and 2.
In the second semester, you can take course 3.
Example 2:


Input: n = 3, relations = [[1,2],[2,3],[3,1]]
Output: -1
Explanation: No course can be studied because they are prerequisites of each other.
 

Constraints:

1 <= n <= 5000
1 <= relations.length <= 5000
relations[i].length == 2
1 <= prevCoursei, nextCoursei <= n
prevCoursei != nextCoursei
All the pairs [prevCoursei, nextCoursei] are unique.
*/

class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        if(relations == null || relations.length == 0)
            return -1;
        int[] indegree = new int[n+1];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n+1; i++)
            graph.add(new ArrayList<>());
        
        for(int[] rel : relations)
        {
            graph.get(rel[0]).add(rel[1]);
            indegree[rel[1]]++;
        }
        
        ArrayList<Integer> bfsQ = new ArrayList<>();
        for(int i = 0; i < n+1; i++)
        {
            if(indegree[i] == 0)
                bfsQ.add(i);
        }
        
        int sem = 0;
        int totalcourse = 0;
        while(!bfsQ.isEmpty())
        {
            sem++;
            ArrayList<Integer> listQ = new ArrayList<>();
            for(int node : bfsQ)
            {
                totalcourse ++;
                for(int dep : graph.get(node))
                {
                    indegree[dep]--;
                    if(indegree[dep] == 0)
                        listQ.add(dep);
                }
            }
            bfsQ = listQ;
        }
        if(totalcourse == n+1)
            return sem;
        return -1;
        
    }
}
/*
Complexity Analysis

Let EE be the length of relations.

Time Complexity: \mathcal{O}(N+E)O(N+E). For building the graph, we spend \mathcal{O}(N)O(N) to initialize the graph, and spend \mathcal{O}(E)O(E) to add egdes since we iterate relations once. For DFS, we spend \mathcal{O}(N+E)O(N+E) since we need to visit every node and edge once in DFS in the worst case.

Space Complexity: \mathcal{O}(N+E)O(N+E). For the graph, we spend \mathcal{O}(N+E)O(N+E) since we have \mathcal{O}(N)O(N) keys and \mathcal{O}(E)O(E) values. For DFS, we spend \mathcal{O}(N)O(N) since in the worst case, we need to add all nodes to the stack to recursively call DFS. Also, we run DFS twice.
*/
