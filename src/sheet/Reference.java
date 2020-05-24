package sheet;

public class Reference implements Expression {
    private final Cell cell;

    public Reference(Cell ref){
        this.cell = ref;
    }

    public Cell getCell(){
        return this.cell;
    }

    @Override
    public MaybeValue evaluate() {
        return cell.getExp().evaluate();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reference other = (Reference) obj;
        return this.cell.equals(other.cell);
    }
}
