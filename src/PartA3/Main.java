package PartA3;

/**
 *
 * @author Jorge
 */
public class Main {
    public static void main(String args []){
        Queue queue;
        
        queue = new Queue();
        
        new Writer(queue);
        new Reader(queue,"1");
        new Reader(queue,"2");
    }
}
