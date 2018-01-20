/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagemove6;

/**
 *
 * @author Susmi
 */
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


public class Changepos implements Runnable {
    Scanner scn;
    public Thread t;
    public ImageView iv1;
//    public AnchorPane r;
    public double a;
    public double b;
    Integer count ;
    Balling b1,b2,b3;
    Balling []ball=new Balling[100] ;
    EnemyPlane6 enemyPlane1 , enemyPlane2 ;
    DataOutputStream outToServer;
    
    public Changepos(EnemyPlane6 enemy1,EnemyPlane6 enemy2,DataOutputStream outToServer){
        this.enemyPlane1=enemy1;
        this.enemyPlane2=enemy2;
        this.outToServer=outToServer;
        
        t=new Thread(this,"thread demo");
        System.out.println("shusmimou");
        
        t.start();
    }
   
    public void run() {
        
        
      
        
            System.out.println("mama2");
            while(true)
            {
                try {
                    outToServer.writeBytes("101 "+enemyPlane1.gettx()+" "+enemyPlane1.getty()+'\n');
                    outToServer.writeBytes("102 "+enemyPlane2.gettx()+" "+enemyPlane2.getty()+'\n');
                } catch (IOException ex) {
                    Logger.getLogger(Changepos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            
            
            
        
        
    }
    
    
}

