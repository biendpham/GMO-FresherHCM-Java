/*
 * Copyright (C) 2019 by GMO Runsystem Company
 *
 * Create SocialInsuranceFactory
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */

package fresher.bienpd.behavioral.nullobject;

import fresher.bienpd.behavioral.nullobject.impl.NullObject;
import fresher.bienpd.behavioral.nullobject.impl.RealSocialInsurance;

public class SocialInsuranceFactory {

	public static SocialInsurance classifyBySalary(double salary) {
		if (salary >= 4420000) {
			return new RealSocialInsurance(0.08);
		} else {
			return new NullObject();
		}
	}
	
}
