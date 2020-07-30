/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 

Constraints:

Methods pop, top and getMin operations will always be called on non-empty stacks.
*/
class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stk ;
    Stack<Integer> minStack;
    public MinStack() {
        stk = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        stk.push(x);
        if(minStack.isEmpty() || x <= minStack.peek())
            minStack.push(x);
                
    }
    
    public void pop() {
        if(stk.isEmpty())
            return ;
        if(!minStack.isEmpty() &&stk.peek().equals(minStack.peek()))
            minStack.pop();
        stk.pop();
    }
    
    public int top() {
        if(stk.isEmpty())    
            return -1;
        return stk.peek();
    }
    
    public int getMin() {
        if(stk.isEmpty())
            return -1;
        else if(minStack.isEmpty() )
            return stk.peek();
        else
            return minStack.peek();
            
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
