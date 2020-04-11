import java.util.ArrayList;

public class Main {

	public static ArrayList<YouTuber> getCountryFollowers(YouTuber source) {

		Graph g = readCSV.generateGraph();

		DFS d = new DFS(g, source);
		// gets related YouTubers
		ArrayList<YouTuber> a = d.relatedYouTubers();

		Sort.MergeSort_Followers(a);

		return a;
	}

	public static ArrayList<YouTuber> getCountryVideos(YouTuber source) {

		Graph g = readCSV.generateGraph();

		DFS d = new DFS(g, source);
		// gets related YouTubers
		ArrayList<YouTuber> a = d.relatedYouTubers();

		Sort.QuickSort_Videos(a);

		return a;
	}
//
//	public static ArrayList<String> SearchYoutuber(String channel) {
//		// Calls for search function in Search module
//		ArrayList<String> channelInfo = Search.searchChannel(channel);
//		return channelInfo;
//	}
	
	public static ArrayList<YouTuber> sortedByFollowers(String category) {
		// Calls for search function in Search module
		ArrayList<YouTuber> categoryInfo = Search.searchCategory(category);
		Sort.MergeSort_Followers(categoryInfo);
		return categoryInfo;
	}
	
	public static ArrayList<YouTuber> sortedByVideos(String category) {
		// Calls for search function in Search module
		ArrayList<YouTuber> categoryInfo = Search.searchCategory(category);
		Sort.QuickSort_Videos(categoryInfo);
		return categoryInfo;
	}
	
}
