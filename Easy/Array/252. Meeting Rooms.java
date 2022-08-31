/*
Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.

 

Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: false
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: true
 

Constraints:

0 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti < endi <= 106

*/

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
    if(intervals == null || intervals.length == 0)
        return true;
    Arrays.sort(intervals, new Comparator<int[]>(){
        public int compare(int[] o1, int[] o2)
        {
            return o1[0] - o2[0];
        }
    });
    for(int i = 0; i < intervals.length-1; i++)
    {
        if(intervals[i][1] > intervals[i+1][0])
            return false;
    }
    return true;

}
}
