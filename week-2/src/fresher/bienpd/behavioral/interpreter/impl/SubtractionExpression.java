/*
 * Copyright (C) 2019 by GMO Runsystem Company
 *
 * Create class SubtractionExpression
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.behavioral.interpreter.impl;

import fresher.bienpd.behavioral.interpreter.Expression;

public class SubtractionExpression implements Expression{
	
	private Expression firstNumber;
	private Expression secondNumber;

	public SubtractionExpression(Expression firstNumber, Expression secondNumber) {
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}

	@Override
	public int interpret() {
		return this.firstNumber.interpret() + this.secondNumber.interpret();
	}

}
