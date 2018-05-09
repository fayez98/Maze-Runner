/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author Fayez
 */
public class Bombs {
     int x,y;
    boolean active;
    Image bomb;
    public Bombs(){
        Random r=new Random();
        active=true;
        ImageIcon im=new ImageIcon("bomb.png");
        bomb=im.getImage();
        Maze m=new Maze();
        x=r.nextInt(29);
        y=r.nextInt(29);
        while(m.map[y][x]==0){
            x=r.nextInt(29);
            y=r.nextInt(29);
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Image getBomb() {
        return bomb;
    }

    
}
