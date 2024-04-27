/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assessments.Y2023.Trials;

/**
 *
 * @author Cliftonb
 */
public class Team {

    private Player[] players;
    private int size;
    private String teamName;

    public Team(String inN) {
        this.teamName = inN;
        players = new Player[20];
        size = 0;
    }

    public void addPlayer(Player p) {
        players[size] = p;
        size++;
    }

    public void sort() {
        for (int i = 0; i < size; i++) {
            int lowest = i;
            for (int j = lowest; j < size; j++) {
                if (players[lowest].getName().compareToIgnoreCase(players[j].getName()) > 0) {
                    lowest = j;
                }
            }
            if (i != lowest) {
                Player temp = players[i];
                players[i] = players[lowest];
                players[lowest] = temp;
            }
        }
    }
    
    public double getTeamKitCost(){
        double total = 0;
        for (int i = 0; i < size; i++) {
            total += players[i].getKitCost();
        }
        return total;
    }

    private void removePlayer(int index) {
        for (int i = index; i < size - 1; i++) {
            players[i] = players[i + 1];
        }
        size--;
    }

    public String getRoster() {
        String output = teamName + " ROSTER:\n-------------------------------\n";
        for (int i = 0; i < size; i++) {
            output += (i + 1) + ". " + players[i] + "\n";
        }
        return output;
    }

    public void filterByCommitment() {
        for (int i = 0; i < size; i++) {
            Player p = players[i];
            if (!(p.getCommitmentRating() > Player.COMMITMENT_CUTOFF_PERCENTAGE)) {
                removePlayer(i);
                i--;
            }
        }
    }
}
