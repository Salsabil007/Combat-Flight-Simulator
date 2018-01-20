/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagemove6;
 

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Susmi
 */
 
class Move{
    ImageView m;
    Move(double x,double y,AnchorPane root,Image II)
    {
        m=new ImageView(II);
        root.getChildren().add(m);
        m.setX(x);
        m.setY(y);
    }
    
    public void updatepos()
    {
        
        m.setX(m.getX()+5);
    }
    
}

class Balling extends Circle{
    Balling(double x,double y,AnchorPane root, double radius,Color color){
        //super(x,y,radius,Color.RED);
        super(x,y,radius,color);
         root.getChildren().add(this);
    }
    public double getx()
    {
        return super.getCenterX();
    }
    public double gety()
    {
        return super.getCenterY();
    }
    public void updateCenter(){
        setCenterX(getCenterX()+5);
        //setCenterY(getCenterY()+5);
    }
    public void updateCenter1(){
        setCenterX(getCenterX()-5);
        //setCenterY(getCenterY()+5);
    }
}


public class ImageMove6 extends Application {
    //double bx=280,by=94,x=0;
     double bx=113,by=95,x=0;
     int count=0,count1=0,cc1=1,cc2=1,score=0,fff=0;
     public void doSomething(ImageView I1 , double d1 , double d2)
                    {
                        I1.setX(d1-40);
                        I1.setY(d2-30);
                    }
     static Socket clientSocket ;
    static DataOutputStream outToServer ;
    static BufferedReader inFromUser ;
        
    static BufferedReader inFromServer ;
    
    @Override
    public void start(Stage primaryStage) {
        
        try{
            VBox roott = new VBox(10);
            Text fps=new Text(1300,30,"X");
            Text fpss=new Text(1100,30,"H");
            Text fps1=new Text(1100,30,"Y");
            Text fps2=new Text(1300,30,"Y");
             fps1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
             fpss.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
              fps2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
              fps1.setFill(Color.RED);
              fpss.setFill(Color.BLACK);
               fps2.setFill(Color.RED);
               
        Image cong=new Image("congratulation.jpg");
         BackgroundImage congo=new  BackgroundImage(cong,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT); ;
        //ImageView congo=new ImageView(cong);
        Background last=new Background(congo);
        VBox con=new VBox(10);
        con.setAlignment(Pos.BOTTOM_CENTER);
        Image sm=new Image("smile.png");
        ImageView smile=new ImageView(sm);
        smile.setX(700);
        smile.setY(500);
        Button EExit=new Button("EXIT");
        EExit.setOnAction(e->{
            System.exit(0);
        });
        con.setBackground(last);
        con.getChildren().add(EExit);
        con.getChildren().add(smile);
        con.getChildren().addAll(fps1,fps2);
        Scene scenen=new Scene(con,1300,606,Color.BLACK);
       
              
            
      //background for first page
        BackgroundImage backgroundImage ;
        VBox end=new VBox(20);
        Button eexit=new Button("     EXIT     ");
        Image lose=new Image("angry.png");
        ImageView losing=new ImageView(lose);
        end.getChildren().add(losing);
        end.getChildren().addAll(fps1,fps2);
        losing.setX(1200);
        losing.setY(200);
        end.getChildren().add(eexit);
        end.setAlignment(Pos.BOTTOM_CENTER);
        eexit.setOnAction(event->{
            System.exit(0);
        });
        Image Ie=new Image("over.png");
        BackgroundImage backgroundImage4 ;
        backgroundImage4=new  BackgroundImage(Ie,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        Background background4 = new Background(backgroundImage4);
        end.setBackground(background4);
        Scene scene4=new Scene(end,1450,701);
        
       Image I=new Image("newnew.png");
        //BackgroundImage backgroundImage = new BackgroundImage( new Image( getClass().getResource("sushmi.jpg").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
       
       backgroundImage=new  BackgroundImage(I,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        
        BackgroundImage backgroundImage2 ;
        
       Image I2=new Image("second.png");
        //BackgroundImage backgroundImage = new BackgroundImage( new Image( getClass().getResource("sushmi.jpg").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
       
       backgroundImage2=new  BackgroundImage(I2,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        Background background2 = new Background(backgroundImage2);
        
        Label label1 =new Label("WELCOME");
        
        Button button = new Button( "Game");
        button.setOnAction(new EventHandler<ActionEvent>() {
            
           
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        Button exit=new Button("exit");
        exit.setOnAction(e->{
            System.exit(0);
        });
        Button newg=new Button("New Game");
        
         roott.setBackground(background);
        roott.setAlignment(Pos.CENTER);
        
        roott.getChildren().addAll(label1,button, exit);
       
                Scene scene1 = new Scene(roott, 1401, 701);
                
                Button btn1 = new Button();
        btn1.setText("Back");
        btn1.setOnAction(e-> {
            
            primaryStage.setScene(scene1);
        });
        Button cra=new Button("Choose Aircraft");
        Button pil=new Button("Pilot Name");
        Button force=new Button("Choose Airforce");
        VBox root1=new VBox(10);
        root1.setAlignment(Pos.CENTER);
        root1.setBackground(background2);
        root1.getChildren().addAll(newg, btn1);
        Scene scene2 = new Scene(root1, 1401, 701);
        button.setOnAction(e-> {
            
            primaryStage.setScene(scene2);
        });
        
        AnchorPane root = new AnchorPane();
        Image blastImage=new Image("redblast.png",300,200,false,true); //hjhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh
        ImageView blastview=new ImageView(blastImage);
                    root.getChildren().add(blastview);
         
       // root.getChildren().add(blast)
        
         Image i1=new Image("mynewbackground.png");
         Image i2=new Image("mynewbackground2.png");
         ImageView iv00=new ImageView(i1);
         ImageView iv01=new ImageView(i2);
         iv00.setX(0);
         iv00.setY(0);
         iv01.setX(1400);
         iv01.setY(0);
         root.getChildren().addAll(iv00,iv01);
         new AnimationTimer()
         {
             public void handle(long now)
             {
                 double pos1x=iv00.getX();
                 double pos2x=iv01.getX();
                 pos1x=pos1x-2;
                 pos2x=pos2x-2;
                 if(pos1x==-1400) pos1x=1400;
                 if(pos2x==-1400) pos2x=1400;
                 iv00.setX(pos1x);
                 iv01.setX(pos2x);
                 
             }
         }.start();
        Scene scene = new Scene(root, 1400, 700);
        fps.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
        newg.setOnAction(e->{
             primaryStage.setScene(scene);
             fff=1;
             try {
                outToServer.writeBytes("101 1100 95 "+ '\n');
                outToServer.writeBytes("102 1200 495 "+ '\n');
            } catch (IOException ex) {
                Logger.getLogger(ImageMove6.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
       /* Image hill=new Image("backback.png");
          Move my=new Move(0,400,root,hill);  
            new AnimationTimer()
        {
            public void handle(long now)
            {
                
                if(my.m.getX()==1300) my.m.setX(0);
                 my.updatepos();
                
                
            }
        }.start();*/
        
        
        
       // Image im = new Image("move.jpg", 800, 600, true, true);
        //ImageView iv = new ImageView(im);
    
    Image iv1 = new Image("myplane.png",200,150,false,true);
    ImageView iv2 = new ImageView(iv1);
    iv2.setX(0);
    iv2.setY(-5);
    root.getChildren().add(iv2);  
   Balling b1=new Balling(2000,2000,root,3,Color.RED);
    Balling b2=new Balling(2000,2000,root,3,Color.RED);
     Balling b3=new Balling(2000,2000,root,3,Color.RED);
    // Balling bb3=new Balling(2000,2000,root,3,Color.RED);
    
     
    scene.setOnMouseClicked(event->{
        System.out.println(event.getX()+" "+event.getY());
    });
   // double t1=bx; double t2=by;
           // Balling b=new Balling(1500,1500,root,5,Color.BLACK);
           Balling []b=new Balling[100];
           for(int bb=0;bb<100;bb++)
           {
               b[bb]=new Balling(1500,1500,root,3,Color.BLACK);
              // root.getChildren().add(b[bb]);
               
           }
    
    
    /*scene.setOnKeyPressed(e->{
        
        if(e.getCode()==KeyCode.RIGHT)
        {
            
            double a=iv2.getX();
            if(a==1400)
            {
                iv2.setX(0);
                bx=113;
                by=94;
            }
            
            else 
            {
                iv2.setX(a+5);
                bx=a+113+5;
            }
        }
        else if(e.getCode()==KeyCode.LEFT)
        {
            double a=iv2.getX();
            if(a>=0)
            {
                iv2.setX(a-5);
                bx=a+113-5;
            }
        }
        else if(e.getCode()==KeyCode.UP)
        {
            double a=iv2.getY();
            if(a>=0)
            {
                iv2.setY(a-5);
                by=a+94-5;
            }
            
            
        }
        else if(e.getCode()==KeyCode.DOWN)
        {
            double a=iv2.getY();
            //if(a==800) {iv2.setY(0); by=94; }
            if(a<=600) { iv2.setY(a+5); by=a+5+94; }
        }
        else if(e.getCode()==KeyCode.ENTER)
        {
            double t1=bx; double t2=by;
            Balling b=new Balling(t1,t2,root,5,Color.BLACK);
            Media music=new Media("file:///C:/Users/Susmi/Downloads/gunsound.mp3");
        MediaPlayer m=new MediaPlayer(music);
        m.setAutoPlay(true);
            
            new AnimationTimer() {

            @Override
            public void handle(long now) {
                
                b.updateCenter();
                //double c1=b.getCenterX();
                //double c2=b.getCenterY();
                
            }
        }.start();
           
                
    }
            
    });*/
    root.getChildren().addAll(fps,fpss);
   
    int j=0,kk=1,i=0;
    //for(int j=0,kk=1;j<=8;j++,kk++)
    //{    
    //for(int i=0;i<4;i++)
  // {
        //double b1=1400,b2=0;
       double c1,c2;
        Image k=new Image("newenemy.png",100,50,false,true);
       EnemyPlane6 ee=new EnemyPlane6(1400,95,root,k);
       EnemyPlane6 ee1=new EnemyPlane6(1200,295,root,k);
      // outToServer.writeBytes("101 1400 95"+ '\n');
       // outToServer.writeBytes("102 1200 295"+ '\n');
       //EnemyPlane6 ee2=new EnemyPlane6(1400+kk*(i*5+j)*700,595,root,k);
       
                  scene.setOnKeyPressed((KeyEvent e)->{
        
        if(e.getCode()==KeyCode.RIGHT)
        {
            
            double a=iv2.getX();
            if(a<=1400)
            {
                iv2.setX(a+5);
                bx=a+113+5;
            }
            double f2=iv2.getX()+5;
            /*if(a==1400)
            {
                iv2.setX(0);
                bx=113;
                by=94;
            }*/
            
            
            { 
               try {
                   outToServer.writeBytes("13 " +f2+ '\n');
                   } catch (IOException ex) {
                     Logger.getLogger(ImageMove6.class.getName()).log(Level.SEVERE, null, ex);
                   }
             }
        }
        else if(e.getCode()==KeyCode.LEFT)
        {
            double a=iv2.getX();
            if(a>=0)
            {
                iv2.setX(a-5);
                bx=a+113-5;
            }
            double f1=iv2.getX()-5;
            
            {
            try {
                     outToServer.writeBytes("12 " +f1+ '\n');
                        } catch (IOException ex) {
                       Logger.getLogger(ImageMove6.class.getName()).log(Level.SEVERE, null, ex);
             }
            }
            
        }
        else if(e.getCode()==KeyCode.UP)
        {
            double a=iv2.getY();
            if(a>=0)
            {
                iv2.setY(a-5);
                by=a+95-5;
            }
            double f3=iv2.getY()-5;
            { 
                                    try {
                                        outToServer.writeBytes("11 " +f3+ '\n');
                                    } catch (IOException ex) {
                                        Logger.getLogger(ImageMove6.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
            
            
            
            
        }
        else if(e.getCode()==KeyCode.DOWN)
        {
            double a=iv2.getY();
            //if(a==800) {iv2.setY(0); by=94; }
            if(a<=600) { iv2.setY(a+5); by=a+5+95; }
            double f4=iv2.getY()+5;
            { 
                                    try {
                                        outToServer.writeBytes("14 " +f4+ '\n');
                                    } catch (IOException ex) {
                                        Logger.getLogger(ImageMove6.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
        }
        else if(e.getCode()==KeyCode.ENTER)
        {
           // double t1=bx; double t2=by;
           // Balling b=new Balling(t1,t2,root,5,Color.BLACK);
            
            b[count].setCenterX(bx);
            b[count].setCenterY(by);
            count++;
            count1++;
            { 
                                    try {
                                        outToServer.writeBytes("15 " +bx+" "+by+ '\n');
                                    } catch (IOException ex) {
                                        Logger.getLogger(ImageMove6.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
            Media music=new Media("file:///C:/Users/Susmi/Downloads/gunsound.mp3");
        MediaPlayer m1=new MediaPlayer(music);
        m1.setAutoPlay(true);
            
           /* new AnimationTimer() {

            //@Override
            public void handle(long now) {
                
                b.updateCenter();
                
                
                
            }
        }.start();*/
            
            
           
                
    }
        
            
    });
       
       
       
       
       
        new AnimationTimer()
        {
            public void handle(long now)
            {
                if(fff==1)ee.updatepos();
                if(fff==1)ee1.updatepos();
                //ee2.updatepos();
                b1.updateCenter1();
                b2.updateCenter1();
                //bb3.updateCenter1();
                 fpss.setText(String.format("%s","score"));
                fps.setText(String.format("%d",score));
                if(ee.gettx()==800)
                {
                    b1.setCenterX(800);
                    b1.setCenterY(ee.getty()+36);
                }
                if(score == 100)
                {
                    primaryStage.setScene(scenen);
                    fps1.setText(String.format("%s","score "));
                    fps2.setText(String.format("%d",score));
                }
                
                if(ee1.gettx()==900)
                {
                    b2.setCenterX(900);
                    b2.setCenterY(ee1.getty()+36);
                }
                /*if(ee2.gettx()==1000)                                                                                                                                                                                                             
                {
                    bb3.setCenterX(1000);
                    bb3.setCenterY(ee2.getty()+36);
                }*/
                if(b2.getCenterX()<=iv2.getX()+198 &&b2.getCenterX()>=iv2.getX()  && b2.getCenterY()<=iv2.getY()+95 && b2.getCenterY()>=iv2.getY()+50)
                {
                   // System.exit(0);
                    ImageView blastview=new ImageView(blastImage);
                    Blasting6 bla6=new Blasting6(blastview,iv2.getX(),iv2.getY()-30,root);
                    primaryStage.setScene(scene4);
                    fps1.setText(String.format("%s","score "));
                    fps2.setText(String.format("%d",score));
                }
                if(b1.getCenterX()<=iv2.getX()+198 && b1.getCenterX()>=iv2.getX()&& b1.getCenterY()<=iv2.getY()+95 && b1.getCenterY()>=iv2.getY()+50 )
                {
                    //System.exit(0);
                    ImageView blastview=new ImageView(blastImage);
                    Blasting6 bla7=new Blasting6(blastview,iv2.getX(),iv2.getY()-30,root);
                    primaryStage.setScene(scene4);
                    fps1.setText(String.format("%s","score "));
                    fps2.setText(String.format("%d",score));
                    
                }
               /* if(bb3.getCenterX()<=iv2.getX()+198 && bb3.getCenterX()>=iv2.getX()&& bb3.getCenterY()<=iv2.getY()+95 && bb3.getCenterY()>=iv2.getY()+50 )
                {
                    ImageView blastview=new ImageView(blastImage);
                    //System.exit(0);
                    Blasting6 bla8=new Blasting6(blastview,iv2.getX(),iv2.getY()-30,root);
                    primaryStage.setScene(scene4);
                    fps1.setText(String.format("%s","score "));
                    fps2.setText(String.format("%d",score));
                }*/
                if(ee.ii.getX()<=iv2.getX()+198 && ee.ii.getX()>=iv2.getX() && ee.ii.getY()+20>=iv2.getY()+28 && ee.ii.getY()<=iv2.getY()+96)
                {
                    ImageView blastview=new ImageView(blastImage);
                    //System.exit(0);
                    Blasting6 bla11=new Blasting6(blastview,iv2.getX(),iv2.getY()-30,root);
                    primaryStage.setScene(scene4);
                    fps1.setText(String.format("%s","score "));
                    fps2.setText(String.format("%d",score));
                }
                if(ee1.ii.getX()<=iv2.getX()+198 && ee1.ii.getX()>=iv2.getX() && ee1.ii.getY()+20>=iv2.getY()+28 && ee1.ii.getY()<=iv2.getY()+96)
                {
                    ImageView blastview=new ImageView(blastImage);
                    //System.exit(0);
                    Blasting6 bla12=new Blasting6(blastview,iv2.getX(),iv2.getY()-30,root);
                    primaryStage.setScene(scene4);
                    fps1.setText(String.format("%s","score "));
                    fps2.setText(String.format("%d",score));
                }
                /*if(ee2.ii.getX()<=iv2.getX()+198 && ee2.ii.getX()>=iv2.getX() && ee2.ii.getY()+20>=iv2.getY()+28 && ee2.ii.getY()<=iv2.getY()+96)
                {
                    ImageView blastview=new ImageView(blastImage);
                    //System.exit(0);
                    Blasting6 bla13=new Blasting6(blastview,iv2.getX(),iv2.getY()-30,root);
                    primaryStage.setScene(scene4);
                    fps1.setText(String.format("%s","score "));
                    fps2.setText(String.format("%d",score));
                }*/
                
                
                /*for(int m=0;m<count;m++)
                {
                    if(b[m].getx()>1400)
                    {
                        count--;
                        for(int n=1;n<=count;n++)
                        {
                            b[n-1]=b[n];
                        }
                    }
                }*/
                /* b.updateCenter();
               
                System.out.println(b.getCenterX()+" "+ee.ii.getX());*/
                for(int m=0;m<count;m++)
                {
                   /* if((b[m].getCenterX()>=ee2.ii.getX()&& b[m].getCenterX()<=ee2.ii.getX()+7 )&& b[m].getCenterY()<=ee2.ii.getY()+40 && b[m].getCenterY()>=ee2.ii.getY()+16)
                {
                    System.out.println("hello");
                    ImageView blastview=new ImageView(blastImage);
                    Blasting6 bla3=new Blasting6(blastview,ee2.ii.getX(),ee2.ii.getY()-15,root);
                    
                     System.out.println("blast image co ordinate set");
                     
                     b[m].setCenterX(1800);
                     b[m].setCenterX(1800);
                     ee2.ii.setX(1400);
                    ee2.ii.setY(425);
                    score=score+10;
                     Media music3=new Media("file:///C:/Users/Susmi/Downloads/gunsound.mp3");
        MediaPlayer m3=new MediaPlayer(music3);
                   
                }*/
                    
                    
                    
                    
            if((b[m].getCenterX()>=ee.ii.getX()&& b[m].getCenterX()<=ee.ii.getX()+7 )&& b[m].getCenterY()<=ee.ii.getY()+40 && b[m].getCenterY()>=ee.ii.getY()+16)
                {
                    System.out.println("hello");
                    
                    
                    /*Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(2500),
                    ae -> doSomething()));
                    timeline.play();

// later
                    timeline.stop();*/
                    
                    
                    
                    
                    
                    ImageView blastview=new ImageView(blastImage);
                    //root.getChildren().add(blastview);
                    Blasting6 bla=new Blasting6(blastview,ee.ii.getX(),ee.ii.getY()-15,root);
                    
                 
                    
                    
                    
                    
                    
                     System.out.println("blast image co ordinate set");
                     
//                     blastview.setX(ee.ii.getX()-40);
//                     blastview.setY(ee.ii.getY()-30);
                       /*double d1=ee.ii.getX() , d2=ee.ii.getY() ;
                    Timeline timeline = new Timeline(new KeyFrame(
                        Duration.millis(500),
                        ae -> doSomething(blastview,d1,d2)));
                    timeline.play(); 
                    timeline.stop();
                    blastview.setX(1500);
                    blastview.setY(1500);*/
                    
                     
                     
                     
                     b[m].setCenterX(1800);
                     
                      
                     ee.ii.setX(1400);
                     ee.ii.setY(525);
                     try {
                            outToServer.writeBytes("101 1400 525"+'\n');
                        } catch (IOException ex) {
                            Logger.getLogger(ImageMove6.class.getName()).log(Level.SEVERE, null, ex);
                        }
                     
                     
                     blastview.setX(1500);
                    blastview.setY(1500);
                    /*new AnimationTimer()
                    {
                        public void Handle(long now)
                        {
                            blastview.setX(blastview.getX());
                            blastview.setY(blastview.getY());
                        }
                        
                    }.start();*/
                    score=score+10;
                     Media music2=new Media("file:///C:/Users/Susmi/Downloads/gunsound.mp3");
        MediaPlayer m2=new MediaPlayer(music2);
       // m2.setAutoPlay(true); 
                    //cc1=0;
                    
                    
                    //ee.updatepos();
                   
                }
            if((b[m].getCenterX()>=ee1.ii.getX()&& b[m].getCenterX()<=ee1.ii.getX()+7 )&& b[m].getCenterY()<=ee1.ii.getY()+40 && b[m].getCenterY()>=ee1.ii.getY()+16)
                {
                    System.out.println("hello");
                    ImageView blastview=new ImageView(blastImage);
                    Blasting6 bla2=new Blasting6(blastview,ee1.ii.getX(),ee1.ii.getY()-15,root);
                    
                     System.out.println("blast image co ordinate set");
                     //blastview.setX(b[m].getCenterX());
                     //blastview.setY(b[m].getCenterY());
                     b[m].setCenterX(1800);
                     b[m].setCenterX(1800);
                     ee1.ii.setX(1400);
                    ee1.ii.setY(125);
                    try {
                            outToServer.writeBytes("102 1400 125"+'\n');
                        } catch (IOException ex) {
                            Logger.getLogger(ImageMove6.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    score=score+10;
                     Media music3=new Media("file:///C:/Users/Susmi/Downloads/gunsound.mp3");
        MediaPlayer m3=new MediaPlayer(music3);
                   
                }
                }
                
                if(ee.ii.getX()<-100)
                {
                    ee.ii.setX(1400);
                    ee.ii.setY(225);
                    try {
                            outToServer.writeBytes("101 1400 225"+'\n');
                        } catch (IOException ex) {
                            Logger.getLogger(ImageMove6.class.getName()).log(Level.SEVERE, null, ex);
                        }
                
                }
                /*if(ee2.ii.getX()<-100)
                {
                    ee2.ii.setX(1400);
                    ee2.ii.setY(600);
                
                }*/
               
                if(ee1.ii.getX()<-100)
                {
                    ee1.ii.setX(1400);
                    ee1.ii.setY(435);
                    try {
                            outToServer.writeBytes("102 1400 435"+'\n');
                        } catch (IOException ex) {
                            Logger.getLogger(ImageMove6.class.getName()).log(Level.SEVERE, null, ex);
                        }
                
                }
    
               for(int m=0;m<count;m++)
                {
                    b[m].updateCenter();
                    /*if(b[m].getx()>1400)
                    {
                        count--;
                        for(int n=1;n<=count;n++)
                        {
                            b[n-1]=b[n];
                        }
                        
                    }*/
                    
                }
               
               
                
            }

                
        }.start();
    //}
    //}
    

    
    


    
  
    
    primaryStage.setScene(scene1);
    
    primaryStage.show();
}
        catch (Exception e) {
                e.printStackTrace();
            }

            }
    

    public static void main(String[] args) throws Exception{
        inFromUser = new BufferedReader(new InputStreamReader(System.in));
        clientSocket = new Socket("localhost", 6789);
        outToServer = new DataOutputStream(clientSocket.getOutputStream());
        inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        launch(args);
    }
    
}
