package fresher.bienpd;

public class Fresher extends Staff{

	boolean trainingCompleted;
	
	@Override
	void hello() {
		System.out.println("Xin chào, tôi tên là: " + firstName + " " + lastName
				+ "\nTôi là Fresher mới của công ty");
	}
	
	public static void main(String[] args) {
		Fresher bienpd = new Fresher();
		bienpd.firstName = "Phạm";
		bienpd.lastName = "Duy Biên";
		bienpd.trainingCompleted = false;
		bienpd.hello();
	}
	
}
