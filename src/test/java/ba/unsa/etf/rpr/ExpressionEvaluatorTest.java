package ba.unsa.etf.rpr;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for ExpressionEvaluator.
 * @author Ernad Zuga
 * @version 1.0
 */
public class ExpressionEvaluatorTest
{
    /**
     * Test if result of ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) is 101.0
     */
    @Test
    void test1(){
        String s = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        assertEquals(101.0, ExpressionEvaluator.evaluate(s));
   }

    /**
     * Test if sqrt is used correctly
     */
    @Test
    void test2(){
        String s = "( sqrt ( 9 ) + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        assertEquals(103.0, ExpressionEvaluator.evaluate(s));
    }
    /**
     *  Test if nums are divided correctly
     */
    @Test
    void test3(){
        String s = "( ( sqrt ( 9 ) / 3 ) + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        assertEquals(101.0, ExpressionEvaluator.evaluate(s));
    }
    /**
     * Test for input without closed bracket
     */
    @Test
    void test4(){
        assertThrows(RuntimeException.class, () -> {ValidInput.isValid("( 1 + 2");},"Invalid input");
   }
    /**
     * Test for using operators
     */
    @Test
    void test5(){
        assertThrows(RuntimeException.class, () -> {ValidInput.isValid("( 1 + 2 + )");}, "Invalid input");
    }
    /**
     * Test for sqrt of double-digit number
     */
    @Test
    void test6(){
        assertEquals(6.0, ExpressionEvaluator.evaluate("( 1 + sqrt ( 25 ) )"));
    }

    /**
     * Test for sqrt of three-digit number
     */
    @Test
    void test7(){
        assertEquals(20.0, ExpressionEvaluator.evaluate("( sqrt ( 169 ) + 7 )"));
    }

}
