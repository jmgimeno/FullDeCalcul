import java.util.Observable;
import java.util.Observer;

public class Cell extends Observable implements Observer {
    private final String ref;
    private MaybeValue val;
    private Expression exp;


    public Cell(String ref, Expression exp){
        this.ref = ref;
        this.exp = exp;
        this.val = exp.evaluate();
    }

    /*public MaybeValue evaluate(){
        return this.val;
    }*/

    public String getRef(){
        return this.ref;
    }

    public MaybeValue getVal(){
        return this.val;
    }

    public Expression getExp(){
        return this.exp;
    }

    void setExp(Expression exp){
        this.exp = exp;
        addObserversCell(exp);
        setChanged();
        notifyObservers();
        val = exp.evaluate();
    }

    @Override
    public void update(Observable o, Object arg) {
        val = exp.evaluate();
    }

    private void addObserversCell(Expression exp) {
        addObserversCellRec(this, exp);
    }

    private void addObserversCellRec(Cell cell, Expression exp){

        if(exp instanceof Operation){
            Operation expC = (Operation) exp;
            addObserversCellRec(cell, expC.getExp1());
            addObserversCellRec(cell, expC.getExp2());
        }
        if (exp instanceof Reference) {
            Reference expR = (Reference) exp;
            addObserversCellRec(expR.getCell(), expR.getCell().getExp());
        }
        if (exp instanceof MaybeValue) {
            if (!cell.equals(this)) {
                cell.addObserver(this);
            }

        }
    }
}
