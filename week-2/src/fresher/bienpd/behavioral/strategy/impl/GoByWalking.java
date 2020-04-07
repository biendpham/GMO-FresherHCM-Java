/*
 * Copyright (C) 2019 by GMO Runsystem Company
 *
 * Create class GoByWalking 
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.behavioral.strategy.impl;

import fresher.bienpd.behavioral.strategy.GoToWork;

public class GoByWalking implements GoToWork {

	@Override
	public void go() {
		System.out.println("I go to work by walking");
	}

}
