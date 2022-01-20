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
import java.util.Timer;
import java.util.TimerTask;

public class App extends Application {
    private static final GridCell.CellStatus O = GridCell.CellStatus.DEAD;
    private static final GridCell.CellStatus X = GridCell.CellStatus.ALIVE;


    @Override
    public void start(Stage stage) throws IOException {
        GridCell.CellStatus[][] original = new GridCell.CellStatus[][] {
                { X, O, X },
                { O, O, O },
                { O, X, X },
                { X, O, X },
                { O, O, O },
                { O, X, X },
                { X, O, X },
                { O, O, O },
                { O, X, X },
                { X, O, X },
                { O, O, O },
                { O, X, X },
                { X, O, X },
                { O, O, O },
                { O, X, X },

        };
        Grid uut = new Grid(original);

        uut.displayGrid(stage);

    }

    public static void main(String[] args) {
        launch();
    }



}