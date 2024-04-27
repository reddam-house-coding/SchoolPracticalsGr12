/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assessments.Y2023.Trials;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cliftonb
 */
public class TeamManager {

    private Team[] teams = new Team[4];

    public TeamManager() {
        teams[0] = new Team("u14");
        teams[1] = new Team("u15");
        teams[2] = new Team("u16");
        teams[3] = new Team("Open");
        
        try {
            Scanner fileSc = new Scanner(new File("PlayerDetails.txt"));
            while (fileSc.hasNext()) {
                Scanner lineSc = new Scanner(fileSc.nextLine()).useDelimiter(",");

                String name = lineSc.next();
                LocalDate DOB = LocalDate.parse(lineSc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                String position = lineSc.next();
                int num_practices = lineSc.nextInt();
                String size = lineSc.next();
                
                Player p = new Player(name, DOB, position, num_practices, size);
                
                switch(p.getAgeCategory()){
                    case 14 -> teams[0].addPlayer(p);
                    case 15 -> teams[1].addPlayer(p);
                    case 16 -> teams[2].addPlayer(p);
                    case 19 -> teams[3].addPlayer(p);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TeamManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getTournamentStats(){
        String output = "";
        double totalCost = 0;
        for (int i = 0; i < teams.length; i++) {
            totalCost += teams[i].getTeamKitCost();
            output += teams[i].getRoster() +"Team kit cost: R" + teams[i].getTeamKitCost()+"\n\n";
        }
        return output +"Total for all teams: R" + totalCost;
    }
    
    public void sortAndFilterTeams(){
        for (int i = 0; i < teams.length; i++) {
            teams[i].filterByCommitment();
            teams[i].sort();
        }
    }
    
    //public double getCostForChild()
    
}
