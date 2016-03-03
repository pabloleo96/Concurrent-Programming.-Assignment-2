package PartA3;


/**
 *
 * @author Jorge
 */
public class Reader implements Runnable {

    Queue q;
    String ID;

    Reader(Queue q, String id) {
        this.ID = id;
        this.q = q;
        new Thread(this, "Reader " + id).start();
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
