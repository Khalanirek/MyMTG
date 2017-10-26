/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mymtg;

import java.awt.EventQueue;
import javax.swing.JFrame;
import mymtg.DeckCreator.*;

/**
 *
 * @author Piotr Turliński
 */
public class MyMTG {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        EventQueue.invokeLater(() -> 
        {
            JFrame frame = new DeckCreatorFrame();         
            frame.setVisible(true);
        });
    }
    
}
