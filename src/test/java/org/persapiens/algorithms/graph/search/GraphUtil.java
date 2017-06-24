package org.persapiens.algorithms.graph.search;

import org.persapiens.algorithms.graph.Edge;
import org.persapiens.algorithms.graph.Vertex;
import org.testng.annotations.Test;

/**
 *
 * @author marcelo
 */
@Test
public class GraphUtil {
	public static Edge[] edges(Vertex u, Vertex... vs) {
		int[] weights = new int[vs.length];
		for (int index = 0; index < weights.length; index ++) {
			weights[index] = 0;
		}
		return edges(u, vs, weights);
	}
	
	public static Edge[] edges(Vertex u, Vertex[] vs, int... weights) {
		Edge[] result = new Edge[weights.length];
		for (int index = 0; index < weights.length; index ++) {
			result[index] = edge(u, vs[index], weights[index]);
		}
		return result;
	}
	
	public static Edge edge(Vertex u, Vertex v, int w) {
		return Edge.builder()
			.u(u)
			.v(v)
			.w(w)
			.build();
	}
}
