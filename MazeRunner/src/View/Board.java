/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Fayez
 */
public class Board {
    public static void main(String[] args){
        new Board();
    }
    public Board(){
        JFrame map= new JFrame();
        try {
            map.add(new Map());
        } catch (IOException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        }
        map.setSize(30*30,30*25);
        map.setVisible(true);
        map.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

