/*
 * create class Yamaha Factory
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.creational.abstractFactory.abstractFactory.impl;

import fresher.bienpd.creational.abstractFactory.abstractFactory.IMotobikeAbstractFactory;
import fresher.bienpd.creational.abstractFactory.model.Motorbike;
import fresher.bienpd.creational.abstractFactory.model.Yamaha;

public class YamahaFactory implements IMotobikeAbstractFactory{

	private String name;
	private String headquarter;
	
	public YamahaFactory(String name, String headquarter) {
		super();
		this.name = name;
		this.headquarter = headquarter;
	}

	@Override
	public Motorbike createMotorbike() {
		return new Yamaha(name, headquarter);
	}
	
}
