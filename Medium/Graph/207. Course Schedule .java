/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
 

Constraints:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
1 <= numCourses <= 10^5
*/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for(int i = 0; i< numCourses; i++)
            graph[i] = new ArrayList<>();
        boolean[] visited = new boolean[numCourses];
        for(int i = 0; i<prerequisites.length; i++ )
        {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        for(int i = 0;  i<numCourses; i++ )
        {
            if(!dfs(graph, visited, i))
                return false;
        }
        return true;
    }
    
    private boolean dfs(ArrayList[] graph, boolean[] visited, int course)
    {
        if(visited[course] == true)
            return false;
        else
            visited[course] = true;
        for(int i = 0; i < graph[course].size(); i++ )
        {
            if(!dfs(graph, visited, (int)graph[course].get(i)))
                return false;
        }
        visited[course] = false;
        return true;
            
    }
}
