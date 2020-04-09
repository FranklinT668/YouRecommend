import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		Graph g = readCSV.generateGraph();
		//using dfs to search according to the category "film and animation"
		DFS d = new DFS(g, "Film and Animation");
		//gets related YouTubers
		ArrayList<YouTuber> a = d.relatedYouTubers();
		
		Sort.MergeSort_Followers(a);
		
		System.out.println(a.get(1).getFollowers());
	}

}
