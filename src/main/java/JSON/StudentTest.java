/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSON;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Cliftonb
 */
public class StudentTest {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("student.json"));
		String studentJSON = "";
		while (sc.hasNext()) {
			studentJSON += sc.nextLine();
		}

		Student[] s = parseStudents(studentJSON);
		System.out.println(s);

		JSONObject job2 = new JSONObject();
		job2.append("name", "John");
		job2.append("age", 50);
		job2.append("marks", 89);

	}

	public static Student parseStudent(String studentInJSON) {
		JSONObject job = new JSONObject(studentInJSON);

		int id = job.getInt("id");
		String name = job.getString("name");
		String surname = job.getString("surname");
		int classID = job.getInt("classID");

		return new Student(id, name, surname, classID);
	}

	public static Student[] parseStudents(String studentsInJSON) {
		JSONArray jar = new JSONArray(studentsInJSON);

		Student[] students = new Student[jar.length()];
		for (int i = 0; i < jar.length(); i++) {
			JSONObject job = jar.getJSONObject(i);

			int id = job.getInt("id");
			String name = job.getString("name");
			String surname = job.getString("surname");
			int classID = job.getInt("classID");

			students[i] = new Student(id, name, surname, classID);
		}

		return students;
	}
}
