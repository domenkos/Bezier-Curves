package Bezier.curves;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

public class Bezier extends JPanel{
    static int x;
    static int y;

    static Point[] points;
    static int st;

    static Vector<Integer> pointsX;
    static Vector<Integer> pointsY;



    Bezier(){
        Bezier.pointsX = new Vector<>();
        Bezier.pointsY = new Vector<>();

        Bezier.points = new Point[4];
        Bezier.st = 0;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Bezier.x = e.getX();
                Bezier.y = e.getY();
                Bezier.pointsX.add(x);
                Bezier.pointsY.add(y);

            }
        });
    }

   /* public static void getPoints(int xp, int yp){

        if(Bezier.st == 3){
            Bezier.points[st++] = new Point(xp, yp, true, g);
            Bezier.st = 0;
            Curve cv = new Curve(Bezier.points, g);
            cv.drawCurve();
        }
        else{
            if(Bezier.st == 0){
                Bezier.points[st++] = new Point(xp, yp, true, g);
            }
            if(Bezier.st == 1 || Bezier.st == 2){
                Bezier.points[st++] = new Point(xp, yp, false, g);
            }
        }
    }
    */
    @Override
    public void paint(Graphics g){
        setSize(500,500);

        Point[] tocke = new Point[4];
        //g.drawLine(0,0,600,600);
        tocke[0] = new Point(200,100,true,g);
        tocke[1] = new Point(88,300,false,g);
        tocke[2] = new Point(300,100,false,g);
        tocke[3] = new Point(300,117,true,g);

        Curve cv = new Curve(tocke,g);
        cv.drawCurve();
        cv = null;
        Point[] tocke1 = new Point[4];

        tocke1[0] = new Point(400,70,true,g);
        tocke1[1] = new Point(18,450,false,g);
        tocke1[2] = new Point(40,90,false,g);
        tocke1[3] = new Point(350,17,true,g);

        cv = new Curve(tocke1,g);
        cv.drawCurve();
    }




    public static void main(String[] args) {

        int SIZE_X = 600;
        int SIZE_Y = 600;

        JFrame window = new JFrame();

        Bezier bz = new Bezier();
        window.add(bz);


        window.setSize(SIZE_X, SIZE_Y);
        window.setVisible(true);

    }


}
