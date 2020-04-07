/*
 * create NullObject.java
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.behavioral.nullobject.impl;

import fresher.bienpd.behavioral.nullobject.SocialInsurance;

public class NullObject implements SocialInsurance{

	@Override
	public double apply(double salary) {
		return 0;
	}

}
