/*
 * Copyright (C) 2019 by GMO Runsystem Company
 *
 * Create class AdditionExpression
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.behavioral.interpreter.impl;

import fresher.bienpd.behavioral.interpreter.Expression;

public class AdditionExpression implements Expression {
	
	private Expression firstNumber;
	private Expression secondNumber;

	public AdditionExpression(Expression firstNumber, Expression secondNumber) {
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}

	@Override
	public int interpret() {
		return this.firstNumber.interpret() + this.secondNumber.interpret();
	}
}
