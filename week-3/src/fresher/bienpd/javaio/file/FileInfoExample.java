/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class FileInfoExample
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.javaio.file;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

public class FileInfoExample {
	
	public static void main(String[] args) {
        // Tạo một đối tượng File đại diện cho một đường dẫn không tồn tại
        File file = new File(System.getProperty("user.dir") + "\\resources\\fileNotExist.txt");
 
        // Kiểm tra sự tồn tại.
        System.out.println("Path exists : " + file.exists());
        
        // Tạo lại đối tượng File
        file = new File(System.getProperty("user.dir") + "\\resources\\file.txt");
        System.out.println("Path exists : " + file.exists());
        
        if (file.exists()) {
            // Kiểm tra có phải có phải là một folder hay không?
            System.out.println("isDirectory : " + file.isDirectory());
 
            // Kiểm tra có phải là một đường dẫn ẩn hay không?
            System.out.println("isHidden : " + file.isHidden());
 
            // Lấy tên file/ folder
            System.out.println("Simple Name: " + file.getName());
 
            // Đường dẫn tuyêt đối.
            System.out.println("Absolute Path: " + file.getAbsolutePath());
 
            // Kiểm tra kích thước file:
            System.out.println("Length : " + file.length() + " (bytes)");
 
            // Thời điểm sửa lần cuối
            long lastMofifyInMillis = file.lastModified(); // milliseconds
            Calendar lastModifyDate = Calendar.getInstance();
            lastModifyDate.setTimeInMillis(lastMofifyInMillis);
            System.out.println("Last modify date: " + lastModifyDate.getTime());
        }
    }

}
