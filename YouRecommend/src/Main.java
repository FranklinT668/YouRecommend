import java.util.ArrayList;

public class Main {

//	public static ArrayList<YouTuber> SortedByFollowers(String category) {
//
//		Graph g = readCSV.generateGraph();
//		// using dfs to search according to the category "film and animation".
//		DFS d = new DFS(g, category);
//		// gets related YouTubers
//		ArrayList<YouTuber> a = d.relatedYouTubers();
//
//		Sort.MergeSort_Followers(a);
//
//		return a;
//	}
//
//	public static ArrayList<YouTuber> SortedByVideos(String category) {
//
//		Graph g = readCSV.generateGraph();
//		// using dfs to search according to the category "film and animation".
//		DFS d = new DFS(g, category);
//		// gets related YouTubers
//		ArrayList<YouTuber> a = d.relatedYouTubers();
//
//		Sort.QuickSort_Videos(a);
//
//		return a;
//	}

//	public static ArrayList<String> SearchYoutuber(String channel) {
//		// Calls for search function in Search module
//		ArrayList<String> channelInfo = Search.searchChannel(channel);
//		return channelInfo;
//	}
	
	public static ArrayList<YouTuber> SearchCategorySortByFollowers(String category) {
		// Calls for search function in Search module
		ArrayList<YouTuber> categoryInfo = Search.searchCategory(category);
		Sort.MergeSort_Followers(categoryInfo);
		return categoryInfo;
	}
	
	public static ArrayList<YouTuber> SearchCategorySortByVideos(String category) {
		// Calls for search function in Search module
		ArrayList<YouTuber> categoryInfo = Search.searchCategory(category);
		Sort.QuickSort_Videos(categoryInfo);
		return categoryInfo;
	}

	public static void main(String[] args) {

		ArrayList<YouTuber> c = Main.SearchCategorySortByFollowers("Gaming");
		System.out.println(c.get(0).getTitle());
		
		ArrayList<YouTuber> d = Main.SearchCategorySortByVideos("Gaming");
		System.out.println(d.get(0).getTitle());
	}

}
