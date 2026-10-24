
class NumberThread extends Thread {
    String threadName;
    int start, end;

    NumberThread(String name, int start, int end) {
        this.threadName = name;
        this.start = start;
        this.end = end;
    }

    public void run() {
        for (int i = start; i <= end; i++) {
            System.out.println(threadName + " : " + i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(threadName + " interrupted.");
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}

public class exr2 {
    public static void main(String[] args) {

        // Mohammed Tawfik
        // PRN: 25070122112

        NumberThread t1 = new NumberThread("Thread 1", 1, 5);
        NumberThread t2 = new NumberThread("Thread 2", 6, 10);
        NumberThread t3 = new NumberThread("Thread 3", 11, 15);

        System.out.println("Starting threads...");

        t1.start();
        t2.start();
        t3.start();
    }
}
