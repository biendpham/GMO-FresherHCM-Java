/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class MakeDirExample
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.javaio.file;

import java.io.File;

public class MakeDirExample {

	public static void main(String[] args) {
		File dir = new File(System.getProperty("user.dir") + "\\resources\\file1\\folder");
		System.out.println("Pathname: " + dir.getAbsolutePath());
		System.out.println("Path exists:  " + dir.exists()); // false
		System.out.println("Parent Path exists: " + dir.getParentFile().exists()); // false

		// Với mkdir(), thư mục chỉ được tạo ra nếu thư mục cha tồn tại.
		boolean created = dir.mkdir();
		System.out.println("Directory created: " + created); // false

		System.out.println();

		File dir2 = new File(System.getProperty("user.dir") + "\\resources\\file2\\folder");
		System.out.println("Pathname: " + dir2.getAbsolutePath());
		System.out.println("Path exists:  " + dir2.exists()); // false
		System.out.println("Parent Path exists: " + dir2.getParentFile().exists()); // false

		// Với mkdirs(), thư mục được tạo ra bao gồm cả các thư mục cha nếu nó không tồn
		// tại.
		created = dir2.mkdirs();
		System.out.println("Directory created: " + created); // true
	}
}
