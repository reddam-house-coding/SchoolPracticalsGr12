/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cliftonb
 */
public class SQLBuilder {

	public static void main(String[] args) {
		try {
			int successful = 0;
			int unsuccessful = 0;
			Scanner sqlFileScanner = new Scanner(new File("sqlfile.txt"));
			DB db = new DB();
			while (sqlFileScanner.hasNext()) {
				String query = sqlFileScanner.nextLine();

				try {
					db.update(query);
					successful++;
				} catch (SQLException ex) {
					unsuccessful++;
				}
			}

			System.out.println("Total: " + (successful + unsuccessful));
			System.out.println("Successful: " + successful);
			System.out.println("Unsuccessful: " + unsuccessful);

		} catch (FileNotFoundException ex) {
			Logger.getLogger(SQLBuilder.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(SQLBuilder.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(SQLBuilder.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

}
