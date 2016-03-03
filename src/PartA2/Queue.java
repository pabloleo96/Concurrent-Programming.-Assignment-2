package PartA2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jorge
 */
public class Queue {

    int n;
    boolean flag = true;

    synchronized public void read() {
        //Pre-protocol
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Queue.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //Critical section
        System.out.println(n);

        //Post-protocol
        flag = true;
        this.notify();
        
    }

    synchronized public void write(int x) {
        //Pre-protocol
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Queue.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //Critical section
        n = x;

        //Post-protocol
        flag = false;
        this.notify();      
    }
}
