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
public class Coins {
    int x,y;
    boolean collected;
    Image coin;
    public Coins(){
        Random r=new Random();
        collected=false;
        ImageIcon im=new ImageIcon("coin.jpg");
        coin=im.getImage();
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

    public boolean isCollected() {
        return collected;
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }

    public Image getCoin() {
        return coin;
    }
    
}
