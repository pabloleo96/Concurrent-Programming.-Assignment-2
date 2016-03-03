package PartA3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jorge
 */
public class Queue {

    int n;
    boolean flag = true;
    volatile boolean alreadyRead = false;
    
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
        if(!alreadyRead){
            System.out.println(n +"\t" + Thread.currentThread().getName());
            alreadyRead = true;
        }
        //Post-protocol
        flag = true;
        this.notifyAll();
        
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
        alreadyRead = false;
        this.notifyAll();      
    }
}
