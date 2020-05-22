import java.util.Set;

public class NoValue extends MaybeValue {
    public static final NoValue INSTANCE = new NoValue();

    /*@Override
    public MaybeValue evaluate(ExpressionVisitor visitor) {
        return INSTANCE;
    }*/

    @Override
    public MaybeValue evaluate() {
        return INSTANCE;
    }

    @Override
    public Set<Cell> references() {
        return null;
    }

    @Override
    public boolean hasValue() {
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof NoValue;
    }
}
