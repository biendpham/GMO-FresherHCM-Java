/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class SerializationDemo1
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.interfaces.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationDemo1 {

	public static void main(String[] args) {

		Student1 student = new Student1(1L, "Duy Bien");

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			
			fos = new FileOutputStream(System.getProperty("user.dir") + "\\resources\\student.txt");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(student);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
