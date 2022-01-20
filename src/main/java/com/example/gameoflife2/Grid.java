package com.example.gameoflife2;
import com.example.gameoflife2.GridCell.CellStatus;
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


    
}
