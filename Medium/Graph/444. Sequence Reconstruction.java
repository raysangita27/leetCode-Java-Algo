/*
You are given an integer array nums of length n where nums is a permutation of the integers in the range [1, n]. You are also given a 2D integer array sequences where sequences[i] is a subsequence of nums.

Check if nums is the shortest possible and the only supersequence. The shortest supersequence is a sequence with the shortest length and has all sequences[i] as subsequences. There could be multiple valid supersequences for the given array sequences.

For example, for sequences = [[1,2],[1,3]], there are two shortest supersequences, [1,2,3] and [1,3,2].
While for sequences = [[1,2],[1,3],[1,2,3]], the only shortest supersequence possible is [1,2,3]. [1,2,3,4] is a possible supersequence but not the shortest.
Return true if nums is the only shortest supersequence for sequences, or false otherwise.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: nums = [1,2,3], sequences = [[1,2],[1,3]]
Output: false
Explanation: There are two possible supersequences: [1,2,3] and [1,3,2].
The sequence [1,2] is a subsequence of both: [1,2,3] and [1,3,2].
The sequence [1,3] is a subsequence of both: [1,2,3] and [1,3,2].
Since nums is not the only shortest supersequence, we return false.
Example 2:

Input: nums = [1,2,3], sequences = [[1,2]]
Output: false
Explanation: The shortest possible supersequence is [1,2].
The sequence [1,2] is a subsequence of it: [1,2].
Since nums is not the shortest supersequence, we return false.
Example 3:

Input: nums = [1,2,3], sequences = [[1,2],[1,3],[2,3]]
Output: true
Explanation: The shortest possible supersequence is [1,2,3].
The sequence [1,2] is a subsequence of it: [1,2,3].
The sequence [1,3] is a subsequence of it: [1,2,3].
The sequence [2,3] is a subsequence of it: [1,2,3].
Since nums is the only shortest supersequence, we return true.
 

Constraints:

n == nums.length
1 <= n <= 104
nums is a permutation of all the integers in the range [1, n].
1 <= sequences.length <= 104
1 <= sequences[i].length <= 104
1 <= sum(sequences[i].length) <= 105
1 <= sequences[i][j] <= n
All the arrays of sequences are unique.
sequences[i] is a subsequence of nums.
*/

class Solution {
    List<List<Integer>> superseq;
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        if(nums == null || nums.length == 0)
            return false;
        superseq = new ArrayList<List<Integer>>();
        List<List<Integer>> graph = new ArrayList<>();
        int n = nums.length;
        int[] indegree = new int[n+1];
        for(int i = 0; i <= n; i++)
        {
            graph.add(new ArrayList<>());
        }
        
        for(List<Integer> e : sequences)
        {
            for(int i = 0; i < e.size()-1; i++){
                graph.get(e.get(i)).add(e.get(i+1));
                indegree[e.get(i+1)]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i =  1; i <= n; i++)
        {
            if(indegree[i] == 0)
                q.add(i);
        }
        int ind = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            if(size > 1)
                return false;
            int cur = q.poll();
            if(ind == nums.length ||  cur != nums[ind++])
                return false;
            for(int next : graph.get(cur))
            {
                indegree[next]--;
                if(indegree[next] == 0)
                    q.add(next);
            }
        }
        
        
        return ind == nums.length;
    }
}
