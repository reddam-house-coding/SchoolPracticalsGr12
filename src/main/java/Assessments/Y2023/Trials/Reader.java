/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assessments.Y2023.Trials;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Cliftonb
 */
public class Reader {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileSc = new Scanner(new File("soccer.csv"));
        int [] ageCount = new int[4];
        
        String output = "";
        while(fileSc.hasNext()){
            String line = fileSc.nextLine();
            Scanner lineSc = new Scanner(line).useDelimiter(",");
            
            String name = lineSc.next();
            LocalDate DOB = LocalDate.parse(lineSc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            String position = lineSc.next();
            int num_practices = lineSc.nextInt();
            
            int age = LocalDate.now().getYear() -DOB.getYear();
            int category = 0;
            
            category = switch (age) {
                case 14 -> 0;
                case 15 -> 1;
                case 16 -> 2;
                default -> 3;
            };
            
            if(ageCount[category] < 20){
                ageCount[category]++;
                output += line+"\n";
            }
            
            
            
            System.out.println(name +", "+ age +", " + position+", "+num_practices );
        }
        System.out.println(Arrays.toString(ageCount));
        System.out.println(output);
        
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        pw.write(output);
        pw.close();
    }
}
