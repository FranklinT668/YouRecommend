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

public class Search {

	public static String removeWhiteSpaces(String input) {
		return input.replaceAll("\\s+", "");
	}

	public static void main(String[] args) {
		// Receive input of text file
		String input = "test.csv";
		String[][] dataset = readCSV.CSVReader(input);

		int n = dataset.length - 1;
		String searchInput = new String("ironcladindustries");//input
		boolean founded = false;
		int foundIndex = 0;

		for (int i = 1; i < n; i++) { // i starts at 1 to skip first line in dataset
//			System.out.print( i + " ");
//			
//			System.out.println(dataset[i][4]); 

			if (searchInput.equalsIgnoreCase(dataset[i][4])//case not sensitive and ignores white spaces
					|| removeWhiteSpaces(searchInput).equalsIgnoreCase(removeWhiteSpaces(dataset[i][4]))) {
				founded = true;
				foundIndex = i;
			}
		}
		System.out.println("YOUTUBER EXISTS: " + founded);
		// System.out.println(foundIndex);
		if (founded) {// exists within database
			System.out.println("CATEGORY: " + dataset[foundIndex][1]);
			System.out.println("SUBSCRIBERS: " + dataset[foundIndex][2]);
			System.out.println("JOIN DATE: " + dataset[foundIndex][3]);
			System.out.println("CHANNEL NAME: " + dataset[foundIndex][4]);
			System.out.println("VIDEO COUNT: " + dataset[foundIndex][5]);

		} else {// doesnt exists within database
			System.out.print("YOUTUBER INFORMATION: N/A");
		}
	}

}
