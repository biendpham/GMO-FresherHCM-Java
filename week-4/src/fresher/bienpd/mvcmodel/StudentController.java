/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class StudentController
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.mvcmodel;

import java.util.ArrayList;
import java.util.List;

public class StudentController {

    private StudentView view;
    private List<StudentModel> listStudent = new ArrayList<>();
 
    public StudentController() {
        listStudent.add(new StudentModel(1, "Phạm Duy Biên"));
        listStudent.add(new StudentModel(2, "Nguyễn Tường Tâm"));
        listStudent.add(new StudentModel(3, "Nguyễn Đại Nghĩa"));
        listStudent.add(new StudentModel(4, "Phạm Trung Sơn"));
        view = new StudentView();
    }
 
    public void showDetail() {
        view.showDetailPage(listStudent);
    }
    
}
