import exceptions.OperatorException;
/*
public class Evaluator implements ExpressionVisitor {

    @Override
    public MaybeValue visit(MaybeValue c) {
        return c;
    }

    @Override
    public MaybeValue visit(Reference ref) {
        return ref.getCell().getExp().evaluate(this);

    }

    @Override
    public MaybeValue visit(Operation op) {
        if(op.getExp1() instanceof SomeValue && op.getExp2() instanceof SomeValue){
            return new SomeValue(op.operate(((SomeValue) op.getExp1()).getValue(), ((SomeValue) op.getExp2()).getValue()));
        }

        if (op.getExp1() instanceof Reference ||
                op.getExp1() instanceof Operation) {
            return new SomeValue(op.operate(op.getExp1().evaluate(this), op.getExp2()))
        }

        if (op.getExp2() instanceof Reference ||
                op.getExp2() instanceof Operation) {
            return visit(op.getExp2().evaluate(this));
        }
        return NoValue.INSTANCE;
    }

    private MaybeValue evaluateOpExpr()

    private MaybeValue binaryOperation(Expression e1, Expression e2){
        return new SomeValue(op.operate(((SomeValue) op.getExp1()).getValue(), ((SomeValue) op.getExp2()).getValue()));
    }
}*/
