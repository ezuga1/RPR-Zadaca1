package ba.unsa.etf.rpr;

import java.util.Stack;

/**
 * Class that contains method for checking valid arithmetic expression
 * @author Ernad Zuga
 * @version 1.0
 */
public class ValidInput {
    /**
     * Check arithmetic expression.
     */
    public static void isValid(String s){
        boolean valid = true;
        char tmp = s.charAt(0);
        char tmp2 = s.charAt(s.length() - 1);
        int openparen = 0;
        int closedparen = 0;
        if(tmp != '(' || tmp2 != ')')
            throw new RuntimeException("Invalid input"); //Return false if first element not "(" or last not ")".
        else {
            openparen = openparen +1;
            closedparen = closedparen +1;
        }
        for(int i=0; i<s.length(); i++){
            if(isOpened(s.charAt(i)))
                openparen = openparen + 1; //number of opened brackets.
        }
        for(int i=0; i<s.length(); i++){
            if(isClosed(s.charAt(i)))
                closedparen = closedparen +1; //num of closed brackets
        }
        if(openparen != closedparen) //return false if numbers are different
            throw new RuntimeException();
        for (int i = 0; i<s.length(); i++){
            //if given character is not operator, num or bracket return false.
            if(!isDigit(s.charAt(i)) && !isOperator(s.charAt(i)) && !isOpened(s.charAt(i)) && !isClosed(s.charAt(i)) && s.charAt(i) != ' ' && !isSqrt(s.charAt(i)))
                throw new RuntimeException("Invalid input");
        }
        int lastIndexOfSqrt = 0;
        if(s.contains("sqrt")){
            //checks using sqrt operator in expression
            lastIndexOfSqrt = s.lastIndexOf("sqrt") + 3;
         }
        if(lastIndexOfSqrt != 0){
            //checks correct using of sqrt operator
            int openParenSqrt = lastIndexOfSqrt + 2;
            int digitForSqrt = lastIndexOfSqrt + 4;
            int closeParenSqrt = lastIndexOfSqrt +6;
            if(isOpened(s.charAt(openParenSqrt)) && isDigit(s.charAt(digitForSqrt)) && isClosed(s.charAt(closeParenSqrt)))
                valid = true;
            else throw new RuntimeException("Invalid input");
        }
        for(int i =0; i<s.length(); i++){
            if(isOperator(s.charAt(i))){
                int digitBefore = i - 2;
                int digitAfter = i + 2;
                if(!isDigit(s.charAt(digitBefore)) && !isClosed(s.charAt(digitBefore)) && !isDigit(s.charAt(digitAfter)) && !isOpened(s.charAt(digitAfter)))
                    throw new RuntimeException("Invalid input");
                else {
                    throw new RuntimeException("Invalid input");
                }

            }

        }


    }

    /**
     * Method checks opened bracket.
     */
    public static boolean isOpened(char c) {
        if(c == '(') return true;
        return false;
    }

    /**
     * Method checks if the given character is an operator.
     */
    public static boolean isOperator(char c){
        if(c=='+' || c=='-' || c=='*' || c=='/') return true;
        return false;
    }
    /**
     * Method checks if the given character is a digit.
     */
    public static boolean isDigit(char c){
        if(c>='0' && c<='9') return true;
        return false;
    }
    /**
     * Methods checks if the given character is closed bracket
     */
    public static boolean isClosed(char c){
        if(c==')') return true;
        return false;
    }
    /**
     * Method checks if the given character is s, q, r or t
     */
    public static boolean isSqrt(char c){
        if(c!='s' && c!='q' && c!='r' && c!='t')
                return false;
        return true;
    }

}
