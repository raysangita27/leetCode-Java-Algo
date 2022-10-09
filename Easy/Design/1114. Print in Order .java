/*
Suppose we have a class:

public class Foo {
  public void first() { print("first"); }
  public void second() { print("second"); }
  public void third() { print("third"); }
}
The same instance of Foo will be passed to three different threads. Thread A will call first(), thread B will call second(), and thread C will call third(). Design a mechanism and modify the program to ensure that second() is executed after first(), and third() is executed after second().

 

Example 1:

Input: [1,2,3]
Output: "firstsecondthird"
Explanation: There are three threads being fired asynchronously. The input [1,2,3] means thread A calls first(), thread B calls second(), and thread C calls third(). "firstsecondthird" is the correct output.
Example 2:

Input: [1,3,2]
Output: "firstsecondthird"
Explanation: The input [1,3,2] means thread A calls first(), thread B calls third(), and thread C calls second(). "firstsecondthird" is the correct output.
 

Note:

We do not know how the threads will be scheduled in the operating system, even though the numbers in the input seems to imply the ordering. The input format you see is mainly to ensure our tests' comprehensiveness.

*/

class Foo {
    public volatile int counter ;
    public Foo() {
        counter = 0;    
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        counter++;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        while(counter != 1){ }
        printSecond.run();
        counter++;
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        while(counter != 2){}
        printThird.run();
    }
}

/*****************************************Semaphore*****************************************/
using System.Threading;
public class Foo {

    Semaphore first = new Semaphore(1, 1);
    Semaphore second = new Semaphore(0, 1);
    Semaphore third = new Semaphore(0, 1);
    public Foo() {

    }

    public void First(Action printFirst) {
        
        // printFirst() outputs "first". Do not change or remove this line.
        first.WaitOne();
        printFirst();
        second.Release();
    }

    public void Second(Action printSecond) {
        
        // printSecond() outputs "second". Do not change or remove this line.
        second.WaitOne();
        printSecond();
        third.Release();
    }

    public void Third(Action printThird) {
        
        // printThird() outputs "third". Do not change or remove this line.
        third.WaitOne();
        printThird();
        third.Release();
    }
}
