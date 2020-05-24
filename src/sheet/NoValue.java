package sheet;

public class NoValue extends MaybeValue {
    public static final NoValue INSTANCE = new NoValue();


    private NoValue(){}

    @Override
    public MaybeValue evaluate() {
        return INSTANCE;
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
