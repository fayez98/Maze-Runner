/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Fayez
 */
public class Player {
    int x,y,hp,maxhp;
    Image pl;
    public Player() {
        ImageIcon im=new ImageIcon("player.png");
        pl=im.getImage();
        x=1;
        y=19;
        hp=maxhp=5;
    }
    public void move(int tx,int ty){
        if(x==29&&y==1);
        else{
        x+=tx;
        y+=ty;}
    }
    public Image getp(){
        return pl;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
    
}
