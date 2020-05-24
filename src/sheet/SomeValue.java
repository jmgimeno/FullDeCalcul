package sheet;

public class SomeValue extends MaybeValue {
    private int value;

    public SomeValue(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    @Override
    public MaybeValue evaluate() {
        return this;
    }

    @Override
    public boolean hasValue() {
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SomeValue other = (SomeValue) obj;
        return this.value == other.value;
    }
}
