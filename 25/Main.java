
class NumberThread extends Thread {
    int start, end;

    NumberThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void run() {
        for (int i = start; i <= end; i++) {
            System.out.println(
                Thread.currentThread().getName() + " : " + i
            );

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {

        // Mohammed Tawfik
        // PRN: 25070122112

        NumberThread t1 = new NumberThread(1, 5);
        NumberThread t2 = new NumberThread(6, 10);
        NumberThread t3 = new NumberThread(11, 15);

        t1.setName("Thread 1");
        t2.setName("Thread 2");
        t3.setName("Thread 3");

        t1.start();
        t2.start();
        t3.start();
    }
}
