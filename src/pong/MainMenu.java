package pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MainMenu extends Frame implements MouseListener{
    
    
    

    public MainMenu(String title,int choice) {
        super(title);
        this.setSize(500, 600);
        this.setBackground(Color.BLACK);
        this.setResizable(false);
        this.addMouseListener(this);
        this.setLocationRelativeTo(null);
        
        this.setVisible(true);
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("OCR A Extended", 1, 60));
        
        g.drawString("Pong", 170, 150);
        
        g.setFont(new Font("OCR A Extended", 1, 40));
        g.drawString("New Game", 150, 300);
        g.drawString("Options", 160, 360);
        g.drawString("Exit", 200, 420);
        
        g.drawRect(130, 260, 250, 60);
        g.drawRect(130, 320, 250, 60);
        g.drawRect(130, 380, 250, 60);

        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
        if (overlapsSquare(new Point(130, 260), new Point(130+250, 260+60), e.getPoint())) {
            
            dispose();
           
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private boolean overlapsSquare(Point upperLeft, Point lowerRight, Point p) {
        return p.x > upperLeft.x && p.x < lowerRight.x &&
               p.y > upperLeft.y && p.y < lowerRight.y;
    }

}
