/*
 * create class PhoneNumber
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.structural.facade.subInfo;

public class Education {
	
	private String university;
	private String major;
	
	public Education() {
	}

	public Education(String university, String major) {
		this.university = university;
		this.major = major;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	public void display() {
		System.out.println("University: " + this.university + ", Major: " + this.major);
	}

}
