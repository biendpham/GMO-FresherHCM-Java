/*
 * Copyright (C) 2019 by GMO Runsystem Company
 *
 * Create class NumberExpression
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.behavioral.interpreter.impl;

import fresher.bienpd.behavioral.interpreter.Expression;

public class NumberExpression implements Expression {

	private int number;

	public NumberExpression(int number) {
		this.number = number;
	}

	public NumberExpression(String number) {
		this.number = Integer.parseInt(number);
	}

	@Override
	public int interpret() {
		return this.number;
	}

}
