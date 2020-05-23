package spreadsheet;

import java.util.Set;

public interface Expression {
    MaybeValue evaluate();
    //spreadsheet.MaybeValue evaluate(ExpressionVisitor visitor);
    Set<Cell> references();
}
