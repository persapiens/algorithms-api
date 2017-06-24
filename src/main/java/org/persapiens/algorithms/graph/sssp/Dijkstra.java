package org.persapiens.algorithms.graph.sssp;

import lombok.Getter;
import lombok.Setter;
import org.persapiens.algorithms.graph.Edge;
import org.persapiens.algorithms.graph.ListGraph;
import org.persapiens.algorithms.graph.Vertex;
import org.persapiens.algorithms.graph.mst.PrimMSTUtil;
import org.persapiens.algorithms.queue.PriorityQueue;

/**
 *
 * @author marcelo fernandes
 */
@Getter
@Setter
public class Dijkstra {	
	public Vertex[] create(ListGraph graph, Vertex s) {
		SSSPUtil.initializeSingleSource(graph, s);

		Vertex[] vertexes = graph.getVertexes();
		
		Vertex[] S = new Vertex[vertexes.length];
		int counterS = 0;
		
		PriorityQueue<Vertex> Q = PrimMSTUtil.createPriorityQueue(vertexes);

		Relax relax = new Relax();
		relax.addListener(VertexPriorityQueueUpdater.builder().Q(Q).build());
		
		while(!Q.isEmpty()) {
			Vertex u = Q.extract();
			S[counterS] = u;
			counterS ++;
			for (Edge edge : graph.getAdjacencyList(u)) {
				relax.relax(edge);
			}
		}
		
		return S;
	}
}
