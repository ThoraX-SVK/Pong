/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.Color;
import java.awt.Graphics;
import jdk.nashorn.internal.parser.TokenType;


/**
 *
 * @author Tom
 */
public class Pad {
    
    private int width;
    private int height;
    private int posX;
    private double posY;
    private boolean up;
    private boolean down;
    private int speed;
    private Color C;
    private int points;

    public Pad(int width, int height, int posX, int posY, int speed, Color C) {
        this.width = width;
        this.height = height;
        this.posX = posX;
        this.posY = posY;
        this.up = false;
        this.down = false;
        this.speed = speed;
        this.C = C;
        this.points = 0;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Color getC() {
        return C;
    }

    public void setC(Color C) {
        this.C = C;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    
    public void draw(Graphics g) {
        g.setColor(C);
        g.fillRect(posX, (int)posY, width, height);
    }
    
    public void update(double deltaTime, Arena arena) {
        
        if (this.up && this.down) {
            return;
        } else if (this.up) {
            posY = posY - this.speed * deltaTime;
            
            if (posY <= arena.upperLeft.y + arena.wallWidth)
                posY = arena.upperLeft.y + arena.wallWidth;
            
        }
        else if (this.down) {
            posY = posY + this.speed * deltaTime;
            if (posY + height >= arena.lowerRight.y - arena.wallWidth)
                posY = arena.lowerRight.y - arena.wallWidth - height;
        }
        
            
    }
    
}
