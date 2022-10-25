/*
A car travels from a starting position to a destination which is target miles east of the starting position.

There are gas stations along the way. The gas stations are represented as an array stations where stations[i] = [positioni, fueli] indicates that the ith gas station is positioni miles east of the starting position and has fueli liters of gas.

The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it. It uses one liter of gas per one mile that it drives. When the car reaches a gas station, it may stop and refuel, transferring all the gas from the station into the car.

Return the minimum number of refueling stops the car must make in order to reach its destination. If it cannot reach the destination, return -1.

Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there. If the car reaches the destination with 0 fuel left, it is still considered to have arrived.

 

Example 1:

Input: target = 1, startFuel = 1, stations = []
Output: 0
Explanation: We can reach the target without refueling.
Example 2:

Input: target = 100, startFuel = 1, stations = [[10,100]]
Output: -1
Explanation: We can not reach the target (or even the first gas station).
Example 3:

Input: target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
Output: 2
Explanation: We start with 10 liters of fuel.
We drive to position 10, expending 10 liters of fuel.  We refuel from 0 liters to 60 liters of gas.
Then, we drive from position 10 to position 60 (expending 50 liters of fuel),
and refuel from 10 liters to 50 liters of gas.  We then drive to and reach the target.
We made 2 refueling stops along the way, so we return 2.
 

Constraints:

1 <= target, startFuel <= 109
0 <= stations.length <= 500
1 <= positioni < positioni+1 < target
1 <= fueli < 109
*/

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
      // start fuel is greater than target , dont need to refuel.
        if(startFuel >= target)
            return 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        int maxDistance = startFuel;
        int i = 0;
        int stop = 0;
      //untill we reach target loop through
        while(maxDistance < target)
        {
            //if stations distances less than max distance , we can cross that stations with existing fuel. and we are storing fuel in the maxheap . 
            while(i < stations.length && stations[i][0] <= maxDistance)
            {
                q.add(stations[i++][1]);
            }
          //if we need to refuel we will pick up max fuel from heap.
            if(q.isEmpty())
                return -1;
            maxDistance += q.poll();
            stop++;
        }
        return stop;
        
    }
}

/***************Timecomplexity O(nlogn)
