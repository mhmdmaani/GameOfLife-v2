import com.example.gameoflife2.Grid;
import org.junit.Test;
import com.example.gameoflife2.GridCell.CellStatus;

import static org.junit.Assert.assertArrayEquals;


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
}
