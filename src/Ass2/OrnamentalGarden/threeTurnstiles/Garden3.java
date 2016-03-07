
package Ass2.OrnamentalGarden.threeTurnstiles;


import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.applet.*;


public class Garden3 extends Applet {


    Button goButton;
    Turnstile turnstile1;
    Turnstile turnstile2;
    Turnstile turnstile3;
    Counter counter;
    NumberCanvas counterD;
    NumberCanvas turn1D;
    NumberCanvas turn2D;
    NumberCanvas turn3D;
//    Checkbox fixit;
    public final static int MAX = 20;


    public void init() {
        super.init();
	setBackground(Color.lightGray);
        // Set up Button 
        Panel p0= new Panel();
        p0.add(goButton = new Button(" Simulate "));
        goButton.setFont(new Font("Helvetica",Font.BOLD,24));
		
        goButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
           if (turnstile1==null && turnstile2==null&& turnstile3==null)
              go();
          else if (!turnstile1.isAlive() && !turnstile2.isAlive() && !turnstile3.isAlive())
              go();         
          }
        });
	Panel p=new Panel();
        Label lb=new Label("Ornamental Garden");
        lb.setFont(new Font("Arial",Font.BOLD,24));
        p.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        p.add("South",lb);

        Panel p1= new Panel();
        p1.setLayout(new BorderLayout());
        
        p1.add("Center",p0);

        // Set up Display
        Panel p2 = new Panel();
        counterD = new NumberCanvas("Counter");
        turn1D   = new NumberCanvas("Turnstile 1",Color.ORANGE);
        turn2D   = new NumberCanvas("Turnstile 2",Color.ORANGE);
        turn3D   = new NumberCanvas("Turnstile 3",Color.ORANGE);
        counterD.setSize(150,100);
        turn1D.setSize(100,100);
        turn2D.setSize(100,100);
        turn3D.setSize(100,100);
        p2.add(turn1D);
        p2.add(turn2D);
        p2.add(turn3D);
        p2.add(counterD);
        // Arrange Applet display
        setLayout(new BorderLayout());
        add("North",p);
        add("Center",p2);
        add("South",p1);
        
    }

    private void go() {
        
        counter = new Counter(counterD);
       
        turnstile1= new Turnstile(turn1D,counter,1);
        turnstile2= new Turnstile(turn2D,counter,2);
        turnstile3= new Turnstile(turn3D,counter,3);
        turnstile1.start();
        turnstile2.start();
        turnstile3.start();
    }

}

class Counter {

    volatile int value=0; 
    NumberCanvas display;

    
    // Preprotocol


    Counter(NumberCanvas n) {
        display=n;
        display.setvalue(value);
    }

    void increment() {
        int temp = value;   //read[v]
        CC.FuerzaCC();
               
        value=temp+1;       //write[v+1]
        display.setvalue(value);

        

    }
}

class Turnstile extends Thread {
  NumberCanvas display;
  Counter people;
  int numTurnstile;

  Turnstile(NumberCanvas n,Counter c, int nt)
    { display = n; people = c; numTurnstile = nt; }

  public void run() {
    try{
      display.setvalue(0);
      for (int i=1;i<=Garden3.MAX;i++){
        Thread.sleep(500); //0.5 second
        display.setvalue(i);
      
          people.increment();
                
      }
    } catch (InterruptedException e) {}
  }
}




class CC {
    public static void FuerzaCC() {
        if (Math.random()<0.5)
           try{Thread.sleep(200);} catch(InterruptedException e){};
            //sirve para simular una concurrencia más explicita
           // y que Java cambie de un hilo a otro al dormirlo -como yield()-}
    }
}
