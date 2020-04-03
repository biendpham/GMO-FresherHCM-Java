/*
 * create Honda class
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.creational.abstractFactory.model;

public class Honda extends Motorbike{
	
	private String name;
	private String headquarter;

	public Honda(String name, String headquarter) {
		this.name = name;
		this.headquarter = headquarter;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHeadquarter(String headquarter) {
		this.headquarter = headquarter;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getHeadquarter() {
		return headquarter;
	}


}
