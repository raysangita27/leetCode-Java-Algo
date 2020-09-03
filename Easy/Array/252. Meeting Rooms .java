/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

Example 1:

Input: [[0,30],[5,10],[15,20]]
Output: false
Example 2:

Input: [[7,10],[2,4]]
Output: true
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
*/
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals == null || intervals.length <= 1)
            return true;
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] o1, int[]o2){
                return o1[0] < o2[0] ? -1 :o1[0]==o2[0] ? 0 : 1; 
            }
        });
        PriorityQueue<int[]> pQ = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2)
            {
                return o2[1] -o1[1];
            }
        });
        pQ.add(intervals[0]);
        for(int i = 1; i <intervals.length; i++)
        {
            if(intervals[i][0]>=pQ.peek()[1])
            {
                pQ.poll();
                
            }
            pQ.add(intervals[i]);
        }
        return pQ.size() == 1? true : false;
    }
}
