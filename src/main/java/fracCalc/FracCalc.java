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
		userInput.close();
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

	public static String produceAnswer(String Input) {
		// TODO: Implement this function to produce the solution to the input
		int firstSpace = Input.indexOf(" ");
		String firstOperand = Input.substring(0, firstSpace);

		int firstUnderscore = firstOperand.indexOf("_");
		int lastValue = Input.length();
		int firstSlash = firstOperand.indexOf("/");

		// Separate first operand's first whole number
		String firstWholeNumber = "0";
		if (firstUnderscore != -1 && firstSlash != -1) {
			firstWholeNumber = Input.substring(0, firstUnderscore);
		} else if (firstSlash == -1) {
			firstWholeNumber = Input.substring(0, firstSpace);
		} else if (firstUnderscore == -1 && firstSlash != -1) {
			firstWholeNumber = "0";
		}

		// Separate first numerator and denominator
		String firstNumerator = "0";
		String firstDenominator = "0";
		if (firstUnderscore != -1 && firstSlash != -1) {
			firstNumerator = Input.substring(firstUnderscore + 1, firstSlash);
			firstDenominator = Input.substring(firstSlash + 1, firstSpace);
		} else if (firstUnderscore == -1 && firstSlash != -1) {
			firstNumerator = Input.substring(0, firstSlash);
			firstDenominator = Input.substring(firstSlash + 1, firstSpace);
		} else if (firstSlash == -1) {
			firstDenominator = "1";
		}

		// Separate the operator
		String theOperator = Input.substring(firstSpace + 1, firstSpace + 2);

		String secondOperand = Input.substring(firstSpace + 3, lastValue);

		int secondUnderscore = secondOperand.indexOf("_");
		int secondSlash = secondOperand.indexOf("/");
		int lastSecondValue = secondOperand.length();

		// Separate second operand's whole number
		String secondWholeNumber = "0";
		if (secondUnderscore != -1 && secondSlash != -1) {
			secondWholeNumber = secondOperand.substring(0, secondUnderscore);
		} else if (secondSlash == -1) {
			secondWholeNumber = secondOperand.substring(0, lastSecondValue);
		} else if (secondUnderscore == -1 && secondSlash != -1) {
			secondWholeNumber = "0";
		}

		// Separate second numerator and denominator
		String secondNumerator = "0";
		String secondDenominator = "0";
		if (secondUnderscore != -1 && secondSlash != -1) {
			secondNumerator = secondOperand.substring(secondUnderscore + 1, secondSlash);
			secondDenominator = secondOperand.substring(secondSlash + 1, lastSecondValue);
		} else if (secondUnderscore == -1 && secondSlash != -1) {
			secondNumerator = secondOperand.substring(0, secondSlash);
			secondDenominator = secondOperand.substring(secondSlash + 1, lastSecondValue);
		} else if (secondSlash == -1) {
			secondDenominator = "1";
		}

		// Parse all strings to integers
		int firstIntWhole = Integer.parseInt(firstWholeNumber);
		int secondIntWhole = Integer.parseInt(secondWholeNumber);

		int firstIntDenominator = Integer.parseInt(firstDenominator);
		int secondIntDenominator = Integer.parseInt(secondDenominator);

		int firstIntNumerator = Integer.parseInt(firstNumerator);
		int secondIntNumerator = Integer.parseInt(secondNumerator);

		// Make all mixed numbers into improper fractions
		int firstMixNum = 0;
		int secondMixNum = 0;

		if (firstIntDenominator != 1 && firstIntWhole > 0) {
			firstMixNum = ((firstIntWhole * firstIntDenominator) + firstIntNumerator);
		}

		if (firstIntDenominator != 1 && firstIntWhole < 0) {
			firstMixNum = ((firstIntWhole * firstIntDenominator) - firstIntNumerator);
		}

		if (firstIntDenominator == 1) {
			firstMixNum = (firstIntWhole);
		}

		if (firstIntWhole == 0) {
			firstMixNum = (firstIntNumerator);
		}

		if (secondIntDenominator != 1 && secondIntWhole > 0) {
			secondMixNum = ((secondIntDenominator * secondIntWhole) + secondIntNumerator);
		}

		if (secondIntDenominator != 1 && secondIntWhole < 0) {
			secondMixNum = ((secondIntWhole * secondIntDenominator) - secondIntNumerator);
		}

		if (secondIntDenominator == 1) {
			secondMixNum = (secondIntWhole);
		}

		if (secondIntWhole == 0) {
			secondMixNum = (secondIntNumerator);
		}

		int totalDenominator = 0;
		int totalNumerator = 0;

		String compiledValue = "0";

		// Addition operator
		if (theOperator.equals("+")) {
			if (firstIntDenominator != 0 && secondIntDenominator != 0 && firstMixNum != 0 && secondMixNum != 0) {
				totalDenominator = firstIntDenominator * secondIntDenominator;
				totalNumerator = firstMixNum * secondIntDenominator + secondMixNum * firstIntDenominator;
			} else if (firstIntDenominator == 0 || firstMixNum == 0) {
				totalDenominator = secondIntDenominator;
				totalNumerator = secondMixNum;
			} else if (secondIntDenominator == 0 || secondMixNum == 0) {
				totalDenominator = firstIntDenominator;
				totalNumerator = firstMixNum;
			}
		}

		compiledValue = Integer.toString(secondMixNum);

		// Subtraction operator
		if (theOperator.equals("-")) {
			if (firstIntDenominator != 0 && secondIntDenominator != 0 && firstMixNum != 0 && secondMixNum != 0) {
				totalNumerator = firstMixNum * secondIntDenominator - secondMixNum * firstIntDenominator;
				totalDenominator = secondIntDenominator * firstIntDenominator;
			} else if (firstIntDenominator == 0 || firstMixNum == 0) {
				totalDenominator = secondIntDenominator;
				totalNumerator = (0 - secondMixNum);
			} else if (secondIntDenominator == 0 || secondMixNum == 0) {
				totalDenominator = firstIntDenominator;
				totalNumerator = firstMixNum;
			}
		}

		// Division operator
		if (theOperator.equals("/")) {
			totalNumerator = firstMixNum * secondIntDenominator;
			totalDenominator = firstIntDenominator * secondMixNum;
		}

		// Multiplication operator
		if (theOperator.equals("*")) {
			totalNumerator = firstMixNum * secondMixNum;
			totalDenominator = firstIntDenominator * secondIntDenominator;
		}

		// Simplification of denominators of 0 and 1
		if (totalDenominator == 1) {
			compiledValue = Integer.toString(totalNumerator);
		} else if (totalDenominator == 0) {
			compiledValue = "0";
		}

		// Separating whole number from mixed fraction
		int totalWhole = (totalNumerator / totalDenominator);
		totalNumerator = totalNumerator - totalWhole * totalDenominator;


		// Reducing fraction
		if (totalNumerator > totalDenominator) {
			for (int j = totalNumerator; j > 0; j--) {
				int numRemainder = totalNumerator % j;
				int numDenominator = totalDenominator % j;
				if ((numRemainder == 0) && (numDenominator == 0)) {
					totalNumerator = totalNumerator / j;
					totalDenominator = totalDenominator / j;
				}
			}
		} else {
			for (int j = totalDenominator; j > 0; j--) {
				int numRemainder = totalNumerator % j;
				int numDenominator = totalDenominator % j;
				if ((numRemainder == 0) && (numDenominator == 0)) {
					totalNumerator = totalNumerator / j;
					totalDenominator = totalDenominator / j;
				}
			}
		}
		
		if (totalNumerator%3 == 0 && totalDenominator%3 == 0) {
			totalNumerator = totalNumerator/3;
			totalDenominator = totalDenominator/3;
		}
		
		//Simplication of just whole numbers
		if (totalNumerator == 0 || totalDenominator == 0) {
			compiledValue = Integer.toString(totalWhole);
		}

		// Absolute value of each component
		int absDenom = Math.abs(totalDenominator);
		int absNum = Math.abs(totalNumerator);

		//Compiling final string with the proper notation
		if (totalWhole == 0) {
			if (totalNumerator < 0 && totalDenominator > 0) {
				compiledValue = Integer.toString(totalNumerator) + "/" + Integer.toString(absDenom);
			} else if (totalNumerator > 0 && totalDenominator < 0) {
				compiledValue = Integer.toString(0 - totalNumerator) + "/" + Integer.toString(absDenom);
			} else if (totalNumerator > 0 && totalDenominator > 0) {
				compiledValue = Integer.toString(totalNumerator) + "/" + Integer.toString(totalDenominator);
			} else if (totalNumerator < 0 && totalDenominator < 0) {
				compiledValue = Integer.toString(absNum) + "/" + Integer.toString(absDenom);
			}
		}

		if (totalWhole != 0 && totalNumerator != 0 && totalDenominator != 0) {
			if (totalWhole < 0) {
				compiledValue = Integer.toString(totalWhole) + "_" + Integer.toString(absNum) + "/"
						+ Integer.toString(absDenom);
			} else if (totalWhole > 0
					&& ((totalNumerator < 0 && totalDenominator > 0) || (totalNumerator > 0 && totalDenominator < 0))) {
				compiledValue = Integer.toString(0 - totalWhole) + "_" + Integer.toString(absNum) + "/"
						+ Integer.toString(absDenom);
			} else if (totalWhole > 0 && totalNumerator < 0 && totalDenominator < 0) {
				compiledValue = Integer.toString(totalWhole) + "_" + Integer.toString(absNum) + "/"
						+ Integer.toString(absDenom);
			} else {
				compiledValue = Integer.toString(totalWhole) + "_" + Integer.toString(absNum) + "/"
						+ Integer.toString(absDenom);
			}

		} 

		return compiledValue;

	}

}

// TODO: Fill in the space below with any helper methods that you think you will
// need
