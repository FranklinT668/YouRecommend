import java.util.*;

public class Graph {
	
	private ArrayList<YouTuber> YouTubers;
	private ArrayList<ArrayList<YouTuber>> adj;
	private int V;
	private int E;
	
	public Graph() {
		YouTubers = new ArrayList<YouTuber>();
		adj = new ArrayList<ArrayList<YouTuber>>();
		V = 0;
		E = 0;
	}

	public void addEdge(YouTuber source, YouTuber destination) {
		boolean flag1 = false;
		boolean flag2 = false;
		
		if (contains(source))
			flag1 = true;
		
		if (contains(destination))
			flag2 = true;
		
		if (flag1 == false) {
			YouTubers.add(source);
			adj.add(new ArrayList<YouTuber>());
			V++;
		}
		if (flag2 == false) {
			YouTubers.add(destination);
			adj.add(new ArrayList<YouTuber>());
			V++;
		}
		
		int i = this.getYouTuberIndex(source);
		int j = this.getYouTuberIndex(destination);
		
		adj.get(i).add(destination);
		adj.get(j).add(source);
		
		E++;
	}
	
	public int V() {
		return V;
	}
	
	public int E() {
		return E;
	}
	
	public ArrayList<ArrayList<YouTuber>> getAdj(){
		return adj;
	}
	
	public boolean contains(YouTuber vertex) {
		for (YouTuber t: YouTubers) {
			if (t.equals(vertex)) {
				return true;
			}
		}
		return false;
	}
	
	public int getYouTuberIndex(YouTuber v1) {
		int i = -1;
		for (YouTuber v: this.YouTubers) {
			if (v.equals(v1)) {
				i = YouTubers.indexOf(v);
			}
		}
		if (i == -1)
			throw new RuntimeException("invalid vertex");
		else
			return i;
	}
	
}
