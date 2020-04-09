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
package fresher.bienpd.javaio.printwriter;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class PrintWriterExample {

	public static void main(String[] args) throws Exception {
		// Data to write on Console using PrintWriter
		PrintWriter writer = new PrintWriter(System.out);
		writer.write("Data to write on Console using PrintWriter");
		writer.flush();
		writer.close();

		// Data to write in File using PrintWriter
		PrintWriter writer1 = null;
		writer1 = new PrintWriter(new File(System.getProperty("user.dir") + "\\resources\\test.txt"));
		writer1.write("Data to write in File using PrintWriter");
		writer1.flush();
		writer1.close();
	}

}
