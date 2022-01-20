import com.example.gameoflife2.Grid;
import org.junit.Test;
import com.example.gameoflife2.GridCell.CellStatus;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class TestGrid {
    private static final CellStatus O = CellStatus.DEAD;
    private static final CellStatus X = CellStatus.ALIVE;

    @Test
    public void shouldCreateAnewGridWithData(){
        CellStatus[][] original = new CellStatus[][] {
                { X, O, X },
                { O, O, O },
                { O, X, X },
        };
        Grid uut = new Grid(original);

        CellStatus[][] actual = uut.getStatus();
        assertArrayEquals(original, actual);
    }
    @Test
    public void TestCheckIfCellIsLive(){
        CellStatus[][] original = new CellStatus[][] {
                { X, O, X },
                { O, O, O },
                { O, X, X },
        };
        Grid uut = new Grid(original);

        int status = uut.countCellIsLive(uut.getStatus(),0,0);
        assertEquals(status,1);
    }

    @Test
    public void testGetNumberOfAliveNeighborsInRowIfItIsAlive(){
        CellStatus[][] original = new CellStatus[][] {
                { X, O, X },
                { O, O, O },
                { O, X, X },
        };
        Grid uut = new Grid(original);

        int status = uut.getNumberOfAliveNeighborsInRow(uut.getStatus(),0,0);
        assertEquals(status,1);
    }

    @Test
    public void testGetNumberOfAliveNeighborsInRowIfItIsDeadAndHasDeadNeighbors(){
        CellStatus[][] original = new CellStatus[][] {
                { X, O, X },
                { O, O, O },
                { O, X, X },
        };
        Grid uut = new Grid(original);

        int status = uut.getNumberOfAliveNeighborsInRow(uut.getStatus(),1,1);
        assertEquals(status,0);
    }

    @Test
    @DisplayName("get number of a live neighbors to the center cell")
    public void testGetCountNeighbors(){
        CellStatus[][] original = new CellStatus[][] {
                { X, O, X },
                { O, O, O },
                { O, X, X },
        };
        Grid uut = new Grid(original);

        int status = uut.getNumberOfAliveNeighbors(uut.getStatus(),1,1);
        assertEquals(status,4);
    }
    @Test
    @DisplayName("get number of a live neighbors to the top left cell")
    public void testGetCountNeighborsTopLeftCell(){
        CellStatus[][] original = new CellStatus[][] {
                { X, O, X },
                { O, O, O },
                { O, X, X },
        };
        Grid uut = new Grid(original);

        int status = uut.getNumberOfAliveNeighbors(uut.getStatus(),0,0);
        assertEquals(status,0);
    }

}
