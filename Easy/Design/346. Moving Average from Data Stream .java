/*
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Example:

MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
*/

class MovingAverage {

    /** Initialize your data structure here. */
    ArrayList<Integer> list;
    int capacity;
    double sum ;
    public MovingAverage(int size) {
        list = new ArrayList<Integer>();
        capacity = size;
        sum = 0;
    }
    
    public double next(int val) {
        double avg = 0;
        if(capacity == 1)
            return val;
        int size = list.size();
        if(size < capacity )
        {
            if(size == 0)
            {
                list.add(val);
                sum = val;
            }
            else{
                list.add(val);
                sum += val;
            }
        }
        else
        {
            int key = list.remove(0);
            list.add(val);
            sum = sum + val -key;
        }
        avg = sum/list.size();
        return avg;
        
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
