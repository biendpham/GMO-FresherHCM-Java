/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FIleNotFoundExceptionDemo {

	public static void main(String[] args) {

		// Tạo một đối tượng File đại diện cho một đường dẫn không tồn tại
		File file = new File(System.getProperty("user.dir") + "\\resources\\fileNotExist.txt");
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			int ch;
			while ((ch = fis.read()) != -1) {
				System.out.print((char) ch);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
