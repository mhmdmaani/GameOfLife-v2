import com.example.gameoflife2.Grid;
import org.junit.Test;
import com.example.gameoflife2.GridCell.CellStatus;

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

        int status = uut.checkCellIsLive(uut.getStatus(),0,0);
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

}
