/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Fayez
 */
public class Health {
    int hp;
    Image hearts;

    public Health() {
        hp=5;
        ImageIcon im=new ImageIcon("maxhp.png");
        hearts=im.getImage();
    }
    public void decreasehp(){
        if(hp>1){
            hp--;
            ImageIcon im = null;
            if(hp==4)
                im=new ImageIcon("4hp.png");
            if(hp==3)
                im=new ImageIcon("3hp.png");
            if(hp==2)
                im=new ImageIcon("2hp.png");
            if(hp==1)
                im=new ImageIcon("1hp.png");
            hearts=im.getImage();
        }
    }
    public void increasehp(){
        ImageIcon im = null;
        if(hp<5){
            hp++;
            if(hp==4)
                im=new ImageIcon("4hp.png");
            if(hp==3)
                im=new ImageIcon("3hp.png");
            if(hp==2)
                im=new ImageIcon("2hp.png");
            if(hp==5)
                im=new ImageIcon("maxhp.png");
            hearts=im.getImage();
        }
    }

    public int getHp() {
        return hp;
    }
    public Image getHearts() {
        return hearts;
    }
}
