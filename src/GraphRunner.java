
public class GraphRunner {

	public static void main(String ar[]) {
		Graph<String, Integer> g = new Graph<>(true);
		g.addEdge("A", "B", 3);
		System.out.println(g);
	}

}
