/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.Scanner;

public class FracCalc {

	public static void main(String[] args) {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	
    	System.out.println("Please enter your expression."); 
    	Scanner userInput = new Scanner(System.in); 
    	String stringInput = userInput.nextLine();
    	String printOut = produceAnswer(stringInput);
    	System.out.println(printOut);
    }

	// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION. This function will be used to
	// test your code
	// This function takes a String 'input' and produces the result
	//
	// input is a fraction string that needs to be evaluated. For your program, this
	// will be the user input.
	// e.g. input ==> "1/2 + 3/4"
	//
	// The function should return the result of the fraction after it has been
	// calculated
	// e.g. return ==> "1_1/4"

	public static String produceAnswer(String Input){
        // TODO: Implement this function to produce the solution to the input
    	int firstSpace = Input.indexOf(" ");
    	int lastValue = Input.length();
    	String firstOperand = Input.substring(0, firstSpace);
    	String theOperator = Input.substring(firstSpace + 1);
    	String secondOperand = Input.substring(firstSpace + 3, lastValue);
    	return secondOperand;
    }
}

    // TODO: Fill in the space below with any helper methods that you think you will need
