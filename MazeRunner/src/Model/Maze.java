/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fayez
 */
public class Maze {
    public int[][] map=new int[30][30];
    public Maze(){
        file();
    }
    public void file(){
        int i=0,j=0;
        try {
            Scanner sc = new Scanner(new File("map.txt"));
            for(i=0;i<30;i++)
                for(j=0;j<30;j++)
                    map[i][j]=sc.nextInt();
            sc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Maze.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
