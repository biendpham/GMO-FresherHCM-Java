/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class BufferedInputStreamDemo1
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.javaio.bufferedinputstream;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedInputStreamDemo1 {

	public static void main(String args[]) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;

		try {
			fis = new FileInputStream(new File(System.getProperty("user.dir") + "\\resources\\file.txt"));
			bis = new BufferedInputStream(fis);
			int i;
			while ((i = bis.read()) != -1) {
				System.out.print((char) i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bis.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
