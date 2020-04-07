/*
 * Copyright (C) 2019 by GMO Runsystem Company
 *
 * Create class GoByBus
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.behavioral.strategy.impl;

import fresher.bienpd.behavioral.strategy.GoToWork;

public class GoByBus implements GoToWork {

	@Override
	public void go() {
		System.out.println("I go to work by bus");
	}

}
