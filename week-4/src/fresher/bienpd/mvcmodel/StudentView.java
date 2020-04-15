/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class StudentView
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.mvcmodel;

import java.util.List;

public class StudentView {

	public void showHomePage() {
        System.out.println("Home page of Student");
    }
 
    public void showDetailPage(List<StudentModel> listStudent) {
    	System.out.println("List student: ");
    	System.out.println("---------------------------");
    	System.out.println("Id\t" + "     Name");
    	for (StudentModel student : listStudent) {
            System.out.println(student.getId() + "\t" + student.getName());
		}
    	System.out.println("---------------------------");
    }
    
}
