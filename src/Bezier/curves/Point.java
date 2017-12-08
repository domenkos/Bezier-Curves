package Bezier.curves;


import java.awt.*;

public class Point {
    private int x;
    private int y;
    private boolean interpolirana;
    public Graphics g;

    Point(int x, int y, boolean interpolirana, Graphics g){
        this.x = x;
        this.y = y;
        this.interpolirana = interpolirana;
        this.g = g;
        this.drawPoint();
    }

    Point(int x, int y){
        this.x = x;
        this.y = y;
        this.interpolirana = true;
    }

    public void drawPoint(){
        g.setColor(this.interpolirana ? Color.GREEN : Color.RED);
        this.g.drawRect(this.x, this.y, this.interpolirana ? 7 : 5, this.interpolirana ? 7 : 5);
    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public boolean getInterpolated(){
        return this.interpolirana;
    }

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setIntepolated(boolean interpolated){
        this.interpolirana = interpolated;
    }



}
