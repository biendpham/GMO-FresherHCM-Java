/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class SerializationDemo2
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.interfaces.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationDemo2 {

	public static void main(String[] args) {

		// write object
		Student2 student1 = new Student2(1L, "Duy Bien");

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(System.getProperty("user.dir") + "\\resources\\student.txt");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(student1);
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

		// read object
		Student2 student2 = null;

		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "\\resources\\student.txt");
			ois = new ObjectInputStream(fis);
			
			student2 = (Student2) ois.readObject();
			System.out.println(student2.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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
