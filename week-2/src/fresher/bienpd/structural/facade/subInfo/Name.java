/*
 * create class Name
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.structural.facade.subInfo;

public class Name {
	
	String firstName;
	String middleName;
	String lastName;

	public Name() {
	}

	public Name(String firstName, String middleName, String lastName) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void display() {
		System.out.println("Name: " + this.firstName + " " + this.middleName + " " + this.lastName);
	}

}
