/*
 * create FactoryPatternTest class
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.creational.abstractFactory;

import fresher.bienpd.creational.abstractFactory.abstractFactory.impl.HondaFactory;
import fresher.bienpd.creational.abstractFactory.abstractFactory.impl.YamahaFactory;
import fresher.bienpd.creational.abstractFactory.model.Motorbike;

public class AbstractFactoryPatternTest {

	public static void main(String[] args) {
		
		Motorbike honda = MotorbikeFactory.getMotorbike(new HondaFactory("Honda", "Tokyo, Nhật Bản"));
		Motorbike yamaha = MotorbikeFactory.getMotorbike(new YamahaFactory("Yamaha", "Shizuoka, Nhật Bản"));
		
		System.out.println(honda.toString());
		System.out.println(yamaha.toString());
		
	}

}
