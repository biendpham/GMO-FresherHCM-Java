/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class RenameFolderExample
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.javaio.file;

import java.io.File;

public class RenameFolderExample {
	public static void main(String[] args) {
		File srcFile = new File(System.getProperty("user.dir") + "\\resources\\file2\\file2.txt");
		File destFile = new File(System.getProperty("user.dir") + "\\resources\\file2\\file2.txt");

		if (!srcFile.exists()) {
			System.out.println("Src File doest not exists");
			return;
		}

		// Tạo thư mục cha của file đích
		destFile.getParentFile().mkdirs();

		boolean renamed = srcFile.renameTo(destFile);
		System.out.println("Renamed: " + renamed); // true
	}
}
