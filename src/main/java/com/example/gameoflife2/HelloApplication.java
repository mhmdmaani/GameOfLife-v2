package com.example.gameoflife2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        GridPane gridPane = new GridPane();

        gridPane.setPadding(new Insets(20,20,20,20));
        Circle cilcle = new Circle(20);
        cilcle.setFill(Color.RED);
        gridPane.add(cilcle,1,1 );

        Scene sc = new Scene(gridPane,500,500);
         stage.setScene(sc);
         stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}