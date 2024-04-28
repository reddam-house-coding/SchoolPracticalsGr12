/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assessments.Y2023.Trials;

import java.time.LocalDate;

/**
 *
 * @author Cliftonb
 */
public class Player {
    private String name;
    private LocalDate DOB;
    private String position;
    private int numPracticesAttended;
    private String shirtSize;
    
    public static final int PRACTICES_PER_TERM = 20;
    public static final double COMMITMENT_CUTOFF_PERCENTAGE = 80;
    
    public Player(String inN, LocalDate inD, String inP, int inNP, String inSS) {
        this.name = inN;
        this.DOB = inD;
        this.position = inP;
        this.numPracticesAttended = inNP;
        this.shirtSize = inSS;
    }
    
    public int getAgeCategory(){
       int ageYear = LocalDate.now().getYear() - DOB.getYear();
       if (ageYear > 16){
           return 19;
       }
       else{
           return ageYear;
       }
    }
    
    public double getKitCost(){
        double cost = 0;
        switch (shirtSize) {
            case "S":
                cost = 325;
                break;
            case "M":
                cost = 350;
                break;
            case "L":
                cost = 375;
                break;
            case "XL":
                cost = 400;
                break;
            default:
                break;
        }
        
        if(position.equals("Goalkeeper")){
            cost += 75;
        }
        
        if(numPracticesAttended == PRACTICES_PER_TERM){
            cost*=0.95;
        }
        
        return cost;
    }
    
    public String getName(){
        String surname = name.substring(name.indexOf(" ") + 1);
        
        return surname +", "+ name.charAt(0) +".";
    }

    public double getCommitmentRating() {
        double out = numPracticesAttended*1.0/PRACTICES_PER_TERM*10000;
        out = Math.round(out);
        return out/100;
    }

    @Override
    public String toString() {
        return getName() + " (" + shirtSize + ") @ R"+getKitCost() ;
    }
    
}
