/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1
*/

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0 || intervals == null)
            return 0;
        int roomCount = 1;
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                return o1[0] - o2[0];
            }
        });
        
        PriorityQueue<int[]> pQ = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2)
            {
                return o1[1] - o2[1];
            }
        }) ;
        
        pQ.add(intervals[0]);
        for(int i = 1; i<intervals.length; i++)
        {
            var temp = pQ.peek();
            if(temp[1] <= intervals[i][0])
            {
                pQ.poll();
               
            }
             pQ.add(intervals[i]);
        }
        return pQ.size();
    }
}
