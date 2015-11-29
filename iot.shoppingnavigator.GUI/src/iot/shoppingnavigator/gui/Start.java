package iot.shoppingnavigator.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Start extends JFrame {

    public Start() {
        System.out.println("Start GUI");

        initUI();
    }
    
    private void initUI() {
        
        add(new Board());
        
        setSize(800, 800);
        setResizable(true);
        System.out.println("Created Board");

        setTitle("Moving sprite");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                Start ex = new Start();
                ex.setVisible(true);
            }
        });
    }
}