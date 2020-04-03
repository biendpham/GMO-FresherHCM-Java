/*
 * create HondaFactory.java
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.creational.abstractFactory.abstractFactory.impl;

import fresher.bienpd.creational.abstractFactory.abstractFactory.IMotobikeAbstractFactory;
import fresher.bienpd.creational.abstractFactory.model.Honda;
import fresher.bienpd.creational.abstractFactory.model.Motorbike;

public class HondaFactory implements IMotobikeAbstractFactory{

	private String name;
	private String headquarter;
	
	public HondaFactory(String name, String headquarter) {
		super();
		this.name = name;
		this.headquarter = headquarter;
	}

	@Override
	public Motorbike createMotorbike() {
		return new Honda(name, headquarter);
	}

}
