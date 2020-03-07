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


public class readCSV {
	public static void main(String[] args) {
		// Receive input of text file
		String input = "test.csv";
		String[][] dataset = CSVReader(input);

		int n = dataset.length-1;

		for(int i=0;i<n;i++) { 
			System.out.print("\n" + i + " ");
			for(int j=0; j<6; j++) {
				System.out.print(dataset[i][j] + " "); 
				}
			}		
		
		}

	public static String[][] CSVReader(String filepath) {

	     String csvFile = filepath;
	     BufferedReader br = null;
	     String line = "";
	     String[][] dataset = new String[104540][6];
	     int row = 0; 		
	     
	     try {

	         br = new BufferedReader(new FileReader(csvFile));
	         while ((line = br.readLine()) != null) {
	         	
	         	String temp = line;
	         	dataset[row] = temp.split(",");
	         	row++;
	         }

	     } catch (FileNotFoundException e) {
	         e.printStackTrace();
	     } catch (IOException e) {
	         e.printStackTrace();
	     } finally {
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
