package iot.shoppingnavigator.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Person person;
    private final int DELAY = 100;
    private Image background;
    
    public Board() {

        initBoard();
    }
    
    private void initBoard() {
        
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);

        person = new Person();

        timer = new Timer(DELAY, this);
        timer.start();    
        
        ImageIcon ii = new ImageIcon("/Users/danielpazinato/Documents/workspace/GUI/src/com/zetcode/shopping.png");
        background = ii.getImage();
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);

        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(background,0,0,this);
        g2d.drawImage(person.getImage(), person.getX(), person.getY(), this);        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        person.move();
        repaint();  
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
        	System.out.println(e);
            person.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            person.keyPressed(e);
        }
    }
}