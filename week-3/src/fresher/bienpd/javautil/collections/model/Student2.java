/*
 * Copyright (C) 2020 by GMO Runsystem Company
 *
 * Create class Student2
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.javautil.collections.model;

public class Student2 implements Comparable<Student2>{
	
	private int id;
	private String name;
	private int age;

	public Student2(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public int compareTo(Student2 student) {
		// sort student's age by ASC
        if (this.getAge() < student.getAge()) {
            return -1;
        } else if (this.getAge() == student.getAge()) {
            return 0;
        } else {
            return 1;
        }
	}
}
