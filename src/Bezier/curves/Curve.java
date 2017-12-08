package Bezier.curves;


import java.awt.*;
import java.awt.geom.Line2D;

public class Curve {

    private Point[] points;
    private double[][] transformMatrix;
    private double[][] computedResult;
    public Graphics g;

    private int accuracy;

    Curve(Point[] points, Graphics g){
        this.points = points;
        this.transformMatrix = new double[4][4];
        this.g = g;
        this.g.setColor(Color.BLACK);
        this.init();
        this.accuracy = 1000;
    }


    public void drawCurve(){

        for (int i = 0; i < this.accuracy; i++){
            double t = i * ((double)1 / this.accuracy);
            double t2 = ++i * ((double)1 / this.accuracy);
           // System.out.println((double)1 / this.accuracy);
            //System.out.println("T1 " + t);
            //System.out.println("T2 " + t2);
            double[][] matrix1 = { {1}, {t}, {Math.pow(t,2)}, {Math.pow(t,3)}};
            double[][] matrix2 = { {1}, {t2}, {Math.pow(t2,2)}, {Math.pow(t2,3)}};

            double[][] pom = this.getPoints();
            double[][] res1 = this.multyply(pom,matrix1);
            double[][] res2 = this.multyply(pom,matrix2);

            Graphics2D g2 = (Graphics2D)g;
            g2.draw(new Line2D.Double(res1[0][0],res1[1][0], res2[0][0],res2[1][0]));
            //this.g.drawLine((int)res1[0][0],(int)res1[1][0], (int)res2[0][0],(int)res2[1][0]);
        }
    }


    private void compute(){
        this.computedResult = multyply(this.getPoints(), this.transformMatrix);
    }

    private double[][] getPoints(){
        double[][] pom = new double[2][4];

        pom[0][0] = this.points[0].getX();
        pom[0][1] = this.points[1].getX();
        pom[0][2] = this.points[2].getX();
        pom[0][3] = this.points[3].getX();

        pom[1][0] = this.points[0].getY();
        pom[1][1] = this.points[1].getY();
        pom[1][2] = this.points[2].getY();
        pom[1][3] = this.points[3].getY();

        double[][] res = this.multyply(pom,this.transformMatrix);

        return res;
    }

    private void init(){
        this.transformMatrix[0][0] = 1;
        this.transformMatrix[0][1] = -3;
        this.transformMatrix[0][2] = 3;
        this.transformMatrix[0][3] = -1;

        this.transformMatrix[1][0] = 0;
        this.transformMatrix[1][1] = 3;
        this.transformMatrix[1][2] = -6;
        this.transformMatrix[1][3] = 3;

        this.transformMatrix[2][0] = 0;
        this.transformMatrix[2][1] = 0;
        this.transformMatrix[2][2] = 3;
        this.transformMatrix[2][3] = -3;

        this.transformMatrix[3][0] = 0;
        this.transformMatrix[3][1] = 0;
        this.transformMatrix[3][2] = 0;
        this.transformMatrix[3][3] = 1;
    }

    private double[][] multyply(double[][] a, double[][] b){
        int m1 = a.length;
        int n1 = a[0].length;
        int m2 = b.length;
        int n2 = b[0].length;
        if (n1 != m2) throw new RuntimeException("Illegal matrix dimensions.");
        double[][] c = new double[m1][n2];
        for (int i = 0; i < m1; i++)
            for (int j = 0; j < n2; j++)
                for (int k = 0; k < n1; k++)
                    c[i][j] += a[i][k] * b[k][j];
        return c;
    }

    public void setAccuracy(int a){
        this.accuracy = a;
    }

    public int getAccuracy(){
        return this.accuracy;
    }

}
