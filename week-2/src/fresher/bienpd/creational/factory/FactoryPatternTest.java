/*
 * create Abstract Factory Pattern Test class
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.creational.factory;

import fresher.bienpd.creational.factory.model.Motorbike;

public class FactoryPatternTest {

	public static void main(String[] args) {
		
		Motorbike honda = MotorbikeFactory.getMotorbike("Honda", "Tokyo, Nhật Bản");
		Motorbike yamaha = MotorbikeFactory.getMotorbike("Yamaha", "Shizuoka, Nhật Bản");
		System.out.println(honda.toString());
		System.out.println(yamaha.toString());
		
	}

}
