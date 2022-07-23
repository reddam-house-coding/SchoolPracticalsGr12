/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSON;

/**
 *
 * @author Cliftonb
 */
public class Student {

	private int id;
	private String name;
	private String surname;
	private int classId;

	public Student(int id, String name, String surname, int classId) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.classId = classId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	@Override
	public String toString() {
		return "Student{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", classId=" + classId + '}';
	}

}
