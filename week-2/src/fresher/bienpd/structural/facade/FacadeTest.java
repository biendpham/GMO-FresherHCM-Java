/*
 * create class Facade Test
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.structural.facade;

import fresher.bienpd.structural.facade.subInfo.Address;
import fresher.bienpd.structural.facade.subInfo.Education;
import fresher.bienpd.structural.facade.subInfo.Name;

public class FacadeTest {

	public static void main(String[] args) {
		
		Person person = new Person(
				new Name("Pham", "Duy", "Bien"), 
				new Address("Ho Chi Minh", "Phan Huy Ich", "VietNam"), 
				new Education("University of Sience", "Nuclear Physic"));
		person.display();
	
	}
	
}
