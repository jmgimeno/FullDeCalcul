import exceptions.CellNotValidException;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import sheet.SomeValue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static spreadsheet.SpreadSheet.*;

public class SpreadSheetTest {
    @Before
    public void setUpSheet() throws CellNotValidException {
        put("a3", mult("a1", "a2"));
        put("b1", "b2");
        put("b2", 30);
    }

    @Test
    public void simple_case() throws CellNotValidException{
        assertEquals(new SomeValue(30), get("b2"));
    }

    @Test
    public void cell_has_no_value_if_depends_on_empty_cells() throws CellNotValidException {
        assertFalse(get("a3").hasValue());
    }

    @Test
    public void cell_change_value() throws CellNotValidException{
        put("b2", 100);
        assertEquals(new SomeValue(100), get("b1"));
    }


    @Test
    public void recalculation_works() throws CellNotValidException {
        put("a1", 42);
        put("a2", 20);
        assertEquals(new SomeValue(840), get("a3"));
    }


    @After
    public void clearSheet(){
        clear();
    }
}
