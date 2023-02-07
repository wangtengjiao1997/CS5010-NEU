package singleton;

import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private ReentrantLock lock = new ReentrantLock();
    static public Counter singleCounter = new Counter();

    static public Counter getGlobalCounter() {
       return singleCounter;
    }

    private Counter() {
        counter = 0;
    }

    private int counter;

    public void inc() {
        lock.lock();
        counter++;
        lock.unlock();
    }

    public int getVal() {
        return counter;
    }
}
