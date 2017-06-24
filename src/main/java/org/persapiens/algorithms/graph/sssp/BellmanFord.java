package org.persapiens.algorithms.graph.sssp;

import lombok.Getter;
import lombok.Setter;
import org.persapiens.algorithms.graph.Edge;
import org.persapiens.algorithms.graph.Graph;
import org.persapiens.algorithms.graph.Vertex;

/**
 *
 * @author marcelo fernandes
 */
@Getter
@Setter
public class BellmanFord {	
	public boolean create(Graph graph, Vertex s) {
		boolean result = true;
		SSSPUtil.initializeSingleSource(graph, s);
		Relax relax = new Relax();
		for (int i = 1; i <= graph.getVertexes().length -1; i++) {
			for (Edge edge : graph.getEdges()) {
				relax.relax(edge);
			}
		}
		for (Edge edge : graph.getEdges()) {
			Vertex u = edge.getU();
			Vertex v = edge.getV();
			if (v.getD() > u.getD() + edge.getW()) {
				result = false;
			}
		}
		return result;
	}
}
