/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class FileInputStreamDemo
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.javaio.fileinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo {

	public static void main(String args[]){
		
		FileInputStream fis = null;
		
		try {
			// attach the file to FileInputStream
			fis = new FileInputStream(new File(System.getProperty("user.dir") + "\\resources\\file.txt"));

			// illustrating getChannel() method
			System.out.println(fis.getChannel());

			// illustrating getFD() method
			System.out.println(fis.getFD());

			// illustrating available method
			System.out.println("Number of remaining bytes:" + fis.available());

			// illustrating skip method
			/*
			 * Original File content:
			 * This is my first line
			 * This is my second line
			 */
			fis.skip(8);
			System.out.println("FileContents :");
			// read characters from FileInputStream and write them
			int ch;
			while ((ch = fis.read()) != -1) {
				System.out.print((char) ch);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null ) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
