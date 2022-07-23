/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JuneExam2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cliftonb
 */
public class RaceManager {

	private Driver[] drivers = new Driver[100];
	private int driverSize = 0;

	private Race[] races = new Race[100];
	private int raceSize = 0;

	public RaceManager() {
		try {
			Scanner driverFileSc = new Scanner(new File("drivers.txt"));

			while (driverFileSc.hasNextLine()) {
				Scanner lineSc = new Scanner(driverFileSc.nextLine()).useDelimiter(",");

				int id = lineSc.nextInt();
				String fullname = lineSc.next();
				int raceNum = lineSc.nextInt();
				int fee = lineSc.nextInt();

				drivers[driverSize] = new Driver(id, fullname, raceNum, fee);
				driverSize++;
			}

			Scanner raceFileSc = new Scanner(new File("races.txt"));

			while (raceFileSc.hasNextLine()) {
				Scanner lineSc = new Scanner(raceFileSc.nextLine()).useDelimiter(",");

				String name = lineSc.next();
				int numLaps = lineSc.nextInt();

				races[raceSize] = new Race(name, numLaps);

				while (lineSc.hasNext()) {
					races[raceSize].addDriver(drivers[lineSc.nextInt() - 1]);
				}
				raceSize++;

			}

		} catch (FileNotFoundException ex) {
			Logger.getLogger(RaceManager.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public int totalRacersFee(String inName) {
		int totalFee = 0;

		for (int i = 0; i < raceSize; i++) {
			totalFee += races[i].getDriverFee(inName);
		}

		return totalFee;
	}

	public int calcRaceDayFees() {
		int totalFee = 0;

		for (int i = 0; i < driverSize; i++) {
			totalFee += totalRacersFee(drivers[i].getName());
		}

		return totalFee;
	}

	@Override
	public String toString() {
		String output = "Races: \n\n";
		for (int i = 0; i < raceSize; i++) {
			output += races[i].toString() + "\n\n";
		}

		return output;
	}
}
