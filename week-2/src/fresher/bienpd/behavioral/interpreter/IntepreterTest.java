/*
 * Copyright (C) 2019 by GMO Runsystem Company
 *
 * Create class IntepreterTest
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.behavioral.interpreter;

import fresher.bienpd.behavioral.interpreter.impl.AdditionExpression;
import fresher.bienpd.behavioral.interpreter.impl.NumberExpression;
import fresher.bienpd.behavioral.interpreter.impl.SubtractionExpression;

public class IntepreterTest {
	
	public static void main(String args[]) {
		
		System.out.println("20 + 8 = " + getExpression("20 + 8").interpret());
        System.out.println("10 - 4 = " + getExpression("10 - 4").interpret());
		
	}

	public static Expression getExpression(String context) {
		
		String[] tokens = context.split(" ");
		NumberExpression firstNumber = new NumberExpression(tokens[0]);
		NumberExpression secondNumber = new NumberExpression(tokens[2]);
		
		if (tokens[1].contains("+")) {
			return new AdditionExpression(firstNumber, secondNumber);
		} else if (tokens[1].contains("-")) {
			return new SubtractionExpression(firstNumber, secondNumber);
		}
		return null;
		
	}
}
