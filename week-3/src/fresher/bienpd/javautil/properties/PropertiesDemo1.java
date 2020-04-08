/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class PropertiesDemo1
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.javautil.properties;

import java.io.FileReader;
import java.util.Properties;

public class PropertiesDemo1 {

	public static void main(String[] args) throws Exception {
        // create reader object
        FileReader reader = new FileReader(System.getProperty("user.dir") + "\\resources\\config.properties");
 
        // crate properties object
        Properties properties = new Properties();
        properties.load(reader);
 
        // show file info
        System.out.println("site name: " + properties.getProperty("siteName"));
        System.out.println("site url: " + properties.getProperty("siteUrl"));
    }
	
}
