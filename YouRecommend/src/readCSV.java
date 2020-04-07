import java.io.File;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedReader;

/**
 * @brief readCSV module to read from the database
 */
public class readCSV {

	/**
	 * @brief Manipulate the data from csv file to usable format
	 * @param filepath The file to be read from
	 * @return The data that is stored in a 2D array
	 */
	public static String[][] CSVReader(String filepath) {

		String csvFile = filepath;
		BufferedReader br = null;
		String line = "";
		String[][] dataset = new String[104540][6];
		int row = 0;

		// Uses BufferedReader to read the text from filepath
		try {
			br = new BufferedReader(new FileReader(csvFile));
			// If there are still lines within the database
			while ((line = br.readLine()) != null) {
				// Splits each line by "," and stores it in dataset array
				String temp = line;
				dataset[row] = temp.split(",");
				row++;
			}
			// Checks are errors
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// Closes the file when everything is stored in dataset array
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return dataset;
	}
}
