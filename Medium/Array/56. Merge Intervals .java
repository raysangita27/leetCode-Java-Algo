/*
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

 

Constraints:

intervals[i][0] <= intervals[i][1]

*/
class Solution {
    public int[][] merge(int[][] intervals) {
    Collections.sort(Arrays.asList(intervals), new Comparator<int[]>(){
        public int compare(int[] o1 , int[] o2)
        {
            return o1[0]<o2[0] ? -1: o1[0] == o2[0]?0 :1;
        }
    }) ;  
        LinkedList<int[]> merged = new LinkedList<int[]>();
        for(int i = 0; i< intervals.length; i++)
        {
            // if the list of merged intervals is empty or if the current
      // interval does not overlap with the previous, simply append it.
            if(merged.isEmpty() || merged.getLast()[1] < intervals[i][0])
                merged.add(intervals[i]);
            // otherwise, there is overlap, so we merge the current and previous
      // intervals.
            else
            {
                merged.getLast()[1] = Math.max(merged.getLast()[1], intervals[i][1] );
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
