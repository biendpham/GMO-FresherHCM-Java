/*
 * Copyright (C) 2019 by GMO Runsystem Company
 *
 * Create NullObjectTest
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.behavioral.nullobject;

public class NullObjectTest {

	public static void main(String[] args) {
		double salary1 = 11000000;
		double salary2 = 4000000;
		System.out.printf("Bao hiem xa hoi voi muc luong %.0f la %.0f\n", salary1, caculateSocialInsuranceBySalary(salary1));
		System.out.printf("Bao hiem xa hoi voi muc luong %.0f la %.0f\n", salary2, caculateSocialInsuranceBySalary(salary2));
	}
	
	public static double caculateSocialInsuranceBySalary(double salary) {
		SocialInsurance socialInsurance = SocialInsuranceFactory.classifyBySalary(salary);
		return socialInsurance.apply(salary);
	}
	
}
