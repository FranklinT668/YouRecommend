import java.util.ArrayList;


public class DFS {
	private YouTuber temp;
	private boolean[] marked;
	private YouTuber[] edgeTo;
	private Graph g;

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
	
	public boolean visited(YouTuber u) {
		return marked[g.getYouTuberIndex(u)];
	}
	
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
