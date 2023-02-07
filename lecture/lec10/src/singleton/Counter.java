package singleton;
public class Counter {
    static public Counter singleCounter = new Counter();

    static public Counter getGlobalCounter() {
       return singleCounter;
    }

    private Counter() {
        counter = 0;
    }

    private int counter;

    public void inc() {
        counter++;
    }

    public int getVal() {
        return counter;
    }
}
