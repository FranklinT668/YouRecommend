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
 * @brief An ADT that performs search in the database.
 */
public class Search {

	/**
	 * @brief Function that remove all white spaces from a string
	 * @param input The string which whitespace are to be removed
	 * @return The string without whitespace
	 */
	public static String removeWhiteSpaces(String input) {
		return input.replaceAll("\\s+", "");
	}

	/**
	 * @brief Driver function that displays the all the channel information being
	 *        searched
	 */
	public static void main(String[] args) {
		// Receive input of the dataset csv file
		String input = "test.csv";
		// Stores the input in a 2D array
		String[][] dataset = readCSV.CSVReader(input);
		int n = dataset.length - 1;
		// Search Youtube channel as input
		String searchInput = new String("Pew Die Pie");
		boolean founded = false;
		int foundIndex = 0;
		// Sequential search in the dataset to match searchInput to the corresponding
		// youtube channels
		for (int i = 1; i < n; i++) {
			// The input's case is not sensitive and ignores white spaces
			if (searchInput.equalsIgnoreCase(dataset[i][4])
					|| removeWhiteSpaces(searchInput).equalsIgnoreCase(removeWhiteSpaces(dataset[i][4]))) {
				founded = true;
				foundIndex = i;
			}
		}
		System.out.println("YOUTUBER EXISTS: " + founded);
		// Channel exists within the database
		if (founded) {
			System.out.println("CATEGORY: " + dataset[foundIndex][1]);
			System.out.println("SUBSCRIBERS: " + dataset[foundIndex][2]);
			System.out.println("JOIN DATE: " + dataset[foundIndex][3]);
			System.out.println("CHANNEL NAME: " + dataset[foundIndex][4]);
			System.out.println("VIDEO COUNT: " + dataset[foundIndex][5]);
			// Channel does not exist within the database
		} else {
			System.out.print("YOUTUBER INFORMATION: N/A");
		}
	}

}
