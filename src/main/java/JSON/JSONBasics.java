/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JSON;

import static JSON.StudentTest.parseStudents;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Cliftonb
 */
public class JSONBasics {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        
        String fileAsStringForJC = Files.readString(new File("student.json").toPath());
        
        JSONArray jar = new JSONArray(fileAsStringForJC);
        
        System.out.println(jar.getJSONObject(1).get("name"));

        
        HashMap<String, String> map = new HashMap<>();
        
        map.put("name", "Bob");
        map.put("name", "James");
        
        
        JSONObject job2 = new JSONObject();
        job2.append("name", "John");
        job2.append("age", 50);
        job2.append("marks", 89);
        
    }
}
