package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Ball {
    double posX;
    double posY;
    double speedX;
    double speedY;
    int size;
    
    public Ball(double posX, double posY, double speedX, double speedY, int size) {
        this.posX = posX;
        this.posY = posY;
        this.speedX = speedX;
        this.speedY = speedY;
        this.size = size;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public double getSpeedX() {
        return speedX;
    }

    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    public double getSpeedY() {
        return speedY;
    }

    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect((int)posX, (int)posY, size, size);
    }

    public void update(double deltaTime, Arena arena, Pad player1, Pad player2) { 
        posX = this.posX + this.speedX * deltaTime;
        posY = this.posY + this.speedY * deltaTime;
        
        if (overlapsSquare(new Point(player1.getPosX(), (int)player1.getPosY()), 
                new Point(player1.getPosX() + player1.getWidth(), (int)player1.getPosY() +player1.getHeight())))
            this.speedX = -this.speedX;
          
        if (overlapsSquare(new Point(player2.getPosX(), (int)player2.getPosY()), 
                new Point(player2.getPosX() + player2.getWidth(), (int)player2.getPosY() +player2.getHeight())))
            this.speedX = -this.speedX;
       
        
        if ((int)posY > arena.lowerRight.y) {
            this.speedY = -this.speedY;
            //System.out.println("Dolna hrana");
        }
        if ((int)posY < arena.upperLeft.y) {
            this.speedY = - this.speedY;
            //System.out.println("Horna hrana");
        }
        
        if (overlapsSquare(arena.player2DeadZoneUpperLeftPoint, arena.player2DeadZoneLowerRightPoint)) {
            
            player1.setPoints(player1.getPoints() + 1);
            resetBall();
        }
        if (overlapsSquare(arena.player1DeadZoneUpperLeftPoint, arena.player1DeadZoneLowerRightPoint)) {
            player2.setPoints(player2.getPoints() + 1);
            resetBall();
        }
        
        
    }
    
    public boolean overlapsSquare(Point upperLeft, Point lowerRight) {
        return this.posX > upperLeft.x && this.posX < lowerRight.x &&
               this.posY > upperLeft.y && this.posY < lowerRight.y;
    }
    
    public void resetBall() {
        posX = Math.random() * 100 + 300;
        posY = Math.random() * 100 + 300;
    }
}
   
