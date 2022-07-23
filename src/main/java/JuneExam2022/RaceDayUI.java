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
public class RaceDayUI {

	public static void main(String[] args) {
		RaceManager bm = new RaceManager();
		System.out.println(bm);

		System.out.println("Fee for Jali, N: R" + bm.totalRacersFee("Jali, N"));

		System.out.println("Total race day cost: R" + bm.calcRaceDayFees());
	}
}
