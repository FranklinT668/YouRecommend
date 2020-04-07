import java.util.*;

public class Graph {
	
	private Map<YouTuber, LinkedList<YouTuber>> adj;
	private int E;
	
	public Graph() {
		adj = new HashMap<>();
	}

	public void add(YouTuber source, YouTuber destination) {
		if (!contains(source)) 
			adj.put(source, new LinkedList<YouTuber>());
		
		
		if (!contains(destination))
			adj.put(destination, new LinkedList<YouTuber>());
		
		for (YouTuber u: adj.keySet()) {
			if (u.equals(source))
				adj.get(u).add(destination);
		}
		
		for (YouTuber u: adj.keySet()) {
			if (u.equals(destination))
				adj.get(u).add(source);
		}
		
		E++;
	}
	
	public int V() {
		return adj.keySet().size();
	}
	
	public int E() {
		return E;
	}
	
	public boolean contains(YouTuber vertex) {
		for (YouTuber t: adj.keySet()) {
			if (t.equals(vertex)) {
				return true;
			}
		}
		return false;
	}
	
}
