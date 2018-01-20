/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagemove6;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Susmi
 */
public class Blasting6 implements Runnable {
    public Thread t;
    public ImageView Iq;
    public AnchorPane r;
    public double a;
    public double b;
    public Blasting6(ImageView Iq1,double a1,double b1,AnchorPane root){
        Iq=Iq1;
        a=a1;
        b=b1;
        r=root;
        t=new Thread(this,"thread demo");
        System.out.println("shusmimou");
        r.getChildren().add(Iq);
        t.start();
    }
   
    public void run() {
        
        
      
        try {
            System.out.println("mama");
            
            
            Iq.setX(a);
            Iq.setY(b);
            Thread.sleep(1000);
            Iq.setX(1500);
            Iq.setY(1500);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Blasting6.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
