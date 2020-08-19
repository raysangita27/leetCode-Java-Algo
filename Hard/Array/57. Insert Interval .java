/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
*/
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0)
             return new int[][]{newInterval};
        List<int[]> merged = new LinkedList<>();
        int i = 0;
        int len = intervals.length ;
        while(i < len && intervals[i][1] < newInterval[0])
        {
            merged.add(intervals[i]);
            i++;
        }
        while(i < len && intervals[i][0] <= newInterval[1])
        {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        merged.add(newInterval);
        while(i < len)
            merged.add(intervals[i++]);
        return merged.toArray(new int[merged.size()][]);
    }
}
