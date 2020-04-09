/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class FIleOutputStreamDemo
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.javaio.fileoutputstream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FIleOutputStreamDemo {

	public static void main(String args[]) {

		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream(new File(System.getProperty("user.dir") + "\\resources\\fileOutput.txt"));
			String s = "Welcome to java.";
			byte b[] = s.getBytes();// converting string into byte array
			fos.write(b);
			System.out.println("success!");
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
