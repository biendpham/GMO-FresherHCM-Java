/*
 * Copyright (C) 2019 by GMO Runsystem Company
 *
 * Create class GoByMotorbike
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.behavioral.strategy.impl;

import fresher.bienpd.behavioral.strategy.GoToWork;

public class GoByMotorbike implements GoToWork {

	@Override
	public void go() {
		System.out.println("I go to work by motorbike");
	}

}
