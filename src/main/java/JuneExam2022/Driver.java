/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JuneExam2022;

import java.util.Scanner;

/**
 *
 * @author Cliftonb
 */
public class Driver {

	private int id;
	private String fullname;
	private int raceNumber;
	private int fee;

	public Driver(int id, String fullname, int raceNumber, int fee) {
		this.id = id;
		this.fullname = fullname;
		this.raceNumber = raceNumber;
		this.fee = fee;
	}

	public String getName() {
		Scanner nameSc = new Scanner(fullname);
		String firstName = nameSc.next();
		String surname = nameSc.next();

		return surname + ", " + firstName.charAt(0);
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	@Override
	public String toString() {
		return getName() + " is number " + raceNumber + ". Fee R" + fee;
	}

}
