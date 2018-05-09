/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Image;
import java.awt.*;
import java.util.*;
import javax.swing.ImageIcon;

/**
 *
 * @author Fayez
 */
public class Monster {
    int x,y,direction=0,counter;
    Image mon;
    Maze m;
    boolean alive;
    Toolkit toolkit;
    Timer timer;
    public Monster() {
        Random r=new Random();
        ImageIcon im=new ImageIcon("monster1.jpg");
        mon=im.getImage();
        alive=true;
        m=new Maze();
        x=r.nextInt(29);
        y=r.nextInt(29);
        while(m.map[y][x]==0){
            x=r.nextInt(29);
            y=r.nextInt(29);
        }
        toolkit = Toolkit.getDefaultToolkit();
        timer = new Timer();
        timer.schedule(new movement(),0,1000);
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    public class movement extends TimerTask{

        @Override
        public void run() {
            move();
        }
    
    }
    public void move(){
        Random r=new Random();
        if(x==29&&y==1){
             while(m.map[y][x]==0){
            x=r.nextInt(29);
            y=r.nextInt(29);
             }
        }
    else{
        if(counter==10){
            int temp=direction;
            while(direction==temp)
                direction=r.nextInt(3);
            counter=0;
        }
        if(direction==0){
            if(m.map[y][x+1]!=0)
                x++;
            else
                direction =3;
        }
        if(direction==1){
            if(m.map[y][x-1]!=0)
                x--;
            else
                direction=2;
        
        }
        if(direction==2){
            if(m.map[y+1][x]!=0)
                y++;
            else
                direction =0;
        }
        if(direction==3){  
            if(m.map[y-1][x]!=0)
                y--;
            direction=1;
        }
        counter++;
        }
    }
    public Image getm(){
        return mon;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
