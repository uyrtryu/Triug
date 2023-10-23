package com.example.demo2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import static com.example.demo2.Line.plotEllipsePoints;

public class InterpolationTriacle {


    public static void interpol(GraphicsContext gc, int x1, int y1, int x2, int y2, int x3, int y3, Color col1,Color col2,Color col3){

        if(y1 == y2 && y2 == y3){return;}

        int oldx1 = x1;
        int oldy1 = y1;

        x2 = x2 - x1;
        y2 = y2 - y1;
        x3 = x3 - x1;
        y3 = y3 - y1;
        x1 = 0;
        y1 = 0;

        double deltaCol1 = col2.getBlue() - col1.getRed();
        double deltaCol2 = col3.getGreen() - col1.getRed();

        if(y3 == 0){

        }

        int minx = Math.min(x1, Math.min(x2,x3));
        int miny = Math.min(y1, Math.min(y2,y3));
        int maxx = Math.max(x1, Math.max(x2,x3));
        int maxy = Math.max(y1, Math.max(y2,y3));

        for (int y = miny; y < maxy; y++){
//            System.out.println("y");

            for(int x = minx; x < maxx; x++){
//                System.out.println("x");

                float w1 = (float)(y * x3 - x * y3)/(y2 * x3 - x2 * y3);

                if (w1 >= 0 && w1 <= 1){

                    float w2 =  (y - w1 * y2)/y3;

                    if (w2 >= 0 && (w1 + w2) <= 1 ){

                        double result = col1.getRed() + (w1 * deltaCol1) + (deltaCol2 * w2);
                        Color c = Color.gray(result);
                        System.out.println(col1.getRed() + " " + col1.getBlue() + " " + col1.getGreen());
//                        c = Color.RED;




                        plotEllipsePoints( x + oldx1,  y + oldy1,gc, c);

                    }
                }
            }

        }
    }
}
