import java.util.*;

/**
 * @brief An ADT that represents a graph data structure
 */
public class Graph {
	
	private ArrayList<YouTuber> YouTubers;
	private ArrayList<ArrayList<YouTuber>> adj;
	private int V;
	private int E;
	
	/**
	 * @brief Initializes Graph object.
	 */
	public Graph() {
		YouTubers = new ArrayList<YouTuber>();
		adj = new ArrayList<ArrayList<YouTuber>>();
		V = 0;
		E = 0;
	}
	
	/**
	 * @brief Adds edges to the graph.
	 * @param v1 An vertex of an edge.
	 * @param v2 The other vertex of the edge.
	 */
	public void addEdge(YouTuber v1, YouTuber v2) {
		boolean flag1 = false;
		boolean flag2 = false;
		
		if (contains(v1))
			flag1 = true;
		
		if (contains(v2))
			flag2 = true;
		
		if (flag1 == false) {
			YouTubers.add(v1);
			adj.add(new ArrayList<YouTuber>());
			V++;
		}
		if (flag2 == false) {
			YouTubers.add(v2);
			adj.add(new ArrayList<YouTuber>());
			V++;
		}
		
		int i = this.getYouTuberIndex(v1);
		int j = this.getYouTuberIndex(v2);
		
		adj.get(i).add(v2);
		adj.get(j).add(v1);
		
		E++;
	}
	
	/**
	 * @brief Gets the number of vertices.
	 * @return The number of vertices.
	 */
	public int V() {
		return V;
	}
	
	/**
	 * @brief Gets the number of edges.
	 * @return The number of edges.
	 */
	public int E() {
		return E;
	}
	
	/**
	 * @brief Gets the YouTubers list.
	 * @return The YouTubers list.
	 */
	public ArrayList<YouTuber> getYouTubers(){
		return this.YouTubers;
	}
	
	/**
	 * @brief Gets the adjacency list.
	 * @return The adjacency list.
	 */
	public ArrayList<ArrayList<YouTuber>> getAdj(){
		return adj;
	}
	
	/**
	 * @brief Judges whether the input vertex is contained in
	 * 		  the graph.
	 * @param vertex A vertex that is used to be judged.
	 * @return True if the input vertex is contained in the graph
	 * 		   and false otherwise.
	 */
	public boolean contains(YouTuber vertex) {
		for (YouTuber t: YouTubers) {
			if (t.equals(vertex)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @brief Gets the index of an YouTuber object in the
	 * 		  YouTubers list.
	 * @param v1 An YouTuber object.
	 * @return The index of an YouTuber object in the YouTubers list.
	 */
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
