package spreadsheet;

import exceptions.CellNotValidException;
import sheet.*;

public class SpreadSheet {
    private static int size = 5;
    private static final Sheet sheet = new Sheet(size);

    public static Expression plus(Expression exp1, Expression exp2){
        return new Plus(exp1, exp2);
    }

    public static Expression plus(Expression exp1, int value2){
        SomeValue val = new SomeValue(value2);
        return new Plus(exp1, val);
    }

    public static Expression plus(Expression exp1, String ref) throws CellNotValidException {
        Reference refC = new Reference(sheet.getCell(ref));
        return new Plus(exp1, refC);
    }

    public static Expression plus(int value1, Expression exp2){
        SomeValue val = new SomeValue(value1);
        return new Plus(val, exp2);
    }

    public static Expression plus(int value1, int value2){
        SomeValue val1 = new SomeValue(value1), val2 = new SomeValue(value2);
        return new Plus(val1, val2);
    }

    public static Expression plus(int value1, String ref2) throws CellNotValidException{
        SomeValue val = new SomeValue(value1);
        Reference ref = new Reference(sheet.getCell(ref2));
        return new Plus(val, ref);
    }

    public static Expression plus(String ref1, Expression exp2) throws CellNotValidException{
        Reference reference = new Reference(sheet.getCell(ref1));
        return new Plus(reference, exp2);
    }
    public static Expression plus(String ref1, int value2) throws CellNotValidException{
        Reference reference = new Reference(sheet.getCell(ref1));
        SomeValue value = new SomeValue(value2);
        return new Plus(reference, value);
    }

    public static Expression plus(String ref1, String ref2) throws CellNotValidException{
        Reference reference1 = new Reference(sheet.getCell(ref1)),
                reference2 = new Reference(sheet.getCell(ref2));
        return new Plus(reference1, reference2);
    }

    public static Expression mult(Expression exp1, Expression exp2){
        return new Mult(exp1, exp2);
    }

    public static Expression mult(Expression exp1, int value2){
        SomeValue val = new SomeValue(value2);
        return new Mult(exp1, val);
    }

    public static Expression mult(Expression exp1, String ref) throws CellNotValidException {
        Reference refC = new Reference(sheet.getCell(ref));
        return new Mult(exp1, refC);
    }

    public static Expression mult(int value1, Expression exp2){
        SomeValue val = new SomeValue(value1);
        return new Mult(val, exp2);
    }

    public static Expression mult(int value1, int value2){
        SomeValue val1 = new SomeValue(value1), val2 = new SomeValue(value2);
        return new Mult(val1, val2);
    }

    public static Expression mult(int value1, String ref2) throws CellNotValidException{
        SomeValue val = new SomeValue(value1);
        Reference ref = new Reference(sheet.getCell(ref2));
        return new Mult(val, ref);
    }

    public static Expression mult(String ref1, Expression exp2) throws CellNotValidException{
        Reference reference = new Reference(sheet.getCell(ref1));
        return new Mult(reference, exp2);
    }
    public static Expression mult(String ref1, int value2) throws CellNotValidException{
        Reference reference = new Reference(sheet.getCell(ref1));
        SomeValue value = new SomeValue(value2);
        return new Mult(reference, value);
    }

    public static Expression mult(String ref1, String ref2) throws CellNotValidException{
        Reference reference1 = new Reference(sheet.getCell(ref1)),
                reference2 = new Reference(sheet.getCell(ref2));
        return new Mult(reference1, reference2);
    }

    public static MaybeValue get(String name) throws CellNotValidException{
        return sheet.getValueInCell(name);
    }

    public static void put(String name, Expression exp) throws CellNotValidException{
        sheet.getCell(name).setExp(exp);
    }

    public static void put(String name, int value) throws CellNotValidException{
        sheet.getCell(name).setExp(new SomeValue(value));
    }

    public static void put(String name, String refName) throws CellNotValidException{
        sheet.getCell(name).setExp(new Reference(sheet.getCell(refName)));
    }

    public static void clear(){
        sheet.initSheet();
    }
}
