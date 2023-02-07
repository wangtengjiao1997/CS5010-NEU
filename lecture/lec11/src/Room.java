import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Room {
    ReentrantLock lock = new ReentrantLock();
    Condition cond = lock.newCondition();

    private boolean available = true;

    public void tryEnter() {
        lock.lock();
        while(available == false) {
            try {
                // leave and will come back when notified
                System.out.println("room not available, leaving");
                cond.await();
                System.out.println("Some notified me to come back");
            } catch (InterruptedException e) {
                System.out.println("interrupt");
            }
        }

        // do something in the room for 2 seconds, then leave
        try {
            available = false;
            System.out.println("Doing something in the room...");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("interrupt");
        }

        available = true;
        System.out.println("notifying people to come back");
        cond.signal(); // notify the potential people who are waiting to come back
        lock.unlock();
    }

    public static void main(String[] args) {
        Room r = new Room();
        new Thread(new Runnable() {
            @Override
            public void run() {
                r.tryEnter();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                r.tryEnter();
            }
        }).start();
    }
}
