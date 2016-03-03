package PartA2;

/**
 *
 * @author Jorge
 */
public class Reader implements Runnable {

    Queue q;

    Reader(Queue q) {
        this.q = q;
        new Thread(this, "Reader").start();
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep((long) (Math.random() * 500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            q.read();
        }
    }
}
