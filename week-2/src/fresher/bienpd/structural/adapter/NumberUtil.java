/*
 * create NumberUtil.java
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.structural.adapter;

public class NumberUtil {

	public boolean isNumber(String input) {
		String regex = "[0-9]+";
	    return input.matches(regex);
	}
	
}
