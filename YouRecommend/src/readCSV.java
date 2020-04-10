import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @brief readCSV module to read from the database
 */
public class readCSV {

	/**
	 * @brief Manipulate the data from csv file to usable format
	 * @param filepath The file to be read from
	 * @return The data that is stored in a 2D array
	 */
	static String[][] CSVReader(String filepath) {
		String line = "";
		InputStream is = null;
		BufferedReader br = null;
		String[][] dataset = new String[104539][7];
		int row = 0;

		// Uses BufferedReader to read the text from filepath
		try {
			is = FrontEndServlet.class.getClassLoader().getResourceAsStream("/" + filepath);
			br = new BufferedReader(new InputStreamReader(is));
			// If there are still lines within the database
			line = br.readLine();
			while ((line = br.readLine()) != null) {
				// Splits each line by "," and stores it in dataset array
				dataset[row] = line.split(",");
				row++;
			}
			br.close();
			// Checks are errors
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return dataset;
	}
	
	public static Graph generateGraph() {
		String[][] s = CSVReader("channels.csv");
		ArrayList<YouTuber> a = new ArrayList<YouTuber>();
		
		for (int i = 0; i < s.length; i++) {
			YouTuber youTuber = new YouTuber(Integer.parseInt(s[i][0]),s[i][1],s[i][2],
					Integer.parseInt(s[i][3]),s[i][4],s[i][5],Integer.parseInt(s[i][6]));
			a.add(youTuber);
		}
		
		Graph g = new Graph();
		
		int One = 4607;
		int Two = 7183;
		int Ten = 27138;
		int Fifteen = 28015;
		int Seventeen = 31974;
		int Nineteen = 33257;
		int Twenty = 48725;
		int TwentyTwo = 62867;
		int TwentyThree = 66062;
		int TwentyFour = 83756;
		int TwentyFive = 85602;
		int TwentySix = 94778;
		int TwentySeven = 100288;
		int TwentyEight = 103764;
		int TwentyNine = 104430;
		int NinetyNine = 104538;
		
		for (int i = 1; i < One; i++) {
			g.addEdge(a.get(0), a.get(i));
		}
		
		for (int i = 4608; i < Two; i++) {
			g.addEdge(a.get(4607), a.get(i));
		}
		
		for (int i = 7184; i < Ten; i++) {
			g.addEdge(a.get(7183), a.get(i));
		}
		
		for (int i = 27139; i < Fifteen; i++) {
			g.addEdge(a.get(27138), a.get(i));
		}
		
		for (int i = 28016; i < Seventeen; i++) {
			g.addEdge(a.get(28015), a.get(i));
		}
		
		for (int i = 31975; i < Nineteen; i++) {
			g.addEdge(a.get(31974), a.get(i));
		}
		
		for (int i = 33258; i < Twenty; i++) {
			g.addEdge(a.get(33257), a.get(i));
		}
		
		for (int i = 48726; i < TwentyTwo; i++) {
			g.addEdge(a.get(48725), a.get(i));
		}
		
		for (int i = 62868; i < TwentyThree; i++) {
			g.addEdge(a.get(62867), a.get(i));
		}
		
		for (int i = 66063; i < TwentyFour; i++) {
			g.addEdge(a.get(66062), a.get(i));
		}
		
		for (int i = 83757; i < TwentyFive; i++) {
			g.addEdge(a.get(83756), a.get(i));
		}
		
		for (int i = 85603; i < TwentySix; i++) {
			g.addEdge(a.get(85602), a.get(i));
		}
		
		for (int i = 94779; i < TwentySeven; i++) {
			g.addEdge(a.get(94778), a.get(i));
		}
		
		for (int i = 100289; i < TwentyEight; i++) {
			g.addEdge(a.get(100288), a.get(i));
		}
		
		for (int i = 103765; i < TwentyNine; i++) {
			g.addEdge(a.get(103764), a.get(i));
		}
		
		for (int i = 104431; i < NinetyNine; i++) {
			g.addEdge(a.get(104430), a.get(i));
		}
		
		return g;
	}
}
