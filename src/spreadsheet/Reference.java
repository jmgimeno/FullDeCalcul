package spreadsheet;

import java.util.Objects;
import java.util.Set;

public class Reference implements Expression {
    private final Cell cell;

    Reference(Cell ref){
        this.cell = ref;
    }

    public Cell getCell(){
        return this.cell;
    }

    /*@Override
    public spreadsheet.MaybeValue evaluate(ExpressionVisitor visitor) {
        return visitor.visit(this);
    }*/

    @Override
    public MaybeValue evaluate() {
        return cell.getExp().evaluate();
    }

    @Override
    public Set<Cell> references() {
        return null;
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
        return Objects.equals(this.cell, other.cell);
    }
}
