import java.util.ArrayList;

/**
 * @brief Depth-first Search.
 */
public class DFS {
	private YouTuber temp;
	private boolean[] marked;
	private YouTuber[] edgeTo;
	private Graph g;

    /**
	 * @brief The constructor of depth first search.
	 * @param g An undirected graph.
	 * @param category The category of a YouTuber.
	 */
	public DFS(Graph g, String category) {
		
		for (YouTuber u: g.getYouTubers()) {
			if (u.getCategory_name().equals(category)) {
				temp = u;
			}
		}
		marked = new boolean[g.V()];
		edgeTo = new YouTuber[g.V()];
		this.g = g;
		dfs(g, temp);
	}
	
	/**
	 * @brief Depth-first search.
	 * @param g An undirected graph.
	 * @param source The source vertex.
	 */
	private void dfs(Graph g, YouTuber source) {
		int i = g.getYouTuberIndex(source);
		marked[i] = true;
		for (YouTuber u: g.getAdj().get(i)) {
			if (!marked[g.getYouTuberIndex(u)]) {
				edgeTo[g.getYouTuberIndex(u)] = source;
				dfs(g, u);
			}
		}
	}
	
	/**
	 * @brief Checks whether a vertex has been visited.
	 * @param u A vertex in type of YouTuber.
	 * @return True if the YouTuber object has been visited
	 * 		   and false otherwise.
	 */
	public boolean visited(YouTuber u) {
		return marked[g.getYouTuberIndex(u)];
	}
	
	/**
	 * @brief Gets the related YouTubers.
	 * @return The related YouTubers.
	 */
	public ArrayList<YouTuber> relatedYouTubers(){
		ArrayList<YouTuber> a = new ArrayList<YouTuber>();
		for (int i = 0; i < marked.length; i++) {
			if (marked[i] == true) {
				a.add(g.getYouTubers().get(i));
			}
		}
		
		return a;
	}

}
