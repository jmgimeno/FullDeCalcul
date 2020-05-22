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
    public MaybeValue evaluate(ExpressionVisitor visitor) {
        return visitor.visit(this);
    }*/

    /*@Override
    public MaybeValue evaluate() {
        return evaluateOp(getExp1(), getExp2());
    }

    private MaybeValue evaluateOp(Expression e1, Expression e2){
        if(e1 instanceof SomeValue && e2 instanceof SomeValue){
            return new SomeValue(operate(((SomeValue) e1).getValue(), ((SomeValue) e2).getValue()));
        }

        if (e1 instanceof Operation ||
                e1 instanceof Reference) {
            return evaluateOp(e1.evaluate(), e2);
        }

        if (e2 instanceof Operation ||
                e2 instanceof Reference) {
            return evaluateOp(e1, e2.evaluate());
        }
        return NoValue.INSTANCE;
    }*/

    @Override
    public Set<Cell> references() {
        return null;
    }
}
