package ba.unsa.etf.rpr;

import java.util.Stack;

/**
 * Class that contains method for evaluating an expression
 * @author Ernad Zuga
 * @version 1.0
 */

public class ExpressionEvaluator {
    /**
     * Method for evaluation of expression based on Dijsktra's Two-Stack Algorithm for Expression
     */
    public static double evaluate(String s) {
        String[] str = s.split("\\s+"); //Parsing String s
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
        for (String c : str) {
            //Read token, push if operator.
            if (c.equals("(")) ;
            else if (c.equals("+")) ops.push(c);
            else if (c.equals("-")) ops.push(c);
            else if (c.equals("*")) ops.push(c);
            else if (c.equals("/")) ops.push(c);
            else if (c.equals("sqrt")) ops.push(c);
            else if (c.equals(")")) {
                //Pop, evaluate and push result if token is ")".
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+")) v = vals.pop() + v;
                else if (op.equals("-")) v = vals.pop() - v;
                else if (op.equals("*")) v = vals.pop() * v;
                else if (op.equals("/")) v = vals.pop() / v;
                else if (op.equals("sqrt")) v = Math.sqrt(v);
                vals.push(v);
            }
            //Token not operator or paren: push double value.
            else vals.push(Double.parseDouble(c));
        }
        return vals.pop();
    }
}
