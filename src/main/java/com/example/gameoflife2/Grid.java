package com.example.gameoflife2;
import com.example.gameoflife2.GridCell.CellStatus;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Grid {
    private GridCell[][] cells;

    public Grid(GridCell.CellStatus[][] cellStates) {
        cells = new GridCell[cellStates.length][];
        for (int row = 0; row < cellStates.length; row++) {
            cells[row] = new GridCell[cellStates[row].length];
            for (int col = 0; col < cellStates[row].length; col++) {
                cells[row][col] = new GridCell(cellStates[row][col]);
            }
        }
    }

    public CellStatus[][] getStatus() {
      CellStatus[][] cellStates = new CellStatus[cells.length][];
        for (int row = 0; row < cells.length; row++) {
            cellStates[row] = new CellStatus[cells[row].length];
            for (int col = 0; col < cells[row].length; col++) {
                cellStates[row][col] = cells[row][col].getStatus();
            }
        }
        return cellStates;
    }

    public int countCellIsLive(CellStatus[][] state, int row, int col) {
        if (col >= 0 && col < state[row].length) {
            if (state[row][col] == CellStatus.ALIVE) {
                return 1;
            }
        }
        return 0;
    }

    public int getNumberOfAliveNeighborsInRow(CellStatus[][] state, int row, int col) {
        int numberOfAliveNeighbor = 0;
        if (row >= 0 && row < state.length) {
            numberOfAliveNeighbor += countCellIsLive(state, row, col - 1);
            numberOfAliveNeighbor += countCellIsLive(state, row, col);
            numberOfAliveNeighbor += countCellIsLive(state, row, col + 1);
        }
        return numberOfAliveNeighbor;
    }

    public int getNumberOfAliveNeighbors(CellStatus[][] state, int row, int col) {
        int numberOfAliveNeighbor = 0;
        numberOfAliveNeighbor += getNumberOfAliveNeighborsInRow(state, row - 1, col);
        numberOfAliveNeighbor += countCellIsLive(state, row, col - 1);
        numberOfAliveNeighbor += countCellIsLive(state, row, col + 1);
        numberOfAliveNeighbor += getNumberOfAliveNeighborsInRow(state, row + 1, col);
        return numberOfAliveNeighbor;
    }


    public void update() {
        CellStatus[][] cellStates = getStatus();
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                int numberOfAliveNeighbors = getNumberOfAliveNeighbors(cellStates, row, col);
                cells[row][col].update(numberOfAliveNeighbors);
            }
        }
    }


    public void displayGrid(Stage stage){
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20,20,20,20));
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {

                Rectangle rect = new Rectangle(100,100);
                 if(cells[row][col].getStatus()==CellStatus.ALIVE){
                     rect.setFill(Color.GREEN);
                 }else{
                     rect.setFill(Color.BLACK);
                 }
                gridPane.add(rect,row,col);
            }
        }

        Scene sc = new Scene(gridPane,500,500);
        stage.setScene(sc);
        stage.show();
    }

















}
