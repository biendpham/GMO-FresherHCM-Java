/*
 * create abstract class Motorbike
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.creational.factory.model;

public abstract class Motorbike {
	
	public abstract String getName();
	public abstract String getHeadquarter();

	@Override
	public String toString() {
		return "Hãng xe máy " + getName() + " có trụ sở chính tại " + getHeadquarter();
	}

}
