/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.image.*;

/**
 *
 * @author Fayez
 */
public class Animation {
    BufferedImage[] frames;
    int frame;
    long time,delay;
    boolean played;
    public void Animation(){
        played=false;
    }
    public void setframes(BufferedImage[] frames){
        this.frames=frames;
        frame=0;
        time=System.nanoTime();
        played=false;
    }

    public void setFrame(int frame) {
        this.frame = frame;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }
    
    public void update(){
        if(delay==-1)
            return;
        long el=(System.nanoTime()-time)/1000000;
        if(el>delay){
            frame++;
            time=System.nanoTime();
        }
        if(frame==frames.length){
            frame=0;
            played=true;
        }
        
    }

    public BufferedImage getImage() {
        return frames[frame];
    }

    public int getFrame() {
        return frame;
    }

    public boolean isPlayed() {
        return played;
    }
    
    
}
