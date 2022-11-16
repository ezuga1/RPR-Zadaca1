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
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an expression you want to evaluate: ");
        //try catch block checks is input valid arithmetic operator

        String s = "";
        for (int i = 0; i<args.length; i++){
            if(args[i]==" ") continue;
            else
                s = s.concat(args[i]);
        }
        try{

             ValidInput.isValid(s);
            double ev = ExpressionEvaluator.evaluate(s); //Evaluated expression
                    System.out.println(ev);

        }
        catch (RuntimeException e){
            System.out.println(e);
        }






    }
}
