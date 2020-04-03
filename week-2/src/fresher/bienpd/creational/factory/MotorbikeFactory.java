/*
 * create MotorbikeFactory.java
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.creational.factory;

import fresher.bienpd.creational.factory.model.Honda;
import fresher.bienpd.creational.factory.model.Motorbike;
import fresher.bienpd.creational.factory.model.Yamaha;

public class MotorbikeFactory {

	public static Motorbike getMotorbike(String name, String headquater) {

		if ("Honda".equalsIgnoreCase(name)) {
			return new Honda(name, headquater);
		} else if ("Yamaha".equalsIgnoreCase(name)) {
			return new Yamaha(name, headquater);
		}

		return null;
	}

}
