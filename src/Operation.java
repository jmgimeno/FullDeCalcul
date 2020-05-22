import java.util.Set;

public abstract class Operation implements Expression{
    private Expression e1, e2;

    Operation(Expression e1, Expression e2){
        this.e1 = e1;
        this.e2 = e2;
    }

    public Expression getExp1(){
        return this.e1;
    }

    public Expression getExp2(){
        return this.e2;
    }

    @Override
    public MaybeValue evaluate() {
        if (e1 instanceof NoValue) return NoValue.INSTANCE;
        if (e2 instanceof NoValue) return NoValue.INSTANCE;
        return evaluateOp(e1, e2);
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
    }

    public abstract int operate(int i1, int i2);
}
