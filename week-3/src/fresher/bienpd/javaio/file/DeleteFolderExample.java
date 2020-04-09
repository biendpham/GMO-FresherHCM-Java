/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class DeleteFolderExample
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.javaio.file;

import java.io.File;

public class DeleteFolderExample {
    public static void main(String[] args) {
        File folder = new File(System.getProperty("user.dir") + "\\resources\\file2\\folder");
        if (folder.delete()) {
            System.out.println(folder.getName() + " is deleted!");
        } else {
            System.out.println("Delete operation is failed.");
        }
    }
}