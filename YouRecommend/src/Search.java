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

	public static ArrayList<String> searchCategory(String channel) {
		// Receive input of the dataset csv file
		String input = "channels.csv";
		// Stores the input in a 2D array
		String[][] dataset = readCSV.CSVReader(input);
		int n = dataset.length - 1;
		// Search Youtube channel as input
		String searchInput = new String(channel);
		
		int foundIndex = 0;
		// Arraylist of channel information about the searched channel
		ArrayList<String> channelInfo = new ArrayList<String>();
		// Sequential search in the dataset to match searchInput to the corresponding
		// youtube channels
		for (int i = 1; i < n; i++) {
			// The input's case is not sensitive and ignores white spaces
			if (searchInput.equalsIgnoreCase(dataset[i][1])
					|| removeWhiteSpaces(searchInput).equalsIgnoreCase(removeWhiteSpaces(dataset[i][1]))) {
				
				foundIndex = i;
				channelInfo.add(dataset[foundIndex][5]);
			}
		}

		return channelInfo;
	}

	
	
	
	/**
	 * @brief Search function that searches for a specific youtube channel
	 * @param channel The channel being searched
	 * @return An arraylist of the information about that specific channel
	 */
	public static ArrayList<String> searchChannel(String channel) {
		// Receive input of the dataset csv file
		String input = "channels.csv";
		// Stores the input in a 2D array
		String[][] dataset = readCSV.CSVReader(input);
		int n = dataset.length - 1;
		// Search Youtube channel as input
		String searchInput = new String(channel);
		boolean founded = false;
		int foundIndex = 0;
		// Arraylist of channel information about the searched channel
		ArrayList<String> channelInfo = new ArrayList<String>();
		// Sequential search in the dataset to match searchInput to the corresponding
		// youtube channels
		for (int i = 1; i < n; i++) {
			// The input's case is not sensitive and ignores white spaces
			if (searchInput.equalsIgnoreCase(dataset[i][5])
					|| removeWhiteSpaces(searchInput).equalsIgnoreCase(removeWhiteSpaces(dataset[i][5]))) {
				founded = true;
				foundIndex = i;
			}
		}
		// Channel exists within the database
		if (founded) {
			channelInfo.add(dataset[foundIndex][5]);
			channelInfo.add(dataset[foundIndex][1]);
			channelInfo.add(dataset[foundIndex][2]);
			channelInfo.add(dataset[foundIndex][3] + " Subscribers");
			channelInfo.add(dataset[foundIndex][4]);
			channelInfo.add(dataset[foundIndex][6] + " Videos");
			// Channel does not exist within the database
		} else {
			channelInfo.add("Youtuber does not exist");
			// System.out.print("YOUTUBER INFORMATION: N/A");
		}

		return channelInfo;

	}

	public static void main(String[] args) {
		ArrayList<String> test = searchChannel("pew die pie");
		System.out.println(test);
		ArrayList<String> test2 = searchCategory("film and animation");
		System.out.println(test2);
	}

}
