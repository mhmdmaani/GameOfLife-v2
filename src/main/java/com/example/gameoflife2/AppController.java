package com.example.gameoflife2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class AppController extends VBox {

    private static final GridCell.CellStatus O = GridCell.CellStatus.DEAD;
    private static final GridCell.CellStatus X = GridCell.CellStatus.ALIVE;

    @FXML
    GridPane gridPane;
    Grid grid;

    public  AppController(){

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

        grid = new Grid(original);
        gridPane = new GridPane();
        setGridPane(grid.getCells());
    }


    public void setGridPane(GridCell[][] cells ){
         gridPane.getChildren().clear();
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {

                Rectangle rect = new Rectangle(100,100);
                if(cells[row][col].getStatus() == GridCell.CellStatus.ALIVE){
                    rect.setFill(Color.BLACK);
                }else{
                    rect.setFill(Color.WHITE);
                }
                gridPane.add(rect,row,col);
            }
        }
    }

   @FXML
    public void onNextGenerationClick(){
     grid.update();
     setGridPane(grid.getCells());
    }

    public  void onRestGeneration(){
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

        grid = new Grid(original);
        setGridPane(grid.getCells());
    }
}
