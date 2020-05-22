import java.util.Set;

public class Mult extends Operation {

    Mult(Expression e1, Expression e2) {
        super(e1, e2);
    }

    @Override
    public int operate(int i1, int i2) {
        return i1 * i2;
    }

    /*@Override
    public MaybeValue evaluate(ExpressionVisitor visitor) {
        return visitor.visit(this);
    }*/

    @Override
    public Set<Cell> references() {
        return null;
    }
}
