/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JuneExam2022;

/**
 *
 * @author Cliftonb
 */
public class Race {

	private String raceName;
	private int numLaps;

	private Driver[] drivers = new Driver[15];
	private int size;

	public Race(String bandName, int numLaps) {
		this.raceName = bandName;
		this.numLaps = numLaps;

		size = 0;
	}

	public String getRacename() {
		return raceName;
	}

	public void addDriver(Driver inDriver) {
		drivers[size] = inDriver;
		size++;
	}

	public int getDriverFee(String inName) {
		for (int i = 0; i < size; i++) {
			if (drivers[i].getName().equalsIgnoreCase(inName)) {
				return drivers[i].getFee();
			}
		}

		return 0;
	}

	@Override
	public String toString() {
		String output = raceName + ", NumLaps: " + numLaps + ", Drivers: ";
		for (int i = 0; i < size; i++) {
			output += drivers[i].getName() + "; ";
		}

		return output;
	}

}
