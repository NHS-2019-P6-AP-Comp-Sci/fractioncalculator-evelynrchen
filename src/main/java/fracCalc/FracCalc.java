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
		String firstOperand = Input.substring(0, firstSpace);

		int firstUnderscore = firstOperand.indexOf("_");
    	int lastValue = Input.length();
    	int firstSlash = firstOperand.indexOf("/");
    
    	//first operand first whole number 
    	String firstWholeNumber = "0";
    	if (firstUnderscore != -1) {
    		firstWholeNumber = Input.substring(0, firstUnderscore);
    	} else {
    		firstWholeNumber = Input.substring(0, firstSpace);
    	}
    
    	//first numerator and denominator 
    	String firstNumerator = "0";
    	String firstDenominator = "0";
    	if (firstSlash != -1) {
    		firstNumerator = Input.substring(firstUnderscore + 1, firstSlash);
        	firstDenominator = Input.substring(firstSlash + 1, firstSpace);
    	} 
    	
    	String theOperator = Input.substring(firstSpace + 1);
    	
    	String secondOperand = Input.substring(firstSpace + 3, lastValue);
    	
    	int secondUnderscore = secondOperand.indexOf("_");
    	int secondSlash = secondOperand.indexOf("/");
    	int lastSecondValue = secondOperand.length();
    	
    	//first whole number 
    	String secondWholeNumber = "0";
    	if (secondUnderscore != -1) {
    		secondWholeNumber = secondOperand.substring(0, secondUnderscore);
    	} else if (secondSlash == -1) {
    		secondWholeNumber = secondOperand.substring(0, lastSecondValue);
    	}
    	
    	String secondNumerator = "0"; 
    	String secondDenominator = "0";
    	if (secondSlash != -1) {
    		secondNumerator = secondOperand.substring(secondUnderscore +1, secondSlash);
    		secondDenominator = secondOperand.substring(secondSlash + 1, lastSecondValue);
    	} else { 
    		secondDenominator = "1";
    	}
    	
    	String compiledValue = "whole:" + secondWholeNumber + " numerator:" + secondNumerator + " denominator:" + secondDenominator;
    	return compiledValue;
	}
}

// TODO: Fill in the space below with any helper methods that you think you will
// need
