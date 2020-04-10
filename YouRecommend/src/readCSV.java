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
			if (youTuber.getCountry().equals(""))
				continue;
			a.add(youTuber);
		}
		
		Graph g = new Graph();
		
		boolean[] marked = new boolean[a.size()];
		
		for (int i = 0; i < a.size() - 1; i++) {
					
			for (int j = i + 1; j < a.size(); j++) {
				if (a.get(i).getCountry().equals(a.get(j).getCountry()) && marked[i] == false) {
					g.addEdge(a.get(i), a.get(j));
					marked[j] = true;
				}
				else {
					break;
				}
			}
		}
		
		return g;
	}
	
}
