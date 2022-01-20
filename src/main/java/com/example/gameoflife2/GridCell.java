package com.example.gameoflife2;

public class GridCell {

    private CellStatus status;

    public GridCell(CellStatus state) {
        this.status = state;
    }

    public enum CellStatus {
        ALIVE, DEAD
    }

    public void update(int i) {
        if (status == CellStatus.ALIVE) {
            status = i > 1 && i < 4 ? CellStatus.ALIVE : CellStatus.DEAD;
        } else {
            status = i == 3 ? CellStatus.ALIVE : CellStatus.DEAD;
        }
    }

    public CellStatus getStatus() {
        return status;
    }
}
