/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class AbsoluteRelavativePathExample
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.javaio.file;

import java.io.File;

public class AbsoluteRelavativePathExample {

	public static void main(String[] args) {
		// Get Current Directory using getAbsolutePath()
		File file = new File("");
		String currentDirectory = file.getAbsolutePath();
		System.out.println("Current working directory : " + currentDirectory);

		// Get Current Directory using Property user.dir
		String workingDir = System.getProperty("user.dir");
		System.out.println("Current working directory : " + workingDir);
	}

}
