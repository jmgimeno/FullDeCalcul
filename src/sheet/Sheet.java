package sheet;

import enums.Letters;
import exceptions.CellNotValidException;

import java.util.HashMap;
import java.util.List;

public class Sheet {
    private static HashMap<String, Cell> sheet;
    private final int size;
    private static final List<String> cols = Letters.getValues();

    public Sheet(int size){
        this.size = size;
        this.initSheet();
    }

    public MaybeValue getValueInCell(String name) throws CellNotValidException {
        if(sheet.containsKey(name))
            return sheet.get(name).getVal();
        else
            throw new CellNotValidException();
    }

    public Expression getExpInCell(String name) throws CellNotValidException{
        if(sheet.containsKey(name))
            return sheet.get(name).getExp();
        else
            throw new CellNotValidException();
    }

    public HashMap<String, Cell> getSheet(){
        return sheet;
    }

    public Cell getCell(String name) throws CellNotValidException{
        if(sheet.containsKey(name))
            return sheet.get(name);
        else
            throw new CellNotValidException();
    }

    public final void initSheet(){
        sheet = new HashMap<>();
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                addNewCell(x,y);
            }
        }
    }

    private void addNewCell(int x, int y){
        String key = cols.get(x) + y;
        Cell cell = new Cell(key, NoValue.INSTANCE);
        sheet.put(key, cell);
    }
}
