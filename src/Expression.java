import javax.swing.event.ChangeListener;
import java.util.Set;

public interface Expression {
    MaybeValue evaluate();
    //MaybeValue evaluate(ExpressionVisitor visitor);
    Set<Cell> references();
}
