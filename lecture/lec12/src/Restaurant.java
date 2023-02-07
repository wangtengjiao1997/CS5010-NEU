import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Restaurant {
    //ReentrantLock lock = new ReentrantLock();
    //Condition cond = lock.newCondition();
    List<Order> orders = new ArrayList<>();

    public synchronized void order(Order o) {
        //lock.lock();
        System.out.println("Placing order " + o.amount);
        orders.add(o);
        if (orders.size() >= 5) {
            System.out.println("Enough order, waking up the delivery guy");
            //cond.signal();
            notify();
        }
        //lock.unlock();
    }

    // Whenever there are >= 5 orders:
    // returns the sum of the amount of all the existing orders
    // remove all the orders from the order list
    public synchronized int delivery() throws InterruptedException {
        //lock.lock();
        if (orders.size() < 5) {
            System.out.println("Not enough order, wait");
            //cond.await();
            wait();
            System.out.println("Waking up");
        }

        int sum = 0;
        for (int i = 0; i < orders.size(); i++) {
            sum += orders.get(i).amount;
        }
        orders.clear();
        //lock.unlock();
        return sum;
    }

    public static void main(String[] args) {
        Restaurant r = new Restaurant();
        // Delivery guy
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println("Delivering amount " + r.delivery());
                    } catch (Exception e) {
                        // ..
                    }
                }
            }
        }).start();

        // Customer placing order
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        // ..
                    }
                    r.order(new Order(10));
                }
            }
        }).start();
    }
}
