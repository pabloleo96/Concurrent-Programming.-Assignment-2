package PartA1;

/**
 *
 * @author Jorge
 */
public class Queue {
    
    int n;
    volatile boolean flag = false;
    
    public void read(){
        
        //Pre-protocol      
        while(!flag);
        
        //Critical section
        System.out.println(n);
        
        //Post-protocol
        flag=false;
    }
    
    public void write(int x){
        
        //Busy wait
        while(flag);
        
        //Critical section
        n = x;
        
        //Post-protocol
        flag=true;
        
    }
}
