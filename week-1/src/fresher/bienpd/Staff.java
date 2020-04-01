package fresher.bienpd;

public class Staff implements People{

	String firstName;
	String lastName;
	
	void hello() {
		System.out.println("Xin chào, tôi tên là: " + firstName + " " + lastName);
	}

	@Override
	public void work() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void study() {
		// TODO Auto-generated method stub
		
	}

}
