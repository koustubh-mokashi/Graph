import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph<V, W> {

	private Map<V, List<Edge<V, W>>> links = new HashMap<>();

	private boolean isBidirectional = false;

	public static class Edge<V, W> {

		private V v1;

		private V v2;

		private W w;

		public V getV1() {
			return v1;
		}

		public void setV1(V v1) {
			this.v1 = v1;
		}

		public V getV2() {
			return v2;
		}

		public void setV2(V v2) {
			this.v2 = v2;
		}

		public W getW() {
			return w;
		}

		public void setW(W w) {
			this.w = w;
		}

	}

	public Graph(boolean isBidirectional) {
		this.isBidirectional = isBidirectional;
	}

	public void addVertex(V v) {
		links.put(v, new LinkedList<>());
	}

	public void addEdge(V start, V end, W weight) {
		Edge<V, W> e = new Edge<>();
		e.setW(weight);
		e.setV1(start);
		e.setV2(end);
		if (links.get(start) != null) {
			links.get(start).add(e);
		} else {
			List<Edge<V, W>> lst = new LinkedList<Edge<V, W>>();
			lst.add(e);
			links.put(start, lst);
		}
		if (isBidirectional) {
			if (links.get(end) != null) {
				links.get(end).add(e);
			} else {
				List<Edge<V, W>> lst = new LinkedList<Edge<V, W>>();
				lst.add(e);
				links.put(end, lst);
			}
		}
	}

}
