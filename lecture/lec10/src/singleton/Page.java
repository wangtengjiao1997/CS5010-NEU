package singleton;

public class Page {
    private Counter counter;
    public Page() {
        //counter = new Counter();
        counter = Counter.getGlobalCounter();
    }

    public void click() {
        counter.inc();
    }

    public Counter getCounter() {
        return counter;
    }
}
