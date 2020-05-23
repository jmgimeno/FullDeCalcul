package test;

import exceptions.CellNotValidException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import spreadsheet.SomeValue;
import spreadsheet.SpreadSheet.*;

import static spreadsheet.SpreadSheet.*;


public class SpreadSheetTest {

    @BeforeEach
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


    @AfterEach
    public void clearSheet(){
        clear();
    }
}
