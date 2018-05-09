/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Collisons;
import Model.Bombs;
import Model.Coins;
import Model.Health;
import Model.Hearts;
import Model.Maze;
import Model.Monster;
import Model.Player;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Fayez
 */
public class Map extends JPanel implements ActionListener{
    private javax.swing.Timer clock;
    Collisons coll;
    Toolkit toolkit;
    boolean alive=true;
    java.util.Timer timer;
    double time;
    int collect,ch,hitb,explodee=0,hitm;
    Maze m;
    Health health;
    Image tree,grass,player,explosion;
    Player p;
    Hearts[] hearts=new Hearts[4];
    Coins[] coins=new Coins[6];
    Bombs[] bombs=new Bombs[5];
    Monster[] monster=new Monster[4];
    public Map() throws IOException{
        m=new Maze();
        p=new Player();
        health=new Health();
        coll=new Collisons();
        for(int i=0;i<4;i++){
            hearts[i]=new Hearts();
            monster[i]=new Monster();
        }
        for(int i=0;i<5;i++)
            bombs[i]=new Bombs();
        for(int i=0;i<6;i++)
            coins[i]=new Coins();
        addKeyListener(new AI());
        setFocusable(true);
        toolkit = Toolkit.getDefaultToolkit();
        timer = new java.util.Timer();
        timer.schedule(new Win(),0,100);
        timer.schedule(new Hitm(),0,500);
        ImageIcon im=new ImageIcon("tree.jpg");
        tree=im.getImage();
        im=new ImageIcon("grass.jpg");
        grass=im.getImage();
        clock=new Timer(25,this);
        clock.start();
    }
    public void paint(Graphics g){
            int i,j;
            super.paint(g);
            for(i=0;i<30;i++)
                for(j=0;j<30;j++){
                    if(m.map[i][j]==0)
                        g.drawImage(tree,(j*30),(i*25),null);
                    if(m.map[i][j]==1)
                        g.drawImage(grass,(j*30),(i*25),null);
                }
            for(i=0;i<6;i++)
                if(!coins[i].isCollected())
                    g.drawImage(coins[i].getCoin(),coins[i].getX()*30,coins[i].getY()*25,null);
            for(i=0;i<5;i++)
                if(bombs[i].isActive())
                    g.drawImage(bombs[i].getBomb(),bombs[i].getX()*30,bombs[i].getY()*25, null);
            for(i=0;i<4;i++)
                if(!hearts[i].isCollected())
                      g.drawImage(hearts[i].getHeart(),hearts[i].getX()*30,hearts[i].getY()*25,null);
            for(i=0;i<4;i++)
                if(monster[i].isAlive())
                    g.drawImage(monster[i].getm(), monster[i].getX()*30,monster[i].getY()*25, null);
            g.drawImage(health.getHearts(),(30*30)-100, 0,null);
            g.drawImage(p.getp(),p.getX()*30,p.getY()*25,null);
    }   
    public class AI extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            int c=e.getKeyCode();
            
            if(c==KeyEvent.VK_UP){
                if(m.map[p.getY()-1][p.getX()]!=0){
                    collect=coll.coin(p, coins);
                    hitb=coll.bomb(p,bombs);
                    ch=coll.heart(p, hearts);
                    if(ch!=-1&&health.getHp()!=5){
                        hearts[ch].setCollected(true);
                        health.increasehp();
                    }
                    if(hitb!=-1){
                        bombs[hitb].setActive(false);
                        health.decreasehp();
                    }
                    if(collect!=-1)
                        coins[collect].setCollected(true);
                    p.move(0,-1);
                }
            }
            if(c==KeyEvent.VK_DOWN){
                if(m.map[p.getY()+1][p.getX()]!=0){
                    collect=coll.coin(p, coins);
                    hitb=coll.bomb(p,bombs);
                    ch=coll.heart(p, hearts);
                    if(ch!=-1&&health.getHp()!=5){
                        hearts[ch].setCollected(true);
                        health.increasehp();
                    }
                    if(hitb!=-1){
                        bombs[hitb].setActive(false);
                        health.decreasehp();
                    }
                    if(collect!=-1)
                        coins[collect].setCollected(true);
                    p.move(0,1);
                }
            }
            if(c==KeyEvent.VK_RIGHT){
                if(m.map[p.getY()][p.getX()+1]!=0){
                    collect=coll.coin(p, coins);
                    hitb=coll.bomb(p,bombs);
                    ch=coll.heart(p, hearts);
                    if(ch!=-1&&health.getHp()!=5){
                        hearts[ch].setCollected(true);
                        health.increasehp();
                    }
                    if(hitb!=-1){
                        bombs[hitb].setActive(false);
                        health.decreasehp();
                    }
                    if(collect!=-1)
                        coins[collect].setCollected(true);
                    p.move(1,0);
                }
            }
            if(c==KeyEvent.VK_LEFT){
                if(m.map[p.getY()][p.getX()-1]!=0){
                    collect=coll.coin(p, coins);
                    hitb=coll.bomb(p,bombs);
                    ch=coll.heart(p, hearts);
                    if(ch!=-1&&health.getHp()!=5){
                        hearts[ch].setCollected(true);
                        health.increasehp();
                    }
                    if(hitb!=-1){
                        bombs[hitb].setActive(false);
                        health.decreasehp();
                    }
                    if(collect!=-1)
                        coins[collect].setCollected(true);
                     p.move(-1,0);
                }
            }
        }
        public void keyReleased(KeyEvent e){
            
        }
        public void keytyped(KeyEvent e){
            
        }
    }
    public class Hitm extends TimerTask{

        @Override
        public void run() {
            hitm=coll.monster(p, monster);
            if(hitm==1){
                if(health.getHp()==1){
                }
                else
                    health.decreasehp();
            }
        }
    }
    public class Win extends TimerTask{

        @Override
        public void run() {
            if(p.getX()==29&&p.getY()==1)
                System.out.println("WINNNN");
        }
        
    }
    @Override
    public void actionPerformed(ActionEvent evt) {
       repaint(); 
    }
    
}
