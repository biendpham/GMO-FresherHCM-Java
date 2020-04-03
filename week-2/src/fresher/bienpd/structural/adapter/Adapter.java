/*
 * create class Adapter
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.structural.adapter;

public class Adapter implements IPhoneNumber {

	NumberUtil util = new NumberUtil();

	@Override
	public boolean checkPhoneNumber(String input) {
		
		if (!util.isNumber(input)) {
			return false;
		}
		
		if (input.matches("[0][1-9][0-9]{8}")) {
			return true;
		}
		
		return false;
	}
}
