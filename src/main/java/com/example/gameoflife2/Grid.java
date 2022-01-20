package com.example.gameoflife2;
import com.example.gameoflife2.GridCell.CellStatus;
import javafx.scene.control.Cell;

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

    public int checkCellIsLive(CellStatus[][] state, int row, int col) {
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
            numberOfAliveNeighbor += checkCellIsLive(state, row, col - 1);
            numberOfAliveNeighbor += checkCellIsLive(state, row, col);
            numberOfAliveNeighbor += checkCellIsLive(state, row, col + 1);
        }
        return numberOfAliveNeighbor;
    }














}
