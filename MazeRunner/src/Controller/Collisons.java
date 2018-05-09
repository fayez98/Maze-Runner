/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;

/**
 *
 * @author Fayez
 */
public class Collisons {
    
    public int monster(Player p,Monster[] m){
    for(int i=0;i<4;i++){
        if(p.getX()==m[i].getX()&&p.getY()==m[i].getY()){
            p.setHp(p.getHp()-1);
            return 1;
        }
    }
        return 0;
    }
    public int coin(Player p,Coins[] c){
        for(int i=0;i<6;i++){
            if(!c[i].isCollected())
                if(p.getX()==c[i].getX()&&p.getY()==c[i].getY())
                    return i;
        }
        return -1;
    }
    public int bomb(Player p,Bombs[] b){
        for(int i=0;i<5;i++){
            if(b[i].isActive())
                if(p.getX()==b[i].getX()&&p.getY()==b[i].getY())
                    return i;
        }
        return -1;
    }
    public int heart(Player p,Hearts[] h){
        for(int i=0;i<4;i++){
            if(!h[i].isCollected())
                if(p.getX()==h[i].getX()&&p.getY()==h[i].getY())
                    return i;
        }
        return -1;
    }
}
