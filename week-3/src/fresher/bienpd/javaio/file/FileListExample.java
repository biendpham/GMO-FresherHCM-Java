/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class FileListExample
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.javaio.file;

import java.io.File;

public class FileListExample {
	public static void main(String[] args) {
		
		File dir = new File(System.getProperty("user.dir") + "\\resources");

		System.out.println("File[] listFiles(): ");
		String[] paths = dir.list();
		for (String path : paths) {
			System.out.println(path);
		}
	}
}
