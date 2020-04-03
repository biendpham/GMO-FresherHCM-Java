/*
 * create class Adapter Test
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.structural.adapter;

public class AdapterTest {

	public static void main(String[] args) {
		
		IPhoneNumber phoneNumber = new Adapter();
		
		String input1 = "sdflkqweqweq";
		String input2 = "0005151000";
		String input3 = "0123456789";
		
		System.out.println(input1 + " is phone number: " + phoneNumber.checkPhoneNumber(input1));
		System.out.println(input2 + " is phone number: " + phoneNumber.checkPhoneNumber(input2));
		System.out.println(input3 + " is phone number: " + phoneNumber.checkPhoneNumber(input3));
		
	}
}
