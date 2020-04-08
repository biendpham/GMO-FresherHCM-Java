/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class PropertiesDemo3
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.javautil.properties;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesDemo3 {

	public static void main(String[] args) throws Exception {
		
		OutputStream output = null;
		try {
			// Properties File output at project root folder
			output = new FileOutputStream(System.getProperty("user.dir") + "\\resources\\database.config.properties");

			// create properties object
			Properties prop = new Properties();

			// set the properties value
			prop.setProperty("database", "localhost");
			prop.setProperty("dbuser", "admin");
			prop.setProperty("dbpassword", "admin");

			// save properties to a file
			prop.store(output, "Config Database connection");
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

}
