package PartA3;


/**
 *
 * @author Jorge
 */
public class Writer implements Runnable{
    
    Queue q;
   
    Writer(Queue q){
        this.q = q;
        new Thread(this, "Writer").start();
    }
    
    public void run(){
        
        int i = 0;
        for(int j = 0; j<10; j++){
            try{
                Thread.sleep ((long) (Math.random()*500));
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            q.write(i++);
        }
    }
    
}
