/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assessments.Y2023.June;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cliftonb
 */
public class Schedule {
    private Judge[] judges;
    private int judgeSize;
    private Cat[] unassignedCats;
    private int catSize;
    
    public Schedule(){
        judges = new Judge[50];
        judgeSize = 0;
        unassignedCats = new Cat[200];
        catSize = 0;
        try {
            //Judges
            Scanner fileSc = new Scanner(new File("judges.txt"));
            while(fileSc.hasNextLine()){
                Scanner lineSc = new Scanner(fileSc.nextLine()).useDelimiter("#");
                
                String name = lineSc.next();
                String[] classesStr = lineSc.next().split(",");
                int experience = lineSc.nextInt();
                
                int[] classesInt = new int[classesStr.length];
                for(int i = 0; i < classesStr.length; i++){
                    classesInt[i] = Integer.parseInt(classesStr[i]);
                }
                
                judges[judgeSize] = new Judge(name, experience, classesInt);
                judgeSize++;
                
            }
            
            
            fileSc = new Scanner(new File("cats.txt"));
            while(fileSc.hasNextLine()){
                Scanner lineSc = new Scanner(fileSc.nextLine()).useDelimiter("#");

                String name = lineSc.next();    
                String ownerName = lineSc.next();    
                String breed = lineSc.next();    
                int age = lineSc.nextInt();    
                double weight = lineSc.nextDouble();    
                int competitionClass = lineSc.nextInt();    
                
                unassignedCats[catSize] = new Cat(name, ownerName, breed, age, weight, competitionClass);
                catSize++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Schedule.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Cats: " + catSize);
        System.out.println("Judges: " + judgeSize);
        addCatsToJudges();
        
    }
    
    private void addCatsToJudges(){
        int catsProcessed = 0;
        for(int i = 0; i < catSize; i++){
            int count = 0;
            for(int j = 0; j < judgeSize; j++){
                if(judges[j].isQualified(unassignedCats[i].getCompetitionClass()) && !judges[j].isFull()){
                    judges[j].addCat(unassignedCats[i]);
                    count ++;
                    catsProcessed ++;
                    if(count ==3){
                        break;
                        
                    }
                }
            }
        }
        
        System.out.println("Cats processed: " + catsProcessed);
    }
    
    public String printSchedule(){
        String out = "";
        for(int i = 0; i < judgeSize; i ++){
            out += judges[i].printSchedule() + "\n\n";
        }
        return out;
    }
}
