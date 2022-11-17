package ba.unsa.etf.rpr;

import java.util.Scanner;

/**
 * App with main method for parsing input
 * @author Ernad Zuga
 * @version 1.0
 *
 */
public class App 
{   /**
    * Main method for input validation
    */
    public static void main( String[] args )
    {
         try{
            ValidInput.isValid(args[0]);
            double ev = ExpressionEvaluator.evaluate(args[0]);
            System.out.println(ev);
        }
        catch (RuntimeException e){
            System.out.println(e);
        }







    }
}
