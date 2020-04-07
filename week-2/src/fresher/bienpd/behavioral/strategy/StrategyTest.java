/*
 * Copyright (C) 2019 by GMO Runsystem Company
 *
 * Create
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.behavioral.strategy;

import fresher.bienpd.behavioral.strategy.impl.GoByBus;
import fresher.bienpd.behavioral.strategy.impl.GoByMotorbike;

public class StrategyTest {

	public static void main(String[] args) {
		Staff bienPD = new Staff(3538, "Pham Duy Bien");
		System.out.println("I am " + bienPD.getFullname());
		bienPD.setGoToWork(new GoByMotorbike());
		bienPD.goToWork();
		
		Staff quangNP = new Staff(1000, "Nguyen Phuoc Quang");
		System.out.println("I am " + quangNP.getFullname());
		quangNP.setGoToWork(new GoByBus());
		quangNP.goToWork();
	}

}
