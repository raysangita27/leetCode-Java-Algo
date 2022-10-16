/*
You are given an integer n. There are n rooms numbered from 0 to n - 1.

You are given a 2D integer array meetings where meetings[i] = [starti, endi] means that a meeting will be held during the half-closed time interval [starti, endi). All the values of starti are unique.

Meetings are allocated to rooms in the following manner:

Each meeting will take place in the unused room with the lowest number.
If there are no available rooms, the meeting will be delayed until a room becomes free. The delayed meeting should have the same duration as the original meeting.
When a room becomes unused, meetings that have an earlier original start time should be given the room.
Return the number of the room that held the most meetings. If there are multiple rooms, return the room with the lowest number.

A half-closed interval [a, b) is the interval between a and b including a and not including b.

 

Example 1:

Input: n = 2, meetings = [[0,10],[1,5],[2,7],[3,4]]
Output: 0
Explanation:
- At time 0, both rooms are not being used. The first meeting starts in room 0.
- At time 1, only room 1 is not being used. The second meeting starts in room 1.
- At time 2, both rooms are being used. The third meeting is delayed.
- At time 3, both rooms are being used. The fourth meeting is delayed.
- At time 5, the meeting in room 1 finishes. The third meeting starts in room 1 for the time period [5,10).
- At time 10, the meetings in both rooms finish. The fourth meeting starts in room 0 for the time period [10,11).
Both rooms 0 and 1 held 2 meetings, so we return 0. 
Example 2:

Input: n = 3, meetings = [[1,20],[2,10],[3,5],[4,9],[6,8]]
Output: 1
Explanation:
- At time 1, all three rooms are not being used. The first meeting starts in room 0.
- At time 2, rooms 1 and 2 are not being used. The second meeting starts in room 1.
- At time 3, only room 2 is not being used. The third meeting starts in room 2.
- At time 4, all three rooms are being used. The fourth meeting is delayed.
- At time 5, the meeting in room 2 finishes. The fourth meeting starts in room 2 for the time period [5,10).
- At time 6, all three rooms are being used. The fifth meeting is delayed.
- At time 10, the meetings in rooms 1 and 2 finish. The fifth meeting starts in room 1 for the time period [10,12).
Room 0 held 1 meeting while rooms 1 and 2 each held 2 meetings, so we return 1. 
 

Constraints:

1 <= n <= 100
1 <= meetings.length <= 105
meetings[i].length == 2
0 <= starti < endi <= 5 * 105
All the values of starti are unique.

*/

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        if(meetings == null || meetings.length == 0)
            return 0;
      // heap based on sorted end time and room number.
        PriorityQueue<int[]> meetingused = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2)
            {
                if(o1[0] == o2[0])
                    return o1[1] - o2 [1];
                return o1[0] - o2[0];
            }
        });
      // set of rooms sorted based on numbers.
        PriorityQueue<Integer> room = new PriorityQueue<>();
        for(int i = 0; i < n; i++)
            room.add(i);
        //sort meetings based on start time.
        Arrays.sort(meetings, new Comparator<int[]>(){
            public int compare(int[] m1, int[] m2)
            {
                return m1[0] - m2[0];
            }
        });
        
        int count[] = new int[n];
        
        for(int[]m : meetings)
        {
            // if meetings are already end, return that room back to queue.
            while(!meetingused.isEmpty() && meetingused.peek()[0] <= m[0])
            {
                room.add(meetingused.poll()[1]);
            }
            //set starttime.
            int delayedStart = m[0];
            // if rooom is empty , meetings need to be delayed.
            if(room.isEmpty())
            {
                int[] temp = meetingused.poll();
                // meeting2 will be started after finishing meeting1. so meeting2 starttime is set to meeting1 end time.
                delayedStart = temp[0];
                // room is sent back to queue.
                room.add(temp[1]);
            }
            
            int r = room.poll();
            count[r]++;
            
            meetingused.add(new int[]{delayedStart + (m[1] - m[0]),r});
        }
        
        var maxIdx = 0;
		for (int r = 0; r < count.length; r++)
			if (count[maxIdx] < count[r])
				maxIdx = r;

		return maxIdx;
        
        
    }
}

/**************************TimeComplexity O(nlog(n))************************************/
