package spreadsheet;

import java.util.Set;

public class Plus extends Operation {

    Plus(Expression e1, Expression e2) {
        super(e1, e2);
    }

    @Override
    public int operate(int i1, int i2) {
        return i1 + i2;
    }

    /*@Override
    public spreadsheet.MaybeValue evaluate(ExpressionVisitor visitor) {
        return visitor.visit(this);
    }*/

    /*@Override
    public spreadsheet.MaybeValue evaluate() {
        return evaluateOp(getExp1(), getExp2());
    }

    private spreadsheet.MaybeValue evaluateOp(spreadsheet.Expression e1, spreadsheet.Expression e2){
        if(e1 instanceof spreadsheet.SomeValue && e2 instanceof spreadsheet.SomeValue){
            return new spreadsheet.SomeValue(operate(((spreadsheet.SomeValue) e1).getValue(), ((spreadsheet.SomeValue) e2).getValue()));
        }

        if (e1 instanceof spreadsheet.Operation ||
                e1 instanceof spreadsheet.Reference) {
            return evaluateOp(e1.evaluate(), e2);
        }

        if (e2 instanceof spreadsheet.Operation ||
                e2 instanceof spreadsheet.Reference) {
            return evaluateOp(e1, e2.evaluate());
        }
        return spreadsheet.NoValue.INSTANCE;
    }*/

    @Override
    public Set<Cell> references() {
        return null;
    }
}
