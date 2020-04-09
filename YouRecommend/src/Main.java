import java.util.ArrayList;

public class Main {

	public static ArrayList<YouTuber> SortedByFollowers(String category) {

		Graph g = readCSV.generateGraph();
		// using dfs to search according to the category "film and animation".
		DFS d = new DFS(g, category);
		// gets related YouTubers
		ArrayList<YouTuber> a = d.relatedYouTubers();

		Sort.MergeSort_Followers(a);

		return a;
	}

	public static ArrayList<YouTuber> SortedByVideos(String category) {

		Graph g = readCSV.generateGraph();
		// using dfs to search according to the category "film and animation".
		DFS d = new DFS(g, category);
		// gets related YouTubers
		ArrayList<YouTuber> a = d.relatedYouTubers();

		Sort.QuickSort_Videos(a);

		return a;
	}

	public static ArrayList<String> SearchYoutuber(String channel) {
		// Calls for search function in Search module
		ArrayList<String> channelInfo = Search.searchChannel(channel);
		return channelInfo;
	}
	
	public static ArrayList<String> SearchCategory(String category) {
		// Calls for search function in Search module
		ArrayList<String> categoryInfo = Search.searchCategory(category);
		return categoryInfo;
	}

	public static void main(String[] args) {


		ArrayList<String> b = Main.SearchYoutuber("t-series");
		System.out.println(b);
		
		ArrayList<String> c = Main.SearchCategory("film and animation");
		System.out.println(c);
	}

}
