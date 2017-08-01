package pong;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameDraw extends DoubleBuffer implements KeyListener{
    MyFrame parrentFrame;
    Pad player1pad;
    Pad player2pad;
    Arena arena;
    Ball ball;

    public GameDraw(MyFrame F) {
        this.parrentFrame = F;
        this.setBackground(Color.BLACK);
        this.addKeyListener(this);
        
        player1pad = new Pad(20, 90, 10, 10, 5, Color.WHITE);
        player2pad = new Pad(20, 90, 760, 10, 5, Color.WHITE);
        arena = new Arena(new Point(0, 0), new Point(794, 572), 5,
                new Point(5,0), new Point(10, 900),
                new Point(780,0), new Point(785, 900));
        ball = new Ball(300, 300, 3, 3, 10);
        
        
        
    }
    
    @Override
    public void paintBuffer(Graphics g) {
        player1pad.draw(g);
        player2pad.draw(g);
        
        ball.draw(g);
        g.setFont(new Font("OCR A Extended", 1, 60));
        g.drawString(player1pad.getPoints() + ":" + player2pad.getPoints(), 330, 50);
        
        /**
         * Used if you want to see deadzones
         * 
        g.drawRect(arena.player1DeadZoneUpperLeftPoint.x, arena.player1DeadZoneUpperLeftPoint.y,
                arena.player1DeadZoneLowerRightPoint.x-arena.player1DeadZoneUpperLeftPoint.x,
                arena.player1DeadZoneLowerRightPoint.y-arena.player1DeadZoneUpperLeftPoint.y);
        g.drawRect(arena.player2DeadZoneUpperLeftPoint.x, arena.player2DeadZoneUpperLeftPoint.y,
                arena.player2DeadZoneLowerRightPoint.x-arena.player2DeadZoneUpperLeftPoint.x,
                arena.player2DeadZoneLowerRightPoint.y-arena.player2DeadZoneUpperLeftPoint.y);
        **/
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W)
            player1pad.setUp(true);
        
        if (e.getKeyCode() == KeyEvent.VK_S)
            player1pad.setDown(true);
        
        if (e.getKeyCode() == KeyEvent.VK_UP) 
            player2pad.setUp(true);
        
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            player2pad.setDown(true);
        
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //nothing
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W)
            player1pad.setUp(false);
        
        if (e.getKeyCode() == KeyEvent.VK_S)
            player1pad.setDown(false);
        
        if (e.getKeyCode() == KeyEvent.VK_UP) 
            player2pad.setUp(false);
        
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            player2pad.setDown(false);
    }
    
    
    
    
}
