/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class BufferedOutputStreamDemo
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.javaio.bufferedoutputstream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamDemo {

	public static void main(String args[]) {

		FileOutputStream fos = null;
		BufferedOutputStream bos = null;

		try {
			fos = new FileOutputStream(new File(System.getProperty("user.dir") + "\\resources\\fileOutput.txt"));
			bos = new BufferedOutputStream(fos);

			String s = "Welcome to java.";
			byte b[] = s.getBytes();
			bos.write(b);
			System.out.println("success!");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
