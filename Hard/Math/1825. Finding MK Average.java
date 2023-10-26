/*
You are given two integers, m and k, and a stream of integers. You are tasked to implement a data structure that calculates the MKAverage for the stream.

The MKAverage can be calculated using these steps:

If the number of the elements in the stream is less than m you should consider the MKAverage to be -1. Otherwise, copy the last m elements of the stream to a separate container.
Remove the smallest k elements and the largest k elements from the container.
Calculate the average value for the rest of the elements rounded down to the nearest integer.
Implement the MKAverage class:

MKAverage(int m, int k) Initializes the MKAverage object with an empty stream and the two integers m and k.
void addElement(int num) Inserts a new element num into the stream.
int calculateMKAverage() Calculates and returns the MKAverage for the current stream rounded down to the nearest integer.
 

Example 1:

Input
["MKAverage", "addElement", "addElement", "calculateMKAverage", "addElement", "calculateMKAverage", "addElement", "addElement", "addElement", "calculateMKAverage"]
[[3, 1], [3], [1], [], [10], [], [5], [5], [5], []]
Output
[null, null, null, -1, null, 3, null, null, null, 5]

Explanation
MKAverage obj = new MKAverage(3, 1); 
obj.addElement(3);        // current elements are [3]
obj.addElement(1);        // current elements are [3,1]
obj.calculateMKAverage(); // return -1, because m = 3 and only 2 elements exist.
obj.addElement(10);       // current elements are [3,1,10]
obj.calculateMKAverage(); // The last 3 elements are [3,1,10].
                          // After removing smallest and largest 1 element the container will be [3].
                          // The average of [3] equals 3/1 = 3, return 3
obj.addElement(5);        // current elements are [3,1,10,5]
obj.addElement(5);        // current elements are [3,1,10,5,5]
obj.addElement(5);        // current elements are [3,1,10,5,5,5]
obj.calculateMKAverage(); // The last 3 elements are [5,5,5].
                          // After removing smallest and largest 1 element the container will be [5].
                          // The average of [5] equals 5/1 = 5, return 5
 

Constraints:

3 <= m <= 105
1 <= k*2 < m
1 <= num <= 105
At most 105 calls will be made to addElement and calculateMKAverage.
*/

class MKAverage {
    Deque<Integer> queue;  //Maintain a deque so we can remove the m+1th  element. Maintain current sum and tot elements.
    TreeMap<Integer, Integer> numFreqMap; // maintain numbers in sorted order.
    int m ;
    int k;
    int total ; // total number of element
    int sum;  // totalsum of m elements
    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
        sum = 0;
        total = 0;
        queue = new ArrayDeque<>();
        numFreqMap = new TreeMap<>();
    }
    
    public void addElement(int num) {
        numFreqMap.put(num, numFreqMap.getOrDefault(num, 0) +1);
        queue.addLast(num);
        total++;
        sum += num;
        if(total > m)
        {
            int item = queue.pollFirst();
            int freq = numFreqMap.get(item);
            if(freq == 1)
                numFreqMap.remove(item);
            else
                numFreqMap.put(item, freq-1);
            sum -= item;
            total--;
        }    

    }
    
    public int calculateMKAverage() {
        if(total < m)
            return -1;
        int targetCount = k;
        int currentSum = sum;
        // removing smallest k element
        for(Map.Entry<Integer, Integer> e : numFreqMap.entrySet())
        {
            if(targetCount == 0)
                break;
            int item = e.getKey();
            int freq = Math.min(targetCount, e.getValue());
            currentSum -= item * freq;  // subtracting that item from sum.
            targetCount -= freq;
        }

        targetCount = k;
        // removing largest k element
        for(Map.Entry<Integer, Integer> e : numFreqMap.descendingMap().entrySet())
        {
            if(targetCount == 0)
                break;
            int item = e.getKey();
            int freq = Math.min(targetCount, e.getValue());
            currentSum -= item * freq; // subtracting target items from sum.
            targetCount -= freq;
        }

        return currentSum / (total - 2*k);

    }
}

/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */
