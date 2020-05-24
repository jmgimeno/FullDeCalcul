import org.junit.Before;
import org.junit.Test;
import sheet.*;

import static org.junit.Assert.assertEquals;

public class ExpressionTest {
    Expression expr1,
     expr2,
     expr3,
     expr4,
     expr5,
     expr6,
     expr7,
     exprNoValue,
     compositeExpr;

    @Before
    public void setUp(){

        expr1 = new SomeValue(10);
        Cell cell = new Cell("a1", expr1);
        expr2 = new SomeValue(20);
        expr3 = new SomeValue(30);
        expr4 = new SomeValue(40);
        expr7 = new Reference(cell);
        exprNoValue = NoValue.INSTANCE;

    }

    @Test
    public void NoValueInReferenceExpression(){
        Cell cell = new Cell("a1", exprNoValue);
        expr7 = new Reference(cell);
        compositeExpr = new Plus(expr1, expr7);
        assertEquals(NoValue.INSTANCE, compositeExpr.evaluate());
    }


    @Test
    public void NoValueInCompostExpression(){
        compositeExpr = new Plus(expr1, exprNoValue);
        assertEquals(NoValue.INSTANCE, compositeExpr.evaluate());
    }

    @Test
    public void OneLevelPlusReferenceCellExpression() {
        compositeExpr = new Plus(expr2, expr7);
        assertEquals(new SomeValue(30), compositeExpr.evaluate());
    }

    @Test
    public void OneLevelProductReferenceCellExpression(){
        compositeExpr = new Mult(expr2, expr7);
        assertEquals(new SomeValue(200), compositeExpr.evaluate());
    }


    @Test
    public void TwoLevelTwoPlusAndOneProductTwoExpression(){
        expr5 = new Plus(expr1, expr2);
        expr6 = new Plus(expr3, expr4);
        compositeExpr = new Mult(expr5, expr6);
        assertEquals(new SomeValue(2100), compositeExpr.evaluate());
    }

    @Test
    public void TwoLevelPlusTwoExpression(){
        expr5 = new Plus(expr1, expr2);
        expr6 = new Plus(expr3, expr4);
        compositeExpr = new Plus(expr5, expr6);
        assertEquals(new SomeValue(100), compositeExpr.evaluate());
    }

    @Test
    public void TwoLevelProductTwoExpression(){
        expr5 = new Mult(expr1, expr2);
        expr6 = new Mult(expr3, expr4);
        compositeExpr = new Mult(expr5, expr6);
        assertEquals(new SomeValue(240000), compositeExpr.evaluate());
    }


    @Test
    public void OneLevelProductTwoExpression(){
        compositeExpr =  new Mult(expr1, expr2);
        assertEquals(new SomeValue(200), compositeExpr.evaluate());
    }

    @Test
    public void OneLevelPlusTwoExpressionPlus(){
        compositeExpr =  new Plus(expr1, expr2);
        assertEquals(new SomeValue(30), compositeExpr.evaluate());
    }
}
