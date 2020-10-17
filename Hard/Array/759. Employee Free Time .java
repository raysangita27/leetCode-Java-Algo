/*
We are given a list schedule of employees, which represents the working time for each employee.

Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.

Return the list of finite intervals representing common, positive-length free time for all employees, also in sorted order.

(Even though we are representing Intervals in the form [x, y], the objects inside are Intervals, not lists or arrays. For example, schedule[0][0].start = 1, schedule[0][0].end = 2, and schedule[0][0][0] is not defined).  Also, we wouldn't include intervals like [5, 5] in our answer, as they have zero length.

 

Example 1:

Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
Output: [[3,4]]
Explanation: There are a total of three employees, and all common
free time intervals would be [-inf, 1], [3, 4], [10, inf].
We discard any intervals that contain inf as they aren't finite.
Example 2:

Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
Output: [[5,6],[7,9]]
 

Constraints:

1 <= schedule.length , schedule[i].length <= 50
0 <= schedule[i].start < schedule[i].end <= 10^8
*/

/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        PriorityQueue<Interval> pQ = new PriorityQueue<>(new Comparator<Interval>(){
            public int compare(Interval a, Interval b)
            {
                return a.start - b.start;
            }
        });
        schedule.forEach(e -> pQ.addAll(e));
        var temp = pQ.poll();
        while(!pQ.isEmpty())
        {
            if(temp.end< pQ.peek().start){
                result.add(new Interval(temp.end, pQ.peek().start));
                temp = pQ.poll();
            }
            else
            {
                temp.end = temp.end < pQ.peek().end ?  pQ.peek().end : temp.end;
                pQ.poll();
             }
            
        }
        return result ;
    }
}
/*
The idea is to just add all the intervals to the priority queue. (NOTE that it is not matter how many different people are there for the algorithm. becuase we just need to find a gap in the time line.

priority queue - sorted by start time, and for same start time sort by either largest end time or smallest (it is not matter).
Everytime you poll from priority queue, just make sure it doesn't intersect with previous interval.
This mean that there is no coomon interval. Everyone is free time.

The time complexity of the sort algorithm is O(nlogn) where n is the total number of intervals.
*/
