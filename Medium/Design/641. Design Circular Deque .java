/*
Design your implementation of the circular double-ended queue (deque).

Your implementation should support following operations:

MyCircularDeque(k): Constructor, set the size of the deque to be k.
insertFront(): Adds an item at the front of Deque. Return true if the operation is successful.
insertLast(): Adds an item at the rear of Deque. Return true if the operation is successful.
deleteFront(): Deletes an item from the front of Deque. Return true if the operation is successful.
deleteLast(): Deletes an item from the rear of Deque. Return true if the operation is successful.
getFront(): Gets the front item from the Deque. If the deque is empty, return -1.
getRear(): Gets the last item from Deque. If the deque is empty, return -1.
isEmpty(): Checks whether Deque is empty or not. 
isFull(): Checks whether Deque is full or not.
 

Example:

MyCircularDeque circularDeque = new MycircularDeque(3); // set the size to be 3
circularDeque.insertLast(1);			// return true
circularDeque.insertLast(2);			// return true
circularDeque.insertFront(3);			// return true
circularDeque.insertFront(4);			// return false, the queue is full
circularDeque.getRear();  			// return 2
circularDeque.isFull();				// return true
circularDeque.deleteLast();			// return true
circularDeque.insertFront(4);			// return true
circularDeque.getFront();			// return 4
 

Note:

All values will be in the range of [0, 1000].
The number of operations will be in the range of [1, 1000].
Please do not use the built-in Deque library.
*/
class MyCircularDeque {
    

    /** Initialize your data structure here. Set the size of the deque to be k. */
    ArrayList<Integer> dq ;
    int capacity;
    int itemCount;
    public MyCircularDeque(int k) {
        dq = new ArrayList<Integer>();
        capacity = k;
        itemCount = 0;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(dq.size() < capacity)
        {
            dq.add(0, value);
            itemCount++;
            return true;
        }
        else
            return false;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(dq.size() < capacity)
        {
            dq.add(itemCount, value);
            itemCount++;
            return true;
        }
        else
            return false;    
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(dq.size() > 0)
        {
            dq.remove(0);
            itemCount--;
            return true;
        } 
        else
            return false;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(dq.size() > 0)
        {
            dq.remove(dq.size()-1);
            itemCount--;
            return true;
        } 
        else   
            return false;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if(dq.size() > 0)
        {
           return dq.get(0);
        } 
        else   
            return -1;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if(dq.size() > 0)
        {
            return dq.get(dq.size()-1);
        } 
        else   
            return -1;
        
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        if(dq.size() <= 0)
            return true;
        else
            return false;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
         if(dq.size() == capacity)
            return true;
        else
            return false;
        
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
