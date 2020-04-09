/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class RenameFileExample
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.javaio.file;

import java.io.File;

public class RenameFileExample {
	public static void main(String[] args) {
		File srcFile = new File(System.getProperty("user.dir") + "\\resources\\file2\\file.txt");
		File destFile = new File(System.getProperty("user.dir") + "\\resources\\file2\\fileNameChanged.txt");

		boolean renamed = srcFile.renameTo(destFile);
		System.out.println("Renamed: " + renamed); // true
	}
}
