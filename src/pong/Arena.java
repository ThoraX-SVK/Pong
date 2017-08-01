package pong;

import java.awt.Point;

public class Arena {
    Point upperLeft;
    Point lowerRight;
    int wallWidth;
    Point player1DeadZoneUpperLeftPoint;
    Point player1DeadZoneLowerRightPoint;
    Point player2DeadZoneUpperLeftPoint;
    Point player2DeadZoneLowerRightPoint;

    public Arena(Point upperLeft, Point lowerRight, int wallWidth, Point player1DeadZoneUpperLeftPoint, Point player1DeadZoneLowerRightPoint, Point player2DeadZoneUpperLeftPoint, Point player2DeadZoneLowerRightPoint) {
        this.upperLeft = upperLeft;
        this.lowerRight = lowerRight;
        this.wallWidth = wallWidth;
        this.player1DeadZoneUpperLeftPoint = player1DeadZoneUpperLeftPoint;
        this.player1DeadZoneLowerRightPoint = player1DeadZoneLowerRightPoint;
        this.player2DeadZoneUpperLeftPoint = player2DeadZoneUpperLeftPoint;
        this.player2DeadZoneLowerRightPoint = player2DeadZoneLowerRightPoint;
    }

    

    public Point getUpperLeft() {
        return upperLeft;
    }

    public void setUpperLeft(Point upperLeft) {
        this.upperLeft = upperLeft;
    }

    public Point getLowerRight() {
        return lowerRight;
    }

    public void setLowerRight(Point lowerRight) {
        this.lowerRight = lowerRight;
    }

    public int getWallWidth() {
        return wallWidth;
    }

    public void setWallWidth(int wallWidth) {
        this.wallWidth = wallWidth;
    }

    
    
    
}
