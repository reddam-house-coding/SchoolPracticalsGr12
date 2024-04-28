/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assessments.Y2023.June;

/**
 *
 * @author Cliftonb
 */
public class Judge {
    private String name;
    private int[] qualifiedClasses;
    private int experienceInYears;
    private Cat[] slots = new Cat[20];
    private int currentSlot = 0;

    public Judge(String name, int experienceInYears, int[] inCC) {
        this.name = name;
        this.experienceInYears = experienceInYears;
        this.qualifiedClasses = inCC;
        
    }
    
    
    public boolean isQualified(int competitionClass){
        return registeredCompetitionClasses[competitionClass];
    }
    
    public void addCat(Cat c){
        slots[currentSlot] = c;
        currentSlot++;
    }

    public boolean isFull(){
        if(currentSlot == slots.length){
            return true;
        }
        return false;
    }
    
    public String printSchedule(){
        String out = "Schedule for: " + name +"\n";
        for(int slot=0; slot<currentSlot;slot++ ){
            int hour = 8 + slot/4;
            int min = 0 + (slot%4)*15;
            
            String minStr = "00";
            String time = "" + hour + ":" + (min==0?(minStr):(min+""));
            out += time + " " + slots[slot].generateCompetitionCode() + "\n";
        }
        return out;
    }
}
