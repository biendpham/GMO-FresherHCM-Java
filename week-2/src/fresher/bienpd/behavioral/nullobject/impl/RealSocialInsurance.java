/*
 * create RealSocialInsurance.java
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.behavioral.nullobject.impl;

import fresher.bienpd.behavioral.nullobject.SocialInsurance;

public class RealSocialInsurance implements SocialInsurance{
	
	private double coefficient;
	
	public RealSocialInsurance(double coefficient) {
		this.coefficient = coefficient;
	}

	@Override
	public double apply(double salary) {
		return salary*coefficient;
	}

	public double getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}

}
