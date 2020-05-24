import exceptions.CellNotValidException;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import sheet.NoValue;
import sheet.SomeValue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static spreadsheet.SpreadSheet.*;

public class ComplexSpreadSheetTest {
    @Before
    public void setUp() throws CellNotValidException {
        put("c1", mult("a1", "b1"));
        put("c2", mult("a2", "b2"));
        put("c3", plus("c1", "c2"));

        put("a1", 10); put("b1", 20);
        put("a2", 30); put("b2", 40);
    }

    @Test
    public void chained_expressions() throws CellNotValidException{
        assertEquals(new SomeValue(1400), get("c3"));
        assertEquals(new SomeValue(1200), get("c2"));
    }

    @Test
    public void chained_value_to_chained_expression() throws CellNotValidException{
        put("d1", plus("a1", "b1"));
        put("d2", mult("d1", "b2"));
        assertEquals(new SomeValue(1200), get("d2"));
        put("a1", 50);
        assertEquals(new SomeValue(2800), get("d2"));

    }

    @Test
    public void chained_propagations() throws CellNotValidException{
        put("a1", "b1");
        assertEquals(new SomeValue(1600), get("c3"));
    }

    @Test
    public void chained_NoValue_propagations() throws CellNotValidException {
        put("d3", plus("c1", "b2"));
        put("d4", mult("d3", "b1"));
        put("a1", NoValue.INSTANCE);
        assertFalse(get("c1").hasValue()); assertFalse(get("d3").hasValue());
                assertFalse(get("d4").hasValue());
    }


    @After
    public void tearDown(){
        clear();
    }
}
