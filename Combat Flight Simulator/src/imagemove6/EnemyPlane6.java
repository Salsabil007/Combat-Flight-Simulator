/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagemove6;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Susmi
 */
class EnemyPlane6 
{
    
    public ImageView ii;
    
    
    EnemyPlane6(double x,double y,AnchorPane root,Image II)
    {
        ii=new ImageView(II);
        root.getChildren().add(ii);
        ii.setX(x);
        ii.setY(y);
                    
    }
    public double gettx()
    {
        return ii.getX();
    }
    public double getty()
    {
        return ii.getY();
    }
    public void updatepos()
    {
        
        ii.setX(ii.getX()-1);
    }
}

