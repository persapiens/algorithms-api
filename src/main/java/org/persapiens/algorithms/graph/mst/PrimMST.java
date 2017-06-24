package org.persapiens.algorithms.graph.mst;

import lombok.Getter;
import lombok.Setter;
import org.persapiens.algorithms.graph.Edge;
import org.persapiens.algorithms.graph.Graph;
import org.persapiens.algorithms.graph.Vertex;
import static org.persapiens.algorithms.graph.Vertex.NIL;
import org.persapiens.algorithms.queue.PriorityQueue;

/**
 *
 * @author marcelo fernandes
 */
@Getter
@Setter
public class PrimMST {	
	public void create(Graph graph, Vertex r) {
		for (Vertex u : graph.getVertexes()) {
			u.setD(Integer.MAX_VALUE);
			u.setParent(NIL);
		}

		r.setD(0);
		
		PriorityQueue<Vertex> Q = PrimMSTUtil.createPriorityQueue(graph.getVertexes());
			
		while(!Q.isEmpty()) {
			Vertex u = Q.extract();
			for(Edge edge : graph.getEdges(u)) {
				Vertex v = edge.getV();
				if (Q.contains(v) && edge.getW() < v.getD()) {
					v.setParent(u);
					v.setD(edge.getW());
					Q.updateKey(v);
				}
			}
		}
	}
}
