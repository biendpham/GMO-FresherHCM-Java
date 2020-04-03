/*
 * create class Person
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.structural.facade;

import fresher.bienpd.structural.facade.subInfo.Address;
import fresher.bienpd.structural.facade.subInfo.Education;
import fresher.bienpd.structural.facade.subInfo.Name;

public class Person {
	
	private Name name;
	private Address address;
	private Education education;

	public Person(Name name, Address address, Education education) {
		this.name = name;
		this.address = address;
		this.education = education;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Education getEducation() {
		return education;
	}

	public void setEducation(Education education) {
		this.education = education;
	}
	
	public void display() {
		System.out.println("-------------------------------------------------------");
		name.display();
		address.display();
		education.display();
		System.out.println("-------------------------------------------------------");
	}

}
