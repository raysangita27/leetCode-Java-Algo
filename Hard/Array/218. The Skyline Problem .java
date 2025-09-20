/*
A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A), write a program to output the skyline formed by these buildings collectively (Figure B).

Buildings Skyline Contour
The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
![example](https://assets.leetcode.com/static_assets/public/images/problemset/skyline1.jpg)
![example1](https://assets.leetcode.com/static_assets/public/images/problemset/skyline2.jpg)
For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .

The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.

For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].

Notes:

The number of buildings in any input list is guaranteed to be in the range [0, 10000].
The input list is already sorted in ascending order by the left x position Li.
The output list must be sorted by the x position.
There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]
*/

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
       for(int[] b:buildings) {
        height.add(new int[]{b[0], -b[2]});
        height.add(new int[]{b[1], b[2]});
    }
    Collections.sort(height, (a, b) -> {
            if(a[0] != b[0]) 
                return a[0] - b[0];
            return a[1] - b[1];
    });
       Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
    pq.offer(0);
    int prev = 0;
    for(int[] h:height) {
        if(h[1] < 0) {
            pq.offer(-h[1]);
        } else{
                heightCountMap.put(h[1], heightCountMap.getOrDefault(h[1], 0) +1);
            }
            // Ensure the top of the heap is valid (i.e., remove heights marked for deletion)
            while (!pQ.isEmpty() && heightCountMap.getOrDefault(pQ.peek(), 0) > 0) {
                int heightToRemove = pQ.peek();
                heightCountMap.put(heightToRemove, heightCountMap.get(heightToRemove) - 1);
                pQ.poll(); // Remove the invalid height
            }
        if(!pq.isEmpty()){
        int cur = pq.peek();
            if(cur != prev)
            {
                List<Integer> temp = new ArrayList<>();
                temp.add(h[0]);
                temp.add(cur);
                result.add(temp);
                prev = cur;
            }
        }
        }
        return result;
        
    }
}
/****************************************EXPLANATION********************************************/
/*
Firstly, please notice what we need to achieve:

  1. visit all start points and all end points in order;
  2. when visiting a point, we need to know whether it is a start point or a
      end point, based on which we can add a height or delete a height from
      our data structure;
To achieve this, his implementation:

  1. use a int[][] to collect all [start point, - height] and [end point, height]
      for every building;
  2. sort it, firstly based on the first value, then use the second to break
      ties;
Thus,

  1. we can visit all points in order;
  2. when points have the same value, higher height will shadow the lower one;
  3. we know whether current point is a start point or a end point based on the
      sign of its height;
 */
