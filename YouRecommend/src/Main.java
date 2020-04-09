import java.util.ArrayList;

public class Main {

	public static ArrayList<YouTuber> SortedByFollowers(String category) {
		
		Graph g = readCSV.generateGraph();
		//using dfs to search according to the category "film and animation".
		DFS d = new DFS(g, category);
		//gets related YouTubers
		ArrayList<YouTuber> a = d.relatedYouTubers();
		
		Sort.MergeSort_Followers(a);
		
		return a;
	}
	
	public static ArrayList<YouTuber> SortedByVideos(String category) {
		
		Graph g = readCSV.generateGraph();
		//using dfs to search according to the category "film and animation".
		DFS d = new DFS(g, category);
		//gets related YouTubers
		ArrayList<YouTuber> a = d.relatedYouTubers();
		
		Sort.QuickSort_Videos(a);
		
		return a;
	}
	
//	public static void main(String[] args) {
//		ArrayList<YouTuber> a = Main.SortedByVideos("Gaming");
//		System.out.println(a.get(0).getTitle());
//	}
	
}
