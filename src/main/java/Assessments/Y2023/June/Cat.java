/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assessments.Y2023.June;

/**
 *
 * @author Cliftonb
 */
public class Cat {
    private String catName;
    private String ownerName;
    private String breed;
    private int age;
    private double weight;
    private int competitionClass;
    
    public static final int KITTEN = 0;
    public static final int VETERAN = 1;
    public static final int HOUSEHOLD_PET = 2;
    public static final int CHAMPIONSHIP = 3;
    

    public Cat(String catName, String ownerName, String breed, int age, double weight, int competitionClass) {
        this.catName = catName;
        this.ownerName = ownerName;
        this.breed = breed;
        this.age = age;
        this.weight = weight;
        this.competitionClass = competitionClass;
    }

    public int getCompetitionClass() {
        return competitionClass;
    }

    public String generateCompetitionCode(){
        String first = "";
        switch(competitionClass){
            case Cat.KITTEN:
                first += "KIT-";
                break;
            case Cat.VETERAN:
                first += "VET-";
                break;
            case Cat.HOUSEHOLD_PET:
                first += "HOUSE-";
                break;
            case Cat.CHAMPIONSHIP:
                first += "CHAMP-";
                break;
        }
        
        int ran = (int)(Math.random()*900 + 100);
        return first + catName.toUpperCase().substring(0,3) + "-" + ran;
    }
    
    @Override
    public String toString(){
        return generateCompetitionCode() + " : " + catName + ", " + ownerName + ", " + breed;
    }

    
}
