/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class DeleteFileExample
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.javaio.file;

import java.io.File;

public class DeleteFileExample {
    public static void main(String[] args) {
        File file = new File(System.getProperty("user.dir") + "\\resources\\file2\\file2.txt");
        if (file.delete()) {
            System.out.println(file.getName() + " is deleted!");
        } else {
            System.out.println("Delete operation is failed.");
        }
    }
}
