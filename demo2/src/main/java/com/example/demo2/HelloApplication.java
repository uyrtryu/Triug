package com.example.demo2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.canvas.GraphicsContext;

import java.io.IOException;

public class HelloApplication extends Application {

    public static void triacle(GraphicsContext gc, int x1, int y1, int x2, int y2, int x3, int y3){
//        Line drawEllipse = new Line();
        Line.DDALine( x1, y1, x2, y2, gc);
        Line.DDALine( x2, y2, x3, y3, gc);
        Line.DDALine( x1, y1, x3, y3, gc);

    }
    @Override
    public void start(Stage stage) throws IOException {
        int width = 1000; // Ширина холста
        int height = 600; // Высота холста
        int a = 300; // Большая полуось
        int b = 150; // Малая полуось


        Canvas canvas = new Canvas(width, height);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        int x1,x2,x3,y1,y2,y3;

        x1 = 100;
        y1 = 100;

        x2 = 350;
        y2 = 400;

        x3 = 350;
        y3 = 200;


        triacle(gc,x1,y1,x2,y2,x3,y3);

//        drawEllipse.DDALine( 100, 50, 200, 300, gc);

        Group root = new Group(canvas);
        Scene scene = new Scene(root, width, height);
        InterpolationTriacle.interpol(gc, x1,y1,x2,y2,x3,y3, Color.RED, Color.BLUE, Color.GREEN);

        stage.setTitle("Rasterization + interpolation ellipse");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}