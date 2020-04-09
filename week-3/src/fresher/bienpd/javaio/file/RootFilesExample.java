/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class RootFilesExample
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.javaio.file;

import java.io.File;

public class RootFilesExample {
	public static void main(String[] args) {
		File[] roots = File.listRoots();
		for (File root : roots) {
			System.out.println(root.getAbsolutePath());
		}
	}
}
