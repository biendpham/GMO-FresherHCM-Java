/*
 * create class Address
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.structural.facade.subInfo;

public class Address {
	
	String city;
	String street;
	String country;

	public Address() {
	}

	public Address(String city, String street, String country) {
		this.city = city;
		this.street = street;
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void display() {
		System.out.println("Address: " + this.street + " - " + this.city + " - " + this.country);
	}

}
