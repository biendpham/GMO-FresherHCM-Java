/*
 * create class Motorbike Factory
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.creational.abstractFactory;

import fresher.bienpd.creational.abstractFactory.abstractFactory.IMotobikeAbstractFactory;
import fresher.bienpd.creational.abstractFactory.model.Motorbike;

public class MotorbikeFactory {

	public static Motorbike getMotorbike(IMotobikeAbstractFactory factory) {
		return factory.createMotorbike();
	}

}
