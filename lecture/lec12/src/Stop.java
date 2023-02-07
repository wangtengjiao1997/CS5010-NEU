import java.util.Scanner;

public class Stop {
    public static void main(String[] args) {

        new Thread(new Runnable() {
            Scanner myObj = new Scanner(System.in);
            @Override
            public void run() {
                String userName = myObj.nextLine();
                if (userName.equals("stop")) {
                    System.out.println("Stop!!!!");
                    // should terminate the program
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        System.out.println("interrupted");
                    }
                    System.out.println("hello world");
                }
            }
        }).start();
    }
}
